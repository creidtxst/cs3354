package assignmentB;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class AssignmentB01
{
    //
    // DEBUG
    //
    private static boolean PRINT_DEBUG_MESSAGES = true;
    private static boolean DEBUG_TIMING = true; // true: seconds, false: minutes

    // Constants
    private static String ARRIVAL_TIMER_NAME = "arrivalTimer";
    private static long ARRIVAL_TIMER_PERIOD = 1 * 1000; // 1 sec

    private static String CHECKER_A_TIMER_NAME = "checkerATimer";
    private static String CHECKER_B_TIMER_NAME = "checkerBTimer";
    private static String CHECKER_C_TIMER_NAME = "checkerCTimer";
    private static long CHECKER_TIMER_PERIOD = 1 * 1000; // 1 sec

    private static long MIN_CHECK_TIME = DEBUG_TIMING ? 1 * 1000 : 1 * 1000 * 60;
    private static long MAX_CHECK_TIME = DEBUG_TIMING ? 15 * 1000 : 15 * 1000 * 60;
    private static long MIN_ARRIVAL_TIME = 0; //DEBUG_TIMING ? 1 * 1000 : MIN_CHECK_TIME;
    private static long MAX_ARRIVAL_TIME = DEBUG_TIMING ? 10 * 1000 : 10 * 1000 * 60;

    // Members
    private static int population = 0;
    private static int capacityA = 0;
    private static int capacityB = 0;
    private static int capacityC = 0;

    private static long startTime = 0;
    private static long endTime = 0;

    private static ArrayBlockingQueue<Person> queueA;
    private static ArrayBlockingQueue<Person> queueB;
    private static ArrayBlockingQueue<Person> queueC;

    private static long nextArrivalTime = 0;
    private static Timer arrivalTimer;

    private static long checkerANextPeekTime;
    private static long checkerANextProcessTime;
    private static long checkerBNextPeekTime;
    private static long checkerBNextProcessTime;
    private static long checkerCNextPeekTime;
    private static long checkerCNextProcessTime;
    private static Timer checkerATimer;
    private static Timer checkerBTimer;
    private static Timer checkerCTimer;

    // Person
    private static class Person
    {

    }

    // Arrival timer task
    private static class ArrivalTask extends TimerTask
    {
        @Override
        public void run()
        {
            if (PRINT_DEBUG_MESSAGES)
            {
                System.out.print("\nArrivalTask.run()");
            }
            // Get current time
            long curTime = System.currentTimeMillis();

            // If it is time for the next Person to arrive, then put the Person in either Queue A or B
            if (curTime >= nextArrivalTime)
            {
                if (PRINT_DEBUG_MESSAGES)
                {
                    System.out.print("\nArrivalTask.run() -- next Person has arrived...");
                }
                // Check if Queue A is full
                boolean isQueueAFull = queueA.size() >= capacityA;

                // Check if Queue B is full
                boolean isQueueBFull = queueB.size() >= capacityB;

                // If both Queue A and B are full, then do nothing
                if (isQueueAFull && isQueueBFull)
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\nArrivalTask.run() -- BOTH Queue A and B are full");
                    }
                    // no op

                    //
                    // TEST
                    //
                    shutdown();
                }
                else if (isQueueAFull)  // Put Person in Queue B
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\nArrivalTask.run() -- Queue A is full");
                    }
                    putPersonInQueue(2, new Person());
                }
                else if (isQueueBFull)  // Put Person in Queue A
                {
                    if (PRINT_DEBUG_MESSAGES)
                    {
                        System.out.print("\nArrivalTask.run() -- Queue B is full");
                    }
                    putPersonInQueue(1, new Person());
                }
                else    // Put Person in random Queue
                {
                    putPersonInQueue(genQueueSelection(), new Person());
                }
            }
        }
    }

    // CheckerA timer task
    private static class CheckerATask extends TimerTask
    {
        @Override
        public void run()
        {

        }
    }

    // CheckerB timer task
    private static class CheckerBTask extends TimerTask
    {
        @Override
        public void run()
        {

        }
    }

    // CheckerC timer task
    private static class CheckerCTask extends TimerTask
    {
        @Override
        public void run()
        {

        }
    }

    private static long genNextCheckTime()
    {
        return ThreadLocalRandom.current().nextLong(MIN_CHECK_TIME, MAX_CHECK_TIME + 1L);
    }

    private static long genNextArrivalTime()
    {
        long t = ThreadLocalRandom.current().nextLong(MIN_ARRIVAL_TIME, MAX_ARRIVAL_TIME + 1L);
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\ngenNextArrivalTime(): " + t);
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
        int q = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\ngenQueueSelection(): " + q);
        }
        return q;
    }

    private static void putPersonInQueue(int queueSelection, AssignmentB01.Person person)
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\nputPersonInQueue(): " + queueSelection);
        }

        switch (queueSelection)
        {
            case 1:
                queueA.add(person);
                nextArrivalTime = genNextArrivalTime();
                break;
            case 2:
                queueB.add(person);
                nextArrivalTime = genNextArrivalTime();
                break;
            case 3:
                queueC.add(person);
                break;
            default:
                System.out.print("ERROR in putPersonInQueue() -- INVALID queue selection");
                break;
        }
    }

    private static void init()
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\ninit()");
        }

        // Record start time
        startTime = System.currentTimeMillis();

        // Initialize Queues
        queueA = new ArrayBlockingQueue<>(capacityA);
        queueB = new ArrayBlockingQueue<>(capacityB);
        queueC = new ArrayBlockingQueue<>(capacityC);

        // Put an initial Person into a random queue (either A or B)
        putPersonInQueue(genQueueSelection(), new AssignmentB01.Person());

        // Create arrival timer
        arrivalTimer = new Timer(ARRIVAL_TIMER_NAME);

        // Schedule arrival timer
        arrivalTimer.schedule(new ArrivalTask(), 0, ARRIVAL_TIMER_PERIOD);
    }

    private static void cleanup()
    {
        arrivalTimer.cancel();
        arrivalTimer = null;
    }

    private static void shutdown()
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\nshutdown()");
        }

        // Record end time
        endTime = System.currentTimeMillis();

        // Clean up resources
        cleanup();

        // Print total duration
        System.out.print("\nDuration: " + getSimDuration());
    }

    private static long getSimDuration()
    {
        return endTime - startTime;
    }

    public static void run(int pop, int capA, int capB)
    {
        if (PRINT_DEBUG_MESSAGES)
        {
            System.out.print("\nrun() -- pop: " + pop + ", capA: " + capA + ", capB: " + capB);
        }

        // Init members
        population = pop;
        capacityA = capA;
        capacityB = capB;
        capacityC = capA + capB;

        // Init sim and BEGIN
        init();
    }

    public static void main(String[] args)
    {
//        AssignmentB01.run(50, 30, 20);
        AssignmentB01.run(5, 3, 2);
    }
}
