package com.company;

/**
 * Created by hackeru on 05/03/2017.
 */
public class Word {

    private String heb;
    private String eng;

    public Word(String heb, String eng){
        this.heb = heb;
        this.eng = eng;
    }

    public String getEng() {
        return eng;
    }

    public String getHeb() {
        return heb;
    }
}
