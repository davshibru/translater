package com.example.translator;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int code;

    private String lang;

    private String[] text;

    public int getCode() {
        return code;
    }

    public String getLang() {
        return lang;
    }

    public String[] getText() {
        return text;
    }


}
