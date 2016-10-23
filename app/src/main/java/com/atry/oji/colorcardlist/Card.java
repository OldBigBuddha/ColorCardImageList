package com.atry.oji.colorcardlist;

/**
 * Created by oji on 16/10/23.
 */
public class Card {

    private String  colorCode = "";
    private String  colorName = "";

    public Card(String colorName, String  colorCode) {
        this.colorCode = colorCode;
        this.colorName = colorName;
    }

    public String getColorName() {
        return this.colorName;
    }

    public String  getColorCode() {
        return this.colorCode;
    }

}
