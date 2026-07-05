package org.htw.prog2.aufgabe2.ui;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame mainframe;

    public static MainFrame getInstance(){
        if(MainFrame.mainframe == null){
            MainFrame.mainframe = new MainFrame();
        }
        return MainFrame.mainframe;
    }

    public MainFrame() {
        MainFrame.mainframe = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);


        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        Manager manager = new Manager();

        this.setVisible(true);
    }
        
    }

