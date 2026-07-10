package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.logic.DICOMImage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SeriesThumbnail extends JPanel {

    boolean selected = false;
    DICOMImage dicomImage;
    BufferedImage bImage;
    int border;
    int size;

    public SeriesThumbnail(DICOMImage dicomImage, int size, int border){
        this.size = size;
        this.border = border;
        this.dicomImage = dicomImage;
        this.bImage = this.dicomImage.getFrame(0).getImage();

        setBorder(new LineBorder(Color.RED));

    }


    public void setSelected(boolean selected){

        this.selected = selected;
    }

    public String getDescription(){

        return "Serie( " + this.dicomImage.getCountOfFrames() + " )";
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.bImage,this.border,this.border, this.size,this.size, this);
        if(selected){
            g.setColor(Color.BLUE);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(3));
            g2d.drawRect(this.border, this.border, this.size, this.size);
        }

    }


}
