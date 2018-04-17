package assignmentB;

import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class AssignmentB01
{
    // DEBUG FLAGS
    private static boolean PRINT_DEBUG_MESSAGES = false;
    private static boolean PRINT_COMPLETION_STATS = true;
    private static boolean DEBUG_TIMING = true; // true: seconds, false: minutes

    // Constants
    private static long ARRIVAL_TIMER_PERIOD = 50;   // milliseconds
    private static long CHECKER_TIMER_PERIOD = 50;   // milliseconds

    private static String ARRIVAL_TIMER_NAME = "arrivalTimer";

    private static String CHECKER_A_TIMER_NAME = "checkerATimer";
    private static String CHECKER_B_TIMER_NAME = "checkerBTimer";
    private static String CHECKER_C_TIMER_NAME = "checkerCTimer";
    private static long DEFAULT_CHECKER_PEEK_TIME = 3 * 1000;

    private static long MIN_CHECK_TIME = DEBUG_TIMING ? 1 * 1000 : 1 * 1000 * 60;
    private static long MAX_CHECK_TIME = DEBUG_TIMING ? 15 * 1000 : 15 * 1000 * 60;
    private static long MIN_ARRIVAL_TIME = 0;
    private static long MAX_ARRIVAL_TIME = DEBUG_TIMING ? 10 * 1000 : 10 * 1000 * 60;

    // Members
    private static int population = 0;
    private static int numArrived = 0;
    private static int numProcessed = 0;
    private static int capacityA = 0;
    private static int capacityB = 0;
    private static int capacityC = 0;
    private static int numAExpeditions = 0;
    private static int numBExpeditions = 0;
    private static int numCExpeditions = 0;

    private static int numAISE = 0; // num Checker A IllegalStateExceptions
    private static int numBISE = 0; // num Checker B IllegalStateExceptions
    private static int numCNSEE = 0; // num Checker C NoSuchElementExceptions

    private static long startTime = 0;
    private static long endTime = 0;

    private static ArrayBlockingQueue<Person> queueA;
    private static ArrayBlockingQueue<Person> queueB;
    private static ArrayBlockingQueue<Person> queueC;

    private static long nextArrivalTime = 0;
    private static Timer arrivalTimer;

    private static long checkerANextPeekTime = 0;
    private static long checkerANextProcessTime = 0;
    private static long checkerBNextPeekTime = 0;
    private static long checkerBNextProcessTime = 0;
    private static long checkerCNextPeekTime = 0;
    private static long checkerCNextProcessTime = 0;
    private static Timer checkerATimer;
    private static Timer checkerBTimer;
    private static Timer checkerCTimer;

    private static class Policy
    {
        private int queueAMaxSize;
        private int queueBMaxSize;
        private int queueCMaxSize;
        private long checkerAPeekInterval;
        private long checkerBPeekInterval;
        private long checkerCPeekInterval;


        public Policy(int queueAMaxSize, int queueBMaxSize, int queueCMaxSize)
        {
            this.queueAMaxSize = queueAMaxSize;
            this.queueBMaxSize = queueBMaxSize;
            this.queueCMaxSize = queueCMaxSize;
            this.checkerAPeekInterval = DEFAULT_CHECKER_PEEK_TIME;
            this.checkerBPeekInterval = DEFAULT_CHECKER_PEEK_TIME;
            this.checkerCPeekInterval = DEFAULT_CHECKER_PEEK_TIME;
        }

        public Policy(int queueAMaxSize, int queueBMaxSize, int queueCMaxSize, long checkerAPeekInterval, long checkerBPeekInterval, long checkerCPeekInterval)
        {
            this.queueAMaxSize = queueAMaxSize;
            this.queueBMaxSize = queueBMaxSize;
            this.queueCMaxSize = queueCMaxSize;
            this.checkerAPeekInterval = checkerAPeekInterval;
            this.checkerBPeekInterval = checkerBPeekInterval;
            this.checkerCPeekInterval = checkerCPeekInterval;
        }

        @Override
        public String toString()
        {
            return "Policy{" +
                    "queueAMaxSize=" + queueAMaxSize +
                    ", queueBMaxSize=" + queueBMaxSize +
                    ", queueCMaxSize=" + queueCMaxSize +
                    ", checkerAPeekInterval=" + checkerAPeekInterval +
                    ", checkerBPeekInterval=" + checkerBPeekInterval +
                    ", checkerCPeekInterval=" + checkerCPeekInterval +
                    '}';
        }
    }

    // Arrival timer task
    private static class ArrivalTask extends TimerTask
    {
        @Override
        public void run()
        {
            // Get current time
            long curTime = System.currentTimeMillis();

            // If it is time for the next Person to arrive, then put the Person in either Queue A or B
            if (curTime >= nextArrivalTime && population > numArrived)
            {
                // Check if Queue A is full
                boolean isQueueAFull = queueA.size() >= capacityA;

                // Check if Queue B is full
                boolean isQueueBFull = queueB.size() >= capacityB;

                // If both Queue A and B are full, then do nothing
                if (isQueueAFull && isQueueBFull)
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " ArrivalTask.run() -- BOTH Queue A and B are full");
                    }
                }
                else if (isQueueAFull)  // Put Person in Queue B
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " ArrivalTask.run() -- Queue A is full");
                    }
                    putPersonInQueue(2, new Person(++numArrived));
                }
                else if (isQueueBFull)  // Put Person in Queue A
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " ArrivalTask.run() -- Queue B is full");
                    }
                    putPersonInQueue(1, new Person(++numArrived));
                }
                else    // Put Person in random Queue
                {
                    putPersonInQueue(genQueueSelection(), new Person(++numArrived));
                }
            }

            // Finally, check for shutdown case
            if (numProcessed == population)
            {
                System.out.print("\n" + getCurRuntime() + " ArrivalTask.run() -- All Persons have been processed");
                shutdown();
            }
        }
    }

    // Checker A timer task
    private static class CheckerATask extends TimerTask
    {
        private static Policy policy;

        public CheckerATask(Policy p)
        {
            super();

            policy = p;
            checkerANextPeekTime = System.currentTimeMillis() + (p.checkerAPeekInterval * 1000);
            checkerANextProcessTime = genNextCheckerProcessTime();
        }

        @Override
        public void run()
        {
            // Get current time
            long curTime = System.currentTimeMillis();

            boolean expedite = false;

            // Check if it is time for Checker A to peek
            if (curTime >= checkerANextPeekTime && queueA.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- Peeking A...");
                }

                // Seed next peek time
                checkerANextPeekTime = System.currentTimeMillis() + (policy.checkerAPeekInterval * 1000);

                // Check Policy to determine if process time should be expedited
                if (queueA.size() >= policy.queueAMaxSize)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- Expediting A...");

                    // Expedite
                    expedite = true;
                    numAExpeditions++;
                }
            }

            // Check if it is time for Checker A to finish processing the next Person
            if ((curTime >= checkerANextProcessTime || expedite) && queueA.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- Processing A...");
                }

                // Peek at Person in Queue A
                Person person = queueA.peek();

                // If there is no one in Queue A, then return
                if (person == null)
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- Person from Queue A is null");
                    }

                    return;
                }

                // Check if Queue C is full
                boolean isQueueCFull = queueC.size() >= capacityC;

                // If Queue C is not full, then put Person in Queue C
                if (!isQueueCFull)
                {
                    boolean errorOccurred = false;
                    try
                    {
                        putPersonInQueue(3, person);
                    }
                    catch (IllegalStateException ise)
                    {
                        if (PRINT_DEBUG_MESSAGES)
                        {
                            System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- IllegalStateException");
                        }
                        // If Queue C became full while Checker A attempted to add a Person, then do nothing
                        errorOccurred = true;
                        numAISE++;
                    }
                    finally
                    {
                        if (!errorOccurred)
                        {
                            // If Person went into C, then remove from A
                            queueA.remove(person);
                            checkerANextProcessTime = genNextCheckerProcessTime();
                            checkerCNextProcessTime = genNextCheckerProcessTime();
                            System.out.print("\n" + getCurRuntime() + " CheckerATask.run() -- Person " + person.getNumber() + " moved from A to C -- " + getSimInfo());
                        }
                    }
                }
            }
        }
    }

    // Checker B timer task
    private static class CheckerBTask extends TimerTask
    {
        private static Policy policy;

        public CheckerBTask(Policy p)
        {
            super();

            policy = p;
            checkerBNextPeekTime = System.currentTimeMillis() + (p.checkerBPeekInterval * 1000);
            checkerBNextProcessTime = genNextCheckerProcessTime();
        }

        @Override
        public void run()
        {
            // Get current time
            long curTime = System.currentTimeMillis();

            boolean expedite = false;

            // Check if it is time for Checker B to peek
            if (curTime >= checkerBNextPeekTime && queueB.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- Peeking B...");
                }

                // Seed next peek time
                checkerBNextPeekTime = System.currentTimeMillis() + (policy.checkerBPeekInterval * 1000);

                // Check Policy to determine if process time should be expedited
                if (queueB.size() >= policy.queueBMaxSize)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- Expediting B...");

                    // Expedite
                    expedite = true;
                    numBExpeditions++;
                }
            }

            // Check if it is time for Checker B to finish processing the next Person
            if ((curTime >= checkerBNextProcessTime || expedite) && queueB.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- Processing B...");
                }

                // Peek at Person in Queue B
                Person person = queueB.peek();

                // If there is no one Queue B, then return
                if (person == null)
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- Person from Queue B is null");
                    }

                    return;
                }

                // Check if Queue C is full
                boolean isQueueCFull = queueC.size() >= capacityC;

                // If Queue C is not full, then put Person in Queue C
                if (!isQueueCFull)
                {
                    boolean errorOccurred = false;
                    try
                    {
                        putPersonInQueue(3, person);
                    }
                    catch (IllegalStateException ise)
                    {
                        if (PRINT_DEBUG_MESSAGES)
                        {
                            System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- IllegalStateException");
                        }
                        // If Queue C became full while Checker B attempted to add a Person, then do nothing
                        errorOccurred = true;
                        numBISE++;
                    }
                    finally
                    {
                        if (!errorOccurred)
                        {
                            // If Person went into C, then remove from B
                            queueB.remove(person);
                            checkerBNextProcessTime = genNextCheckerProcessTime();
                            checkerCNextProcessTime = genNextCheckerProcessTime();
                            System.out.print("\n" + getCurRuntime() + " CheckerBTask.run() -- Person " + person.getNumber() + " moved from B to C -- " + getSimInfo());
                        }
                    }
                }
            }
        }
    }

    // Checker C timer task
    private static class CheckerCTask extends TimerTask
    {
        private static Policy policy;

        public CheckerCTask(Policy p)
        {
            super();

            policy = p;
            checkerCNextPeekTime = System.currentTimeMillis() + (p.checkerCPeekInterval * 1000);
        }

        @Override
        public void run()
        {
            // Get current time
            long curTime = System.currentTimeMillis();

            boolean expedite = false;

            // Check if it is time for Checker C to peek
            if (curTime >= checkerCNextPeekTime && queueC.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerCTask.run() -- Peeking C...");
                }

                // Seed next peek time
                checkerCNextPeekTime = System.currentTimeMillis() + (policy.checkerCPeekInterval * 1000);

                // Check Policy to determine if process time should be expedited
                if (queueC.size() >= policy.queueCMaxSize)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerCTask.run() -- Expediting C...");

                    // Expedite
                    expedite = true;
                    numCExpeditions++;
                }
            }

            // Check if it is time for Checker C to finish processing the next Person
            if ((curTime >= checkerCNextProcessTime || expedite) && queueC.size() > 0)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\n" + getCurRuntime() + " CheckerCTask.run() -- Processing C...");
                }

                // Remove Person from Queue C
                boolean errorOccurred = false;
                Person p = new Person();
                try
                {
                    p = queueC.remove();
                }
                catch (NoSuchElementException nsee)
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\n" + getCurRuntime() + " CheckerCTask.run() -- NoSuchElementException");
                    }
                    // If Queue C is empty, then do nothing
                    errorOccurred = true;
                    numCNSEE++;
                }
                finally
                {
                    if (!errorOccurred)
                    {
                        checkerCNextProcessTime = genNextCheckerProcessTime();
                        numProcessed++;
                        System.out.print("\n" + getCurRuntime() + " CheckerCTask.run() -- Person " + p.getNumber() + " processed -- " + getSimInfo());
                    }
                }
            }
        }
    }

    private static long genNextCheckerProcessTime()
    {
        long t = ThreadLocalRandom.current().nextLong(MIN_CHECK_TIME, MAX_CHECK_TIME + 1L);
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\n" + getCurRuntime() + " genNextCheckerProcessTime(): " + t);
        }
        return System.currentTimeMillis() + t;
    }

    private static long genNextArrivalTime()
    {
        long t = ThreadLocalRandom.current().nextLong(MIN_ARRIVAL_TIME, MAX_ARRIVAL_TIME + 1L);
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\n" + getCurRuntime() + " genNextArrivalTime(): " + t);
        }
        return System.currentTimeMillis() + t;
    }

    /**
     * Select either Queue A or B
     *
     * @return 1 or 2
     */
    private static int genQueueSelection()
    {
        return ThreadLocalRandom.current().nextInt(1, 2 + 1);
    }

    private static void putPersonInQueue(int queueSelection, Person person) throws IllegalStateException
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\n" + getCurRuntime() + " putPersonInQueue() " + queueSelection);
        }

        switch (queueSelection)
        {
            case 1:
                queueA.add(person);
                System.out.print("\n" + getCurRuntime() + " putPersonInQueue() -- Person " + person.getNumber() + " has arrived at A -- " + getSimInfo());
                nextArrivalTime = genNextArrivalTime();
                checkerANextProcessTime = genNextCheckerProcessTime();
                break;
            case 2:
                queueB.add(person);
                System.out.print("\n" + getCurRuntime() + " putPersonInQueue() -- Person " + person.getNumber() + " has arrived at B -- " + getSimInfo());
                nextArrivalTime = genNextArrivalTime();
                checkerBNextProcessTime = genNextCheckerProcessTime();
                break;
            case 3:
                queueC.add(person);
                break;
            default:
                System.out.print("\n" + getCurRuntime() + " putPersonInQueue() -- INVALID queue selection: " + queueSelection);
                break;
        }
    }

    private static void init(Policy policy)
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\n" + getCurRuntime() + " init()");
        }

        // Record start time
        startTime = System.currentTimeMillis();

        // Initialize Queues
        queueA = new ArrayBlockingQueue<>(capacityA);
        queueB = new ArrayBlockingQueue<>(capacityB);
        queueC = new ArrayBlockingQueue<>(capacityC);

        // Put an initial Person into a random queue (either A or B)
        putPersonInQueue(genQueueSelection(), new Person(++numArrived));

        // Create arrival timer
        arrivalTimer = new Timer(ARRIVAL_TIMER_NAME);

        // Schedule arrival timer
        arrivalTimer.schedule(new ArrivalTask(), 0, ARRIVAL_TIMER_PERIOD);

        // Create Checker timers
        checkerATimer = new Timer(CHECKER_A_TIMER_NAME);
        checkerBTimer = new Timer(CHECKER_B_TIMER_NAME);
        checkerCTimer = new Timer(CHECKER_C_TIMER_NAME);

        // Schedule Checker timers
        checkerATimer.schedule(new CheckerATask(policy), 0, CHECKER_TIMER_PERIOD);
        checkerBTimer.schedule(new CheckerBTask(policy), 0, CHECKER_TIMER_PERIOD);
        checkerCTimer.schedule(new CheckerCTask(policy), 0, CHECKER_TIMER_PERIOD);
    }

    private static void cleanup()
    {
        arrivalTimer.cancel();
        arrivalTimer = null;
        checkerATimer.cancel();
        checkerATimer = null;
        checkerBTimer.cancel();
        checkerBTimer = null;
        checkerCTimer.cancel();
        checkerCTimer = null;
    }

    private static void shutdown()
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\n" + getCurRuntime() + " shutdown()");
        }

        // Record end time
        endTime = System.currentTimeMillis();

        // Clean up resources
        cleanup();

        // Print total duration
        System.out.print("\n\nTotal Time Elapsed: " + getSimDuration());

        if (PRINT_COMPLETION_STATS)
        {
            if (PRINT_DEBUG_MESSAGES)
            {
                System.out.print("\nnumArrived: " + numArrived);
                System.out.print("\nnumProcessed: " + numProcessed);
                System.out.print("\nqueueA.size(): " + queueA.size());
                System.out.print("\nqueueB.size(): " + queueB.size());
                System.out.print("\nqueueC.size(): " + queueC.size());
            }

            System.out.print("\nnumAExpeditions: " + numAExpeditions);
            System.out.print("\nnumBExpeditions: " + numBExpeditions);
            System.out.print("\nnumCExpeditions: " + numCExpeditions);
            System.out.print("\nnumAISE: " + numAISE);
            System.out.print("\nnumBISE: " + numBISE);
            System.out.print("\nnumCNSEE: " + numCNSEE);
        }
    }

    private static long getSimDuration()
    {
        return endTime - startTime;
    }

    private static long getCurRuntime()
    {
        return System.currentTimeMillis() - startTime;
    }

    private static String getSimInfo()
    {
        return "size A: " + queueA.size() + " / " + capacityA + ", size B: " + queueB.size() + " / " + capacityB + ", size C: " + queueC.size() + " / " + capacityC + ", Total Processed: " + numProcessed + " / " + population;
    }

    public static void run(int pop, int capA, int capB, int capC, Policy policy)
    {
        System.out.print("\nrun() -- pop: " + pop + ", capA: " + capA + ", capB: " + capB + ", capC: " + capC + ", Policy: " + policy);

        // Init members
        population = pop;
        capacityA = capA;
        capacityB = capB;
        capacityC = capC;

        // Init sim and BEGIN
        init(policy);
    }

    private static void test1()
    {
        int pop = 50;
        int capA = 30;
        int capB = 20;
        int capC = 20;

        int queueAMaxSize = 30;
        int queueBMaxSize = 20;
        int queueCMaxSize = 20;
        int checkerAPeekInterval = 15;
        int checkerBPeekInterval = 15;
        int checkerCPeekInterval = 15;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    private static void test2()
    {
        int pop = 50;
        int capA = 30;
        int capB = 20;
        int capC = 20;

        int queueAMaxSize = 15;
        int queueBMaxSize = 10;
        int queueCMaxSize = 10;
        int checkerAPeekInterval = 30;
        int checkerBPeekInterval = 30;
        int checkerCPeekInterval = 30;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    private static void test3()
    {
        int pop = 50;
        int capA = 30;
        int capB = 20;
        int capC = 20;

        int queueAMaxSize = 20;
        int queueBMaxSize = 15;
        int queueCMaxSize = 20;
        int checkerAPeekInterval = 30;
        int checkerBPeekInterval = 30;
        int checkerCPeekInterval = 60;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    private static void test4()
    {
        int pop = 50;
        int capA = 11;
        int capB = 39;
        int capC = 20;

        int queueAMaxSize = 11;
        int queueBMaxSize = 39;
        int queueCMaxSize = 20;
        int checkerAPeekInterval = 15;
        int checkerBPeekInterval = 15;
        int checkerCPeekInterval = 15;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    private static void test5()
    {
        int pop = 50;
        int capA = 11;
        int capB = 39;
        int capC = 20;

        int queueAMaxSize = 11;
        int queueBMaxSize = 20;
        int queueCMaxSize = 20;
        int checkerAPeekInterval = 30;
        int checkerBPeekInterval = 30;
        int checkerCPeekInterval = 30;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    private static void test6()
    {
        int pop = 50;
        int capA = 11;
        int capB = 39;
        int capC = 20;

        int queueAMaxSize = 10;
        int queueBMaxSize = 30;
        int queueCMaxSize = 20;
        int checkerAPeekInterval = 30;
        int checkerBPeekInterval = 30;
        int checkerCPeekInterval = 60;

        Policy p = new Policy(queueAMaxSize, queueBMaxSize, queueCMaxSize, checkerAPeekInterval, checkerBPeekInterval, checkerCPeekInterval);

        AssignmentB01.run(pop, capA, capB, capC, p);
    }

    public static void main(String[] args)
    {
        test6();
    }
}
