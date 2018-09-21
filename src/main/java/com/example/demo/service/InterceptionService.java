package com.example.demo.service;


import com.example.demo.dataStructures.Point;
import com.example.demo.dataStructures.SquareAndLineReply;

/**
 * Created by paulinaoveraite on 2018-09-19.
 */
public interface InterceptionService {

    SquareAndLineReply findInterception(Point lineA, Point lineB, Point squareA, Point squareB);
}

