package com.example.demo.dataStructures;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by paulinaoveraite on 2018-09-20.
 */
@Getter
@Setter
public class Square {
    Point a;
    Point b;
    Point c;
    Point d;

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
