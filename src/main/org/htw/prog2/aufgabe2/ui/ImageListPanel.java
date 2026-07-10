package org.htw.prog2.aufgabe2.ui;

import org.htw.prog2.aufgabe2.Manager;
import org.htw.prog2.aufgabe2.logic.DICOMImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageListPanel extends JPanel {

    private SeriesThumbnail seriesThumbnail;

    public ImageListPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(100,0));

        this.add(Box.createVerticalStrut(5));


        JLabel jLabel = new JLabel("Bilder");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(jLabel);



    }

    public void setThumbnailImage(DICOMImage newImage){
        int border = 5;
        int size = this.getWidth() - 2 * border;

        this.seriesThumbnail = new SeriesThumbnail(newImage, size, border);
        this.seriesThumbnail.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(SwingUtilities.isLeftMouseButton(e)){
                    Manager.getInstance().setDetailedFrame(newImage.getFrame(0), false);
                    Manager.getInstance().getImageListPanel().getSeriesThumbnail().setSelected(true);
                }
            }
        });
        this.add(this.seriesThumbnail);
        this.revalidate();
        this.repaint();

    }


    public SeriesThumbnail getSeriesThumbnail() {
        return seriesThumbnail;
    }
}


