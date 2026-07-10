package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.logic.DICOMImage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SeriesThumbnail extends JPanel {

    boolean selected = false;
    DICOMImage dicomImage;
    BufferedImage bImage;
    int border;

    public SeriesThumbnail(DICOMImage dicomImage, int size, int border){

        this.border = border;

        setPreferredSize(new Dimension(size-2*border, size-2*border));

        this.dicomImage = dicomImage;

        this.bImage = this.dicomImage.getFrame(0).getImage();

        Graphics g = this.bImage.createGraphics();

        paintComponent(g);

    }


    public void setSelected(boolean selected){

        this.selected = selected;
    }

    public String getDescription(){

        return "Serie( " + this.dicomImage.getNumFrames() + " )";
    }

    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2d = (Graphics2D)g;

        g2d.drawImage(this.bImage,this.border, this.border, this);

    }


}
