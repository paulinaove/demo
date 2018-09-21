package com.example.demo.dataStructures;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by paulinaoveraite on 2018-09-19.
 */
@Setter
@Getter
public class Equation {
    private double k;
    private double t;
    private Point a;
    private Point b;

    public Equation(double k, double t, Point a, Point b) {
        this.k = k;
        this.t = t;
        this.a = a;
        this.b = b;
    }
}
