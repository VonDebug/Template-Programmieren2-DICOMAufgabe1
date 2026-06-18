package org.htw.prog2.aufgabe2;


import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class DICOMImage {

    public String name;
    public  DICOMFrame[] allDicomFrames;

    public DICOMImage(File infile, String name) throws DicomException, IOException {
        this.name = name;

        int countOfImages;

       AttributeList attributeList = new AttributeList();
       attributeList.read(infile);

        SourceImage sourceImage = new SourceImage(attributeList);
        countOfImages = sourceImage.getNumberOfBufferedImages();
        this.allDicomFrames = new DICOMFrame[countOfImages];

        for(int i = 0; i<countOfImages; i++){

            DICOMFrame dicomFrame = new DICOMFrame(sourceImage.getBufferedImage(i));
            this.allDicomFrames[i] = dicomFrame;
        }



    }

    public void writeFrames(int from, int to, boolean original, boolean edges, double edgeLightnessCutoff) {
    }

    private void writeImage(BufferedImage image, String filename) {
    }
}
