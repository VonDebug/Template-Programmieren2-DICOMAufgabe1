package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.logic.DICOMFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageDetailPanel extends JPanel {

    private JLabel image = new JLabel();
    private JLabel noImages = new JLabel("Keine Bildserie ausgewählt");

    public ImageDetailPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(5));


        JLabel header = new JLabel("Detailansicht");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(header);
        header.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.noImages.setFont(new Font("Arial", Font.BOLD, 30 ));
        this.add(this.noImages);
        this.noImages.setAlignmentX(Component.CENTER_ALIGNMENT);


        setBorder(new LineBorder(Color.BLACK));
        }


        public void setDetailedFrame(DICOMFrame frame, boolean showEdges){

        BufferedImage bufferedImage  = (showEdges)? frame.getEdges(10.0) : frame.getImage();
        this.remove(this.noImages);

        this.image.setIcon(new ImageIcon(bufferedImage));
        this.add(this.image);
        this.image.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.revalidate();
        this.repaint();

        }

}
