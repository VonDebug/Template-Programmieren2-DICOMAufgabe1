package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.logic.DICOMFrame;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageDetailPanel extends JPanel {

    private JPanel jPanel;

    public ImageDetailPanel(){
        this.jPanel = new JPanel();

        jPanel.setLayout(new BorderLayout());

        this.jPanel.setBorder(BorderFactory.createEmptyBorder(5,15,0,0));


        JLabel jLabel = new JLabel("Detailansicht");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20 ));
        this.jPanel.add(jLabel, BorderLayout.NORTH);

            JLabel noImages = new JLabel("Keine Bildserie ausgewählt");
            noImages.setFont(new Font("Arial", Font.BOLD, 30 ));
            this.jPanel.add(noImages, BorderLayout.CENTER);
        }

        public void setDetailedFrame(DICOMFrame frame, boolean showEdges){

            BufferedImage bufferedImage;

        if(showEdges){
            bufferedImage = frame.getEdges(10.0);
        }
        else{
            bufferedImage = frame.getImage();
        }
        Graphics2D g = bufferedImage.createGraphics();



        }



    public JPanel getjPanel() {
        return this.jPanel;
    }
}
