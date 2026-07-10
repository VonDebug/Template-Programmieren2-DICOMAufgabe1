package org.htw.prog2.aufgabe2.ui;

import com.pixelmed.dicom.DicomException;
import org.htw.prog2.aufgabe2.logic.DICOMFrame;
import org.htw.prog2.aufgabe2.logic.DICOMImage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Manager {
    static Manager manager;

    private CreateJMenuBar createJMenuBar;
    private ImageListPanel imageListPanel;
    private ImageDetailPanel imageDetailPanel;


    private DICOMImage dicomImage;

    static Manager getInstance(){
        if(Manager.manager == null){
            Manager.manager = new Manager();
        }
        return Manager.manager;
    }

    public Manager (){
        Manager.manager = this;

        addAllComponents();


    }

    private void addAllComponents(){
        this.createJMenuBar = new CreateJMenuBar();
        MainFrame.getInstance().setJMenuBar(this.createJMenuBar.getjMenuBar());
        this.imageListPanel = new ImageListPanel();
        MainFrame.getInstance().add(this.imageListPanel.getJpanel(), BorderLayout.WEST);
        this.imageDetailPanel = new ImageDetailPanel();
        MainFrame.getInstance().add(this.imageDetailPanel.getjPanel(), BorderLayout.CENTER);
    }

    public void createDicomImageInstance(File infile, String name) throws DicomException, IOException {
        this.dicomImage = new DICOMImage(infile, name);
        addSeriesThumbnail(this.dicomImage);
    }

    public void addSeriesThumbnail(DICOMImage dicomImage){
        this.imageListPanel.setThumbnailImage(dicomImage);
    }


    public void setDetailFrame(DICOMFrame frame, boolean showEdges){

    }


    public DICOMImage getDicomImage() {
        return dicomImage;
    }

    public void setDicomImage(DICOMImage dicomImage) {
        this.dicomImage = dicomImage;
    }
}
