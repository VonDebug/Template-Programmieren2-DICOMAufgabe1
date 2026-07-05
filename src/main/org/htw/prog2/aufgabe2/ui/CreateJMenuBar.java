package org.htw.prog2.aufgabe2.ui;

import com.pixelmed.dicom.DicomException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class CreateJMenuBar {

    private JMenuBar jMenuBar;


    public CreateJMenuBar(){

        this.jMenuBar = new JMenuBar();
        this.jMenuBar.setFont(new Font("Aria", Font.BOLD, 20));

        JMenu jMenu = new JMenu("Datei");
        jMenu.setFont(new Font("Aria", Font.BOLD, 20));

        JMenuItem open = new JMenuItem("Öffnen");
        open.setFont(new Font("Aria", Font.BOLD, 20));
        open.addActionListener(e -> {
            try {
                instanciateFileChooser();
            } catch (DicomException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JMenuItem close = new JMenuItem("Beenden");
        close.setFont(new Font("Aria", Font.BOLD, 20));
        close.addActionListener(e -> System.exit(0));

        jMenu.add(open);
        jMenu.add(close);

        jMenuBar.add(jMenu);
    }

    private void instanciateFileChooser() throws DicomException, IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("DICOM Files", "DCM");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You choose the right file");
            String nameOfFile = chooser.getSelectedFile().getName();
            File infile = chooser.getSelectedFile().getAbsoluteFile();

            Manager.getInstance().createDicomImageInstance(infile, nameOfFile);


        }
    }




    public JMenuBar getjMenuBar() {
        return jMenuBar;
    }


}
