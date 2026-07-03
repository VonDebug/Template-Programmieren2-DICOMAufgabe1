package org.htw.prog2.aufgabe2;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLocationRelativeTo(null);


        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        this.add(createOptionPane(), BorderLayout.NORTH);

        this.setVisible(true);
    }

    private JMenuBar createOptionPane(){

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Datei");

        JMenuItem open = new JMenuItem("Öffnen");

        JMenuItem close = new JMenuItem("Beenden");
        close.addActionListener(e -> System.exit(0));


        jMenu.add(open);
        jMenu.add(close);

        jMenuBar.add(jMenu);

        return jMenuBar;
    }


}
