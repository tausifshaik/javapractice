package com.learning.basics.JavaIo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileOperations {

	public static void main(String[] args) throws IOException {
        File file = new File("/Users/tshg9/file.txt");
        if(file.createNewFile()){
            System.out.println("file.txt File Created in Project root directory");
        }
        System.out.println("File extension is: "+getFileExtension(file));
        
        //File exists
        System.out.println(file.getCanonicalPath() + " exists? "+file.exists());
        
        //last modified
        long timestamp = file.lastModified();
        System.out.println("last modified date = "+new Date(timestamp));
        
      //check file permissions for application user
        System.out.println("File is readable? "+file.canRead());
        System.out.println("File is writable? "+file.canWrite());
        System.out.println("File is executable? "+file.canExecute());
        //change file permissions for application user only
        file.setReadable(false);
        file.setWritable(false);
        file.setExecutable(false);
        //change file permissions for other users also
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, true);
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
