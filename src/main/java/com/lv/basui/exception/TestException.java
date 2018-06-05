package com.lv.basui.exception;

public class TestException extends Exception {

    private String description;


    public TestException(String description){

        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
