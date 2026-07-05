package org.htw.prog2.aufgabe2.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ImageDetailPanel extends JPanel {

    private JPanel jPanel;

    public ImageDetailPanel(){
        this.jPanel = new JPanel();

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        this.jPanel.setBorder(BorderFactory.createEmptyBorder(5,15,0,0));



        JLabel jLabel = new JLabel("Detailansicht");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20 ));

        jPanel.add(jLabel);


    }


    public JPanel getjPanel() {
        return this.jPanel;
    }
}
