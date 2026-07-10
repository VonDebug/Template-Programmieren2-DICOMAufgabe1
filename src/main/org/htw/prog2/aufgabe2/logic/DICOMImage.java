package org.htw.prog2.aufgabe2.logic;


import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class DICOMImage {

    private String name;
    private  DICOMFrame[] allDicomFrames;
    public enum ImageType {ORIGINAL, EDGE}
    private int countOfFrames;

    public DICOMImage(File infile, String name) throws DicomException, IOException {
        this.name = name;

       AttributeList attributeList = new AttributeList();
       attributeList.read(infile);

        SourceImage sourceImage = new SourceImage(attributeList);
        countOfFrames = sourceImage.getNumberOfBufferedImages();
        this.allDicomFrames = new DICOMFrame[countOfFrames];

        for(int i = 0; i< countOfFrames; i++){

            DICOMFrame dicomFrame = new DICOMFrame(sourceImage.getBufferedImage(i));
            this.allDicomFrames[i] = dicomFrame;
        }
        System.out.println(countOfFrames);



    }

    public void writeFrames(int from, int to, ImageType imageType, double edgeLightnessCutoff) throws IOException {

        String fileNameConvention = (imageType == ImageType.ORIGINAL)? ".png" : "_edges.png";



        for(int i = from; i < to; i++){

            File file = new File(this.name + "_"+i+fileNameConvention);
            if(imageType == ImageType.ORIGINAL){
            ImageIO.write(this.allDicomFrames[i].getImage(), "PNG", file);

            }
            else{
                ImageIO.write(this.allDicomFrames[i].getEdges(edgeLightnessCutoff), "PNG", file);
            }
        }
    }

    private void writeImage(BufferedImage image, String filename) {
    }

    public DICOMFrame getFrame(int num){
        return this.allDicomFrames[num];
    }


    public String getName() {
        return name;
    }

    public DICOMFrame[] getAllDicomFrames() {
        return allDicomFrames;
    }

    public int getCountOfFrames() {
        return countOfFrames;
    }
}
