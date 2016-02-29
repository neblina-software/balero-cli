/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 (2/28/16) ) Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero.classes;

import java.io.File;
import java.io.IOException;

public class MakeAMove {

    public void init(String dirToMove, String dirDestination) {
        try {
            File destFile = new File(dirDestination);
            System.out.println("Checking");
            if(destFile.exists()) {
                delete(destFile);
                System.out.println("Deleting " + destFile);
            }
            if(!destFile.exists()) {
                System.out.println("Do Not Exists. Ready For Move " + destFile);
            }
            // Move files to root directory
            File file = new File(dirToMove);
            file.renameTo(new File(System.getProperty("user.dir"), file.getName()));
            System.out.println("Moving To: " + dirDestination);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(File file)
            throws IOException {

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

}
