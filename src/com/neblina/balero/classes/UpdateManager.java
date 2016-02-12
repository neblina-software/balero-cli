/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 (11/02/16) ) Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero.classes;

import java.io.IOException;

public class UpdateManager {

    public void init() throws IOException {
        URLConnectionReader urlConnectionReader = new URLConnectionReader();
        urlConnectionReader.downloadZipFile("1.0-BETA3");
        UnZip unZip = new UnZip();
        unZip.unZipIt("updates/balerocms-enterprise-1.0-BETA3.zip", "updates");
    }

}
