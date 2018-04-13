package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class HelloSwing
{
    private static JMenuBar createJMenuBar()
    {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");

        fileMenu.add(newMenuItem);
        jMenuBar.add(fileMenu);

        return jMenuBar;
    }

    private static JPanel createContentPane()
    {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        contentPane.add(new JLabel("Hello"), BorderLayout.CENTER);
        contentPane.add(new JLabel("Goodbye"), BorderLayout.PAGE_END);
        return contentPane;
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("HelloSwing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setJMenuBar(createJMenuBar());
        frame.setContentPane(createContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
