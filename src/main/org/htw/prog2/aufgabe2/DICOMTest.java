package org.htw.prog2.aufgabe2;


import com.pixelmed.dicom.DicomException;

import java.io.File;
import java.io.IOException;

public class DICOMTest {
    public static void main(String[] args) throws DicomException, IOException {
        String infilename = "data/angiogram1.DCM";
        File file = new File(infilename);
        String name = "lol";
        MainFrame mainFrame = new MainFrame();
        //DICOMImage dicomImage = new DICOMImage(file, name);
        //dicomImage.writeFrames(0,2, DICOMImage.ImageType.EDGE,5.0);
    }
}
