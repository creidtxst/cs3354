package assignmentB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
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
        //this.setResizable(false);
        this.setVisible(true);

        //TODO: fix formatting... need fixed table that doesn't resize with window
        //this.BoarderLayout() ??
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");

        prevMonthButton.addActionListener(ae -> {
            cal.add(Calendar.MONTH, -1);
            updateCalendarState();
        });

        nextMonthButton.addActionListener(ae -> {
            cal.add(Calendar.MONTH, +1);
            updateCalendarState();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(prevMonthButton, FlowLayout.LEFT);
        panel.add(label, BorderLayout.CENTER);
        panel.add(nextMonthButton, FlowLayout.RIGHT);

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
        table.setCellSelectionEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(20);
        TableColumnModel columnModel = table.getColumnModel();

        for (int i = 0; i < 7; i++)                                 // Sets calendar columns to a fixed width (40)
            columnModel.getColumn(i).setPreferredWidth(40);

        this.add(panel,BorderLayout.NORTH);
        this.add(pane,BorderLayout.CENTER);


        this.updateCalendarState();
    }

    void updateCalendarState()
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
