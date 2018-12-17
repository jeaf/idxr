package idxr.gui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("idxr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayoutManager lay = new MigLayout();
        setLayout(lay);
        JButton b = new JButton("Button");
        add(b);
        pack();
        setLocationRelativeTo(null);
    }
}

