package com.example.demo.service;


import com.example.demo.dataStructures.Equation;
import com.example.demo.dataStructures.Point;
import com.example.demo.dataStructures.Square;
import com.example.demo.dataStructures.SquareAndLineReply;
import org.springframework.stereotype.Service;

/**
 * Created by paulinaoveraite on 2018-09-19.
 */
@Service
public class InterceptionServiceImpl implements InterceptionService {

    public SquareAndLineReply findInterception(Point lineA, Point lineB, Point squareA, Point squareB){
        SquareAndLineReply reply = new SquareAndLineReply();

        Square square = getSquare(squareA, squareB);
        if(square == null){
            return null;
        }
        Equation lineEquation = getTheEquationOfTheLine(lineA, lineB);

        //get 4 square equations of each wall
        Equation squareEquation1 = getTheEquationOfTheLine(square.getA(), square.getC());
        Equation squareEquation2 = getTheEquationOfTheLine(square.getC(), square.getB());
        Equation squareEquation3 = getTheEquationOfTheLine(square.getB(), square.getD());
        Equation squareEquation4 = getTheEquationOfTheLine(square.getD(), square.getA());

        //get interception points
        checkIfLinesIntercept(lineEquation, squareEquation1, reply);
        checkIfLinesIntercept(lineEquation, squareEquation2, reply);
        checkIfLinesIntercept(lineEquation, squareEquation3, reply);
        checkIfLinesIntercept(lineEquation, squareEquation4, reply);

        if(reply.getIntersectionPoint().isEmpty()){
            reply.setIntersection(false);
        } else {
            reply.setIntersection(true);
        }

        return reply;

    }

    public Square getSquare (Point a, Point b){
        Point c = new Point ((a.getX() + b.getX()+ a.getY() - b.getY())/2, (b.getX() - a.getX() + a.getY() + b.getY())/2);
        Point d = new Point ((a.getX() + b.getX() + b.getY() - a.getY())/2, (a.getX() - b.getX() + a.getY() + b.getY())/2);
        if(isSquare(a,b,c,d)){
           return new Square(a,b,c,d);
        }
        return null;
    }

    public Equation getTheEquationOfTheLine(Point a, Point b){
        double m = (b.getY() - a.getY()) / (b.getX() - a.getX());
        double t = (-1 * b.getX() * m ) + b.getY();
        return new Equation(m, t, a, b);
    }

    public void checkIfLinesIntercept(Equation e1, Equation e2, SquareAndLineReply reply){
       //if ks are equal the lines are linear
        if(e1.getK() != e2.getK()){
            //finds the x where equations are equal
            double x = (e2.getT() - e1.getT())/(e1.getK() - e2.getK());
            //checks if that x is in the range
            if(doesXExistInRange(x, e1.getA().getX(), e2.getB().getX())){
                //gets y
               double y = x*e1.getK() + e1.getT();
               //checks if y is in the range
               if(doesXExistInRange(y, e1.getA().getY(), e1.getB().getY())){
                   //adds point to the reply
                   reply.getIntersectionPoint().add(new Point(x,y));
               }
            }
        }
    }

    public boolean doesXExistInRange(double x, double pointA, double pointB){
        return (x > pointA && x < pointB) || (x < pointA && x > pointB);
    }

    public boolean isSquare(Point p1, Point p2, Point p3, Point p4)
    {
        double d2 = distSq(p1, p2); // from p1 to p2
        double d3 = distSq(p1, p3); // from p1 to p3
        double d4 = distSq(p1, p4); // from p1 to p4

        // If lengths if (p1, p2) and (p1, p3) are same, then
        // following conditions must met to form a square.
        // 1) Square of length of (p1, p4) is same as twice
        // the square of (p1, p2)
        // 2) Square of length of (p2, p3) is same as twice the square of (p1, p2)

        if(d2 == 0 || d3 == 0 || d4 ==0){
            return false;
        }

        if (d2 == d3 && 2 * d2 == d4 && 2 * d2 == distSq(p2, p3)) {
            double d = distSq(p2, p4);
            return (d == distSq(p3, p4) && d == d2);
        }

        // The below two cases are similar to above case
        if (d3 == d4 && 2 * d3 == d2 && 2 * d3 == distSq(p3, p4)) {
            double d = distSq(p2, p3);
            return (d == distSq(p2, p4) && d == d3);
        }
        if (d2 == d4 && 2 * d2 == d3 && 2 * d2 == distSq(p2, p4)) {
            double d = distSq(p2, p3);
            return (d == distSq(p3, p4) && d == d2);
        }

        return false;
    }

    // A utility function to find square of distance
    // from point 'p' to poitn 'q'
    public double distSq(Point p, Point q)
    {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }
}
