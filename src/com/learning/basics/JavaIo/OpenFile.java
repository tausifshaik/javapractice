package com.learning.basics.JavaIo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/*
 * Sometimes we have to open file in java program.
 *  java.awt.Desktop can be used to open a file in java.
 *   Desktop implementation is platform dependent, so first we should check if the operating system supports Desktop or not.
 *    This class looks for the associated application registered to the current platform to open a file.
 */
public class OpenFile {
	public static void main(String[] args) throws IOException {
        //text file, should be opening in default text editor
        File file = new File("/Users/tshg9/file.txt");
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
    }
}
