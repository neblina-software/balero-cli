/**
 * Balero CMS Project: Proyecto 100% Mexicano de código libre.
 * Página Oficial: http://www.balerocms.com
 *
 * @author Anibal Gomez <anibalgomez@icloud.com>
 * @copyright Copyright (C) 2016 Neblina Software. Derechos reservados.
 * @license Licencia BSD; vea LICENSE.txt
 */

package com.neblina.balero;

import com.neblina.balero.classes.UpdateManager;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("\n" +
                "__________        .__                       \n" +
                "\\______   \\_____  |  |   ___________  ____ CLI\n" +
                " |    |  _/\\__  \\ |  | _/ __ \\_  __ \\/  _ \\ \n" +
                " |    |   \\ / __ \\|  |_\\  ___/|  | \\(  <_> )\n" +
                " |______  /(____  /____/\\___  >__|   \\____/ \n" +
                "        \\/      \\/          \\/      " +
                "");
        System.out.println("\t\t\t\t\t ::: Software Update :::\n");
        UpdateManager updateManager = new UpdateManager();
        updateManager.init();
    }
}
