package com.FloPiDocs.FloPiDocs.Content.service.utils;

public class utils {

    public static String actualDate(){
        java.time.format.DateTimeFormatter formmat1 = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd", java.util.Locale.ENGLISH);
        java.time.LocalDateTime ldt = java.time.LocalDateTime.now();
        return formmat1.format(ldt);
    }
}
