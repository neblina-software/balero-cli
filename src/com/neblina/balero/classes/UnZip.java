/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 (11/02/16) ) Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero.classes;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZip
{

    private String version;

    public UnZip(String version) {
        this.version = version;
    }

    public void unZipIt(String zipFile, String outputFolder) throws IOException {

        byte[] buffer = new byte[1024];
        String strEntry;

            //create output directory is not exists
            File folder = new File(outputFolder);
            if(!folder.exists()){
                folder.mkdir();
            }

            BufferedOutputStream dest = null;
            BufferedInputStream is = null;

            ZipEntry entry;
            ZipFile zipfile = new ZipFile(zipFile);
            Enumeration e = zipfile.entries();
            while(e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                strEntry = entry.toString().replace("balerocms-enterprise-" + this.version + "", "");
                System.out.println("Extracting: " + strEntry);
                is = new BufferedInputStream
                        (zipfile.getInputStream(entry));
                if(entry.isDirectory()) {
                    File file = new File(outputFolder + File.separator + strEntry);
                    file.mkdirs();
                } else {
                     int count;
                     byte data[] = new byte[1024];

                    strEntry = entry.getName().replace("balerocms-enterprise-" + this.version + "", "");
                     FileOutputStream fos = new
                     FileOutputStream(outputFolder + File.separator + strEntry);
                     dest = new
                     BufferedOutputStream(fos, 1024);
                     while ((count = is.read(data, 0, 1024))
                     != -1) {
                     dest.write(data, 0, count);
                     }
                     dest.flush();
                     dest.close();
                     is.close();
                }
            }

            System.out.println("Done");

    }

}