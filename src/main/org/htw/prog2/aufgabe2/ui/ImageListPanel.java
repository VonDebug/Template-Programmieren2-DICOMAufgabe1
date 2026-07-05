package org.htw.prog2.aufgabe2.ui;

import javax.swing.*;
import java.awt.*;

public class ImageListPanel extends JPanel {

    private JPanel jpanel;

    public ImageListPanel(){
        this.jpanel = new JPanel();
        this.jpanel.setLayout(new BoxLayout(this.jpanel, BoxLayout.Y_AXIS));
        this.jpanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));


        JLabel jLabel = new JLabel("Bilder");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.jpanel.add(jLabel);



    }

    public JPanel getJpanel() {
        return jpanel;
    }
}
