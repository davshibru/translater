package com.example.translator;

public class Language {
    private String makeShort(String lang){
        String shortLang = "";
        switch (lang.toLowerCase()) {
            case "руский":
                shortLang = "ru";
                break;
            case "английский":
                shortLang = "en";
                break;
            case "кыргызский":
                shortLang = "ky";
                break;
            case "украинский":
                shortLang = "uk";
                break;
            case "французкий":
                shortLang = "fr";
                break;
            case "татарский":
                shortLang = "tt";
                break;
            default:
                shortLang = "ru";
        }
        return shortLang;
    }

    public String makeLang(String from, String to){
        String stFrom = makeShort(from);
        String stTo = makeShort(to);
        String str = stFrom + "-" + stTo;
        return str;
    }
}
