package com.mike.domain.model;

import java.io.Serializable;

/**
 * Created by Michael Brennan on 9/12/15.
 */
public class Block implements Serializable {

    private int id;
    private String color;
    private String shape;
    private String pattern;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
