package com.example.demo.dataStructures;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulinaoveraite on 2018-09-19.
 */
@Getter
@Setter
public class SquareAndLineReply {

    private boolean intersection;
    private List<Point> intersectionPoint = new ArrayList<Point>();

    public SquareAndLineReply(boolean intersection) {
        this.intersection = intersection;
    }

    public SquareAndLineReply(boolean intersection, List<Point> intersectionPoint) {
        this.intersection = intersection;
        this.intersectionPoint = intersectionPoint;
    }

    public SquareAndLineReply() {
    }
}
