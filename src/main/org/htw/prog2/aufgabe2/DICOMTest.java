package org.htw.prog2.aufgabe2;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DICOMTest {
    public static void main(String[] args) throws DicomException, IOException {
        String infilename = "data/angiogram1.DCM";
        File file = new File(infilename);
        String name = "lol";
        DICOMImage dicomImage = new DICOMImage(file, name);

        dicomImage.writeFrames(0,2, DICOMImage.ImageType.EDGE,5.0);
    }
}
