package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.Manager;

import javax.swing.*;
import java.awt.*;

public class ControlElements extends JPanel {

    private int countOfImages;

    private JLabel frameIndexLabel;

    public ControlElements(){

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.countOfImages = Manager.getInstance().getDicomImage().getCountOfFrames();

        this.frameIndexLabel = new JLabel("Bild 1/" + this.countOfImages);
        frameIndexLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(frameIndexLabel);


        JSlider jSlider = new JSlider(SwingConstants.HORIZONTAL,1, this.countOfImages, 1);
        jSlider.addChangeListener(e -> {
            this.frameIndexLabel.setText("Bild " + jSlider.getValue() + "/" + this.countOfImages);
            Manager.getInstance().setDetailedFrame(Manager.getInstance().getDicomImage().getFrame(jSlider.getValue() - 1), false);
        });

        this.add(jSlider);


    }


}
