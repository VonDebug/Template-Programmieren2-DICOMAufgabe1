package org.htw.prog2.aufgabe2;

import com.pixelmed.dicom.DicomException;
import org.htw.prog2.aufgabe2.logic.DICOMFrame;
import org.htw.prog2.aufgabe2.logic.DICOMImage;
import org.htw.prog2.aufgabe2.ui.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Manager {
    static Manager manager;

    private MainFrame mainFrame;
    private CreateJMenuBar createJMenuBar;
    private ImageListPanel imageListPanel;
    private ImageDetailPanel imageDetailPanel;
    private DICOMImage dicomImage;
    private ControlElements controlElements;

    public static Manager getInstance(){
        if(Manager.manager == null){
            Manager.manager = new Manager();
        }
        return Manager.manager;
    }

    private Manager (){
        Manager.manager = this;
        this.mainFrame = new MainFrame();
        addAllComponents();


    }

    private void addAllComponents(){
        this.createJMenuBar = new CreateJMenuBar();
        this.mainFrame.setJMenuBar(this.createJMenuBar.getjMenuBar());
        this.imageListPanel = new ImageListPanel();
        this.mainFrame.add(this.imageListPanel, BorderLayout.WEST);
        this.imageDetailPanel = new ImageDetailPanel();
        this.mainFrame.add(this.imageDetailPanel, BorderLayout.CENTER);

        this.mainFrame.setVisible(true);
    }

    public void createDicomImageInstance(File infile, String name) throws DicomException, IOException {
        this.dicomImage = new DICOMImage(infile, name);
        addSeriesThumbnail(this.dicomImage);
    }

    public void addSeriesThumbnail(DICOMImage dicomImage){
        this.imageListPanel.setThumbnailImage(dicomImage);
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }


    public void setDetailedFrame(DICOMFrame frame, boolean showEdges){
        this.imageDetailPanel.setDetailedFrame(frame, showEdges);

        if(this.controlElements == null){
            this.controlElements = new ControlElements();
            this.mainFrame.add(this.controlElements, BorderLayout.SOUTH);
        }
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }


    public DICOMImage getDicomImage() {
        return dicomImage;
    }

    public void setDicomImage(DICOMImage dicomImage) {
        this.dicomImage = dicomImage;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public ImageDetailPanel getImageDetailPanel() {
        return imageDetailPanel;
    }

    public ImageListPanel getImageListPanel() {
        return imageListPanel;
    }
}
