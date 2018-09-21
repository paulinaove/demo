package com.example.demo.controller;

import com.example.demo.dataStructures.Point;
import com.example.demo.dataStructures.SquareAndLineReply;
import com.example.demo.service.InterceptionService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by paulinaoveraite on 2018-09-19.
 */
@RestController
@RequestMapping("/info")
public class BasicController {

    @Autowired
    public InterceptionService interceptionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String blabla (){
        return "a";
    }

    /*
        Input parameters - line ends coordinates and square's opposite corners coordinates
     */
    @RequestMapping(value = "/lineAndSquare", method = RequestMethod.GET)
    public @ResponseBody SquareAndLineReply squareAndLineIntersection (@RequestParam double lineX1,
                                                                       @RequestParam double lineY1,
                                                                       @RequestParam double lineX2,
                                                                       @RequestParam double lineY2,
                                                                       @RequestParam double squareX1,
                                                                       @RequestParam double squareY1,
                                                                       @RequestParam double squareX2,
                                                                       @RequestParam double squareY2) throws InvalidInput {
        //line points
        Point linePointA = new Point(lineX1, lineY1);
        Point linePointB = new Point(lineX2, lineY2);

        //square points
        Point squarePointA = new Point(squareX1, squareY1);
        Point squarePointB = new Point(squareX2, squareY2);

        SquareAndLineReply reply = interceptionService.findInterception(linePointA, linePointB, squarePointA, squarePointB);

        if(reply == null){
            throw new InvalidInput();
        }
        return reply;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input. Can't make a square from input")
    public class InvalidInput extends Exception {

        public InvalidInput() {
        }
    }
}
