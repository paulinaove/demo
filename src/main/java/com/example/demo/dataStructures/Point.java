package com.example.demo.dataStructures;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by paulinaoveraite on 2018-09-19.
 */
@Getter
@Setter
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
