package assignmentB;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AssignmentB02
{
    // Constants
    private static final String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String FRAME_HEADER_TEXT = "Appointment Calendar";
    private static final Dimension DEFAULT_FRAME_DIMENSION = new Dimension(640, 480);
    private static final Dimension MIN_FRAME_DIMENSION = new Dimension(640, 480);
    private static final Dimension MAX_FRAME_DIMENSION = new Dimension(640, 480);
    private static final int TABLE_ROW_HEIGHT = 30;

    // Static fields
    private static JFrame parentFrame;
    private static Calendar cal = new GregorianCalendar();
    private static DefaultTableModel tableModel;
    private static JLabel tableHeaderLabel;
    private static JTable table;
    private static int selectedDay;
    private static boolean isProgrammaticallySelected = false;

    // Handler
    private static SharedListSelectionHandler sharedListSelectionHandler;

    //TODO: add text box to add/view appointments

    private static JFrame createParentFrame()
    {
        JFrame f = new JFrame();
        f.setTitle(FRAME_HEADER_TEXT);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(DEFAULT_FRAME_DIMENSION);
        f.setMinimumSize(MIN_FRAME_DIMENSION);
        f.setLayout(new FlowLayout());
        return f;
    }

    private static JTextField createFrameHeaderTextField()
    {
        JTextField t = new JTextField(FRAME_HEADER_TEXT);
        t.setAlignmentX(Component.CENTER_ALIGNMENT); // Component alignment
        t.setHorizontalAlignment(JTextField.CENTER); // Text alignment
        t.setEditable(false);
        t.setFont(new Font(null, Font.BOLD, 30));
        t.setBackground(new Color(0, 0, 0, 0));  // Transparent background
        t.setBorder(null);   // No border
        return t;
    }

    private static void init()
    {
        // Create parent frame
        parentFrame = createParentFrame();

        // Create parent container
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // Create frame header
        JTextField frameHeaderTextField = createFrameHeaderTextField();

        // Create table frame
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));

        // Create buttons
        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");

        prevMonthButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cal.add(Calendar.MONTH, -1);
                updateAfterNextPrevButtonPress();
            }
        });

        nextMonthButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cal.add(Calendar.MONTH, +1);
                updateAfterNextPrevButtonPress();
            }
        });

        // Create table header
        JPanel tableHeaderPanel = new JPanel();
        tableHeaderPanel.setLayout(new FlowLayout());
        tableHeaderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add Previous Month button
        tableHeaderPanel.add(prevMonthButton, FlowLayout.LEFT);

        // Add header label
        tableHeaderLabel = new JLabel();
        tableHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableHeaderPanel.add(tableHeaderLabel, FlowLayout.CENTER);

        // Add Next Month button
        tableHeaderPanel.add(nextMonthButton, FlowLayout.RIGHT);

        // Setup table model
        tableModel = new DefaultTableModel(null, DAYS)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        // Create table
        table = new JTable(tableModel);
        table.setCellSelectionEnabled(true);
        table.setRowHeight(TABLE_ROW_HEIGHT);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set up table model listener
        sharedListSelectionHandler = new SharedListSelectionHandler();
        ListSelectionModel rowSelMod = table.getSelectionModel();
        ListSelectionModel colSelMod = table.getColumnModel().getSelectionModel();
        rowSelMod.addListSelectionListener(sharedListSelectionHandler);
        colSelMod.addListSelectionListener(sharedListSelectionHandler);

        // Attach table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Put it all together...
        container.add(frameHeaderTextField);
        tablePanel.add(tableHeaderPanel);
        tablePanel.add(scrollPane);
        container.add(tablePanel);
        parentFrame.add(container);

        // Init table state
        updateCalendarState();

        // Programmatically select current day in table
        selectDayInTable(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        // Parent frame is ready to be displayed...
        parentFrame.pack();
        parentFrame.setVisible(true);
    }

    private static void updateAfterNextPrevButtonPress()
    {
        updateCalendarState();
        selectDayInTable(cal.get(Calendar.DAY_OF_WEEK));
        updateTableHeaderText();
    }

    private static void updateCalendarState()
    {
        cal.set(Calendar.DAY_OF_MONTH, 1);

        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        isProgrammaticallySelected = true;
        // Note: this invokes selection listener handler
        tableModel.setRowCount(0);
        // todo figure out why this has to be called twice
        tableModel.setRowCount(weeks);

        // todo disable selection on blank cells in table
        int i = (firstDay - 1);
        for (int day = 1; day <= totalDays; day++)
        {
            tableModel.setValueAt(day, i / 7, i % 7);
            i++;
        }
    }

    private static void selectDayInTable(int day)
    {
        int i = (day - 1);
        int rowIndex = i / 7;
        int columnIndex = i % 7;
        boolean toggle = false;
        boolean extend = false;
        isProgrammaticallySelected = true;
        table.changeSelection(rowIndex, columnIndex, toggle, extend);
    }

    private static void updateTableHeaderText()
    {
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        int year = cal.get(Calendar.YEAR);
        String t = month + " " + selectedDay + ", " + year;
        tableHeaderLabel.setText(t);
    }

    private static class SharedListSelectionHandler implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            if (isProgrammaticallySelected)
            {
                isProgrammaticallySelected = false;
                return;
            }

            int[] rows = table.getSelectedRows();
            int selectedRow = rows.length > 0 ? rows[0] : 0;

            int[] cols = table.getSelectedColumns();
            int selectedColumn = cols.length > 0 ? cols[0] : 0;

            try
            {
                selectedDay = (Integer) table.getValueAt(selectedRow, selectedColumn);
            }
            catch (ArrayIndexOutOfBoundsException exc)
            {
                System.out.print("\n" + exc.toString());
                selectedDay = 1;
                selectDayInTable(selectedDay);
            }
            catch (NullPointerException npe)
            {
                System.out.print("\n" + npe.toString());
            }

            updateTableHeaderText();
        }
    }

    private static void createAndShowGUI()
    {
        init();
    }

    public static void main(String args[])
    {
        // Run...
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
