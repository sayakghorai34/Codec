package com.example.test1;
import java.awt.Desktop;
import java.net.URI;

public class OpenBrowser {
    public static void main() throws Exception {
        String url = "http://localhost:63342/Test1/ThingSpeakFetchIOT/com/example/test1/doctor.html?_ijt=880aoturfghualn10bubd4evui&_ij_reload=RELOAD_ON_SAVE";
        //Windows based
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
        }
        //Unix Based
        else {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("/usr/bin/firefox -new-window " + url);
        }
    }
}