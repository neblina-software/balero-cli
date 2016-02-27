/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 (2/26/16) ) Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero.classes;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConfigEditor {

    private static List<String> lines;

    private String version;

    public void init() throws IOException {
        File f = new File(System.getProperty("user.dir") + "/src/main/java/resources/config/application.properties");
        lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        changeValueOf("balerocms.version", this.version); // the name and the value you want to modify
        Files.write(f.toPath(), changeValueOf("balerocms.version", this.version), Charset.defaultCharset());
    }

    private static List<String> changeValueOf(String username, String newVal){
        List<String> newLines = new ArrayList<String>();
        for(String line: lines){
            if(line.contains(username)){
                String [] vals = line.split("=");
                newLines.add(vals[0]+"="+String.valueOf(newVal));
            }else{
                newLines.add(line);
            }

        }
        return newLines;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
