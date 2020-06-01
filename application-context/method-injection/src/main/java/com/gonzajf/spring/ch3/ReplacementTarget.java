package com.gonzajf.spring.ch3;

public class ReplacementTarget {

    public String formatMessage(String msj) {
        return "<h1>"+msj+"</h1>";
    }

    public String formatMessage(Object msj) {
        return "<h1>"+msj+"</h1>";
    }
}