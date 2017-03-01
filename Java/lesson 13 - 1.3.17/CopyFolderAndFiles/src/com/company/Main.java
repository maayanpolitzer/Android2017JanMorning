package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File desktop = new File("C:\\Users\\hackeru\\Desktop");
        /*
        File[] files = desktop.listFiles();
        for (int i = 0; i < files.length; i++){
            System.out.println(files[i].getName());
        }
        */
        File src = new File(desktop, "images");
        File copy = new File(desktop, "images - copy");
        copyFolder(src, copy);

    }

    private static void copyFolder(File folder, File target){
        if (!target.exists()){
            System.out.println("folder " + target.getName() + " created");
            target.mkdir();
        }
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){
                // this object if a file.
                copyFile(files[i], target);
            }else{
                // this objcet is a folder.
                copyFolder(files[i], new File(target, files[i].getName()));
            }
        }
    }

    private static void copyFile(File original, File targetFolder){
        File newFile = new File(targetFolder, original.getName());
        try {
            FileInputStream in = new FileInputStream(original);
            FileOutputStream out = new FileOutputStream(newFile);
            System.out.println("file " + newFile.getName() + " created!");
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) != -1){
                out.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
