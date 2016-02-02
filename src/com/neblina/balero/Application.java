/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero;

import com.neblina.balero.classes.URLConnectionReader;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting Updater...");
        URLConnectionReader urlConnectionReader = new URLConnectionReader();
        urlConnectionReader.downloadZipFile(System.getProperty("user.dir"));
    }
}
