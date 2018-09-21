# demo
demo project for line and square intersection

It's a Spring Boot program so in order to start it, just run Runner class in your IDE.

1. end point example : http://localhost:8080/info/lineAndSquare/?lineX1=0&lineY1=0&lineX2=1&lineY2=4&squareX1=0&squareY1=0&squareX2=2&squareY2=2
  lineX1, lineY1 - coordinates of one line end
  lineX2, lineY2 - coordinates of other line end
  squareX1, squareY1 - coordinates of one square point
  squareX2, squareY2 - coordinates of diagonal square point (diagonal to  squareX1, squareY1)
  
  If the input is not valid, the error message will be returned
  
  Response example:
  {"intersection":true,"intersectionPoint":[{"x":0.5,"y":2.0}]}
 
 intersection - boolean. Shows is lines intersect or not.
 intersectionPoint - array of point, where lines intersect.
 
 2. http://localhost:8080/actuator/metrics/tomcat.sessions.active.current
 It is not authorized, because I didn't have enough time to fix (the attemts are in the code)
  
