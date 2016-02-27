/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 (11/02/16) ) Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero.classes;

import java.io.File;
import java.io.IOException;

public class UpdateManager {

    private String version = "1.0-BETA3";
    private String outputDirectory = "updates";
    private String updatesDirectory = "updates";

    public void init() throws IOException {
        URLConnectionReader urlConnectionReader = new URLConnectionReader();
        urlConnectionReader.downloadZipFile(version);
        UnZip unZip = new UnZip(this.version);
        unZip.unZipIt(updatesDirectory + "/balerocms-enterprise-" + version + ".zip", outputDirectory);
        FileManager fileManager = new FileManager();
        File directory = new File(outputDirectory + "/src/main/resources/config");
        fileManager.deleteDirectory(directory);
        ConfigEditor configEditor = new ConfigEditor();
        configEditor.setVersion(this.version);
        configEditor.init();
    }

    public String getVersion() {
        return this.version;
    }

}
