package assignmentB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AssignmentB02 extends JFrame
{
    Calendar cal = new GregorianCalendar();
    DefaultTableModel model;
    JLabel label;

    //TODO: add text box to add/view appointments

    AssignmentB02()
    {
        this.setTitle("Appointment Calendar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);

        //TODO: fix formatting... need fixed table that doesn't resize with window
        // BoarderLayout() ??
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton prevMonth = new JButton("Prev");
        JButton nextMonth = new JButton("Next");

        prevMonth.addActionListener(ae -> {
            cal.add(Calendar.MONTH, -1);
            updateMonth();
        });

        nextMonth.addActionListener(ae -> {
            cal.add(Calendar.MONTH, +1);
            updateMonth();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(prevMonth, FlowLayout.LEFT);
        panel.add(label, BorderLayout.CENTER);
        panel.add(nextMonth, FlowLayout.RIGHT);

        String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

        model = new DefaultTableModel(null, days)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        this.add(panel,BorderLayout.NORTH);
        this.add(pane,BorderLayout.CENTER);

        this.updateMonth();
    }

    void updateMonth()
    {
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        int year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);

        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        model.setRowCount(0);
        model.setRowCount(weeks);

        int i = (firstDay - 1);
        for (int day = 1; day <= totalDays; day++)
        {
            model.setValueAt(day, i / 7, i % 7);
            i = i + 1;
        }

    }

    public static void main(String args[])
    {
        AssignmentB02 calendar = new AssignmentB02();
    }
}
