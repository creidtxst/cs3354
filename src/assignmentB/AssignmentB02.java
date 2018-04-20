package assignmentB;

import util.FileUtil;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.BorderUIResource;
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
    private static final String BASE_FILE_PATH = System.getProperty("user.dir") + "/src/assignmentB";
    private static final String APPOINTMENT_NOTES_FILE_PATH = BASE_FILE_PATH + "/appointment-notes.json";

    private static final String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String FRAME_HEADER_TEXT = "Appointment Calendar";
    private static final Dimension DEFAULT_FRAME_DIMENSION = new Dimension(700, 480);
    private static final Dimension MIN_FRAME_DIMENSION = DEFAULT_FRAME_DIMENSION;
    private static final int TABLE_ROW_HEIGHT = 30;
    private static final Dimension TABLE_DIMENSION = new Dimension(300, 230);
    private static final Dimension APPOINTMENT_LABEL_DIMENSION = new Dimension(300, 300);

    // Static fields
    private static Calendar cal = new GregorianCalendar();
    private static DefaultTableModel tableModel;
    private static JLabel tableHeaderLabel;
    private static JTable table;
    private static int selectedDay;
    private static boolean isProgrammaticallySelected = false;
    private static JTextArea appointmentTextArea;

    private static JFrame createParentFrame()
    {
        JFrame f = new JFrame();
        f.setTitle(FRAME_HEADER_TEXT);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(DEFAULT_FRAME_DIMENSION);
        f.setMinimumSize(MIN_FRAME_DIMENSION);
        f.setResizable(false);
        return f;
    }

    private static JLabel createFrameHeaderLabel()
    {
        JLabel l = new JLabel(FRAME_HEADER_TEXT);
        l.setAlignmentX(Component.CENTER_ALIGNMENT); // Component alignment
        l.setHorizontalAlignment(JTextField.CENTER); // Text alignment
        l.setFont(new Font(null, Font.BOLD, 30));
        l.setBackground(new Color(0, 0, 0, 0));  // Transparent background
        l.setBorder(null);   // No border
        return l;
    }

    private static JButton createPrevMonthButton()
    {
        JButton b = new JButton("<<");

        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cal.add(Calendar.MONTH, -1);
                updateAfterNextPrevButtonPress();
            }
        });
        return b;
    }

    private static JButton createNextMonthButton()
    {
        JButton b = new JButton(">>");

        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cal.add(Calendar.MONTH, 1);
                updateAfterNextPrevButtonPress();
            }
        });
        return b;
    }

    private static JPanel createTablePanel()
    {
        // Create table frame
        JPanel tablePanel = new JPanel();
        tablePanel.setSize(TABLE_DIMENSION);
        tablePanel.setMinimumSize(TABLE_DIMENSION);
        tablePanel.setMaximumSize(TABLE_DIMENSION);
        tablePanel.setPreferredSize(TABLE_DIMENSION);
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));

        // Create prev and next month buttons
        JButton prevMonthButton = createPrevMonthButton();
        JButton nextMonthButton = createNextMonthButton();

        // Create table header
        JPanel tableHeaderPanel = new JPanel();
        tableHeaderPanel.setLayout(new BorderLayout());
        tableHeaderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add Previous Month button
        tableHeaderPanel.add(prevMonthButton, BorderLayout.LINE_START);

        // Add header label
        tableHeaderLabel = new JLabel();
        tableHeaderLabel.setFont(new Font(null, Font.PLAIN, 14));
        tableHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableHeaderPanel.add(tableHeaderLabel, BorderLayout.CENTER);

        // Add Next Month button
        tableHeaderPanel.add(nextMonthButton, BorderLayout.LINE_END);

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
        table.setFont(new Font(null, Font.PLAIN, 14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set up table model listener
        SharedListSelectionHandler sharedListSelectionHandler = new SharedListSelectionHandler();
        ListSelectionModel rowSelMod = table.getSelectionModel();
        ListSelectionModel colSelMod = table.getColumnModel().getSelectionModel();
        rowSelMod.addListSelectionListener(sharedListSelectionHandler);
        colSelMod.addListSelectionListener(sharedListSelectionHandler);

        // Attach table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Assemble table container
        tablePanel.add(tableHeaderPanel);
        tablePanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Filler
        tablePanel.add(scrollPane);

        return tablePanel;
    }

    private static JButton createAppointmentButton(String text, String actionCommand)
    {
        JButton b = new JButton();
        b.setText(text);
        b.setFont(new Font(null, Font.PLAIN, 14));
        b.addActionListener(new AppointmentButtonActionListener());
        b.setActionCommand(actionCommand);
        return b;
    }

    private static JTextArea createAppointmentTextArea()
    {
        JTextArea t = new JTextArea();
        t.setBorder(new BorderUIResource.LineBorderUIResource(Color.BLACK));
        t.setSize(APPOINTMENT_LABEL_DIMENSION);
        t.setMinimumSize(APPOINTMENT_LABEL_DIMENSION);
        t.setMaximumSize(APPOINTMENT_LABEL_DIMENSION);
        t.setPreferredSize(APPOINTMENT_LABEL_DIMENSION);
        return t;
    }

    private static void createAndShowGUI()
    {
        // Create parent frame
        JFrame parentFrame = createParentFrame();

        // Create parent container
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        // Create frame header
        JLabel frameHeaderLabel = createFrameHeaderLabel();

        // Create container to hold table and appointment text area
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.LINE_AXIS));

        // Create table container
        JPanel tablePanel = createTablePanel();

        // Create appointment text area
        appointmentTextArea = createAppointmentTextArea();

        // Create appointment buttons container
        JPanel appointmentButtonsPanel = new JPanel();
        appointmentButtonsPanel.setLayout(new BoxLayout(appointmentButtonsPanel, BoxLayout.LINE_AXIS));
        appointmentButtonsPanel.add(Box.createHorizontalGlue());    // Pin buttons to right edge

        // Create OK and Cancel buttons
        JButton okButton = createAppointmentButton("OK", "ok");
        JButton cancelButton = createAppointmentButton("Cancel", "cancel");

        // Attach OK and Cancel buttons to container
        appointmentButtonsPanel.add(okButton);
        appointmentButtonsPanel.add(cancelButton);
        appointmentButtonsPanel.add(Box.createRigidArea(new Dimension(30, 0))); // Filler

        // Put it all together...
        rootPanel.add(Box.createRigidArea(new Dimension(0, 40)));   // Filler
        rootPanel.add(frameHeaderLabel);
        rootPanel.add(Box.createRigidArea(new Dimension(0, 40)));   // Filler
        middlePanel.add(tablePanel);
        middlePanel.add(Box.createRigidArea(new Dimension(40, 0))); // Filler
        middlePanel.add(appointmentTextArea);
        rootPanel.add(middlePanel);
        rootPanel.add(Box.createRigidArea(new Dimension(0, 20)));   // Filler
        rootPanel.add(appointmentButtonsPanel);
        rootPanel.add(Box.createRigidArea(new Dimension(0, 40)));   // Filler

        // Add root panel to parent frame
        parentFrame.add(rootPanel);

        // Init table state
        updateCalendarState();

        // Programmatically select current day in table
        selectDayInTable(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        // Init appointment text area
        updateAppointmentTextArea();

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
        int numWeeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        isProgrammaticallySelected = true;
        // Note: this invokes selection listener handler
        tableModel.setRowCount(0);
        tableModel.setRowCount(numWeeks);

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

    private static void updateAppointmentTextArea()
    {
        appointmentTextArea.setText(getAppointmentNotesForSelectedDay());
    }

    private static String getAppointmentNotesForSelectedDay()
    {
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
        int year = cal.get(Calendar.YEAR);
        String k = selectedDay + "" + month + "" + year;
        return JsonUtil.getValueForKeyFromFile(k, APPOINTMENT_NOTES_FILE_PATH).replace("\\n", FileUtil.NEWLINE);
    }

    private static void setAppointmentNotesForSelectedDay()
    {
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
        int year = cal.get(Calendar.YEAR);
        String k = selectedDay + "" + month + "" + year;

        // Replace system newline with unicode newline character to prepare for JSON encoding
        String s = appointmentTextArea.getText().replace(FileUtil.NEWLINE, "\\n");

        JsonUtil.setValueForKeyInFile(k, s, APPOINTMENT_NOTES_FILE_PATH);
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
                selectedDay = 1;
                selectDayInTable(selectedDay);
            }
            catch (NullPointerException npe)
            {
                // ignore
            }

            updateTableHeaderText();
            updateAppointmentTextArea();
        }
    }

    private static class AppointmentButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            switch (e.getActionCommand())
            {
                case "ok":
                    setAppointmentNotesForSelectedDay();
                    break;
                case "cancel":
                    // Clear appointment text area
                    appointmentTextArea.setText("");
                    break;
                default:
                    break;
            }
        }
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
