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
 It is not authorized, because I didn't have enough time to fix (the attemts are in the code). In BasicSecurityConfig 14 line is commented, which doesn't allow to access this end point without authorisation, but I was not able to reach login page. 
 
 <h3> Architecture: <h3>
 
 The code is divided into controllers, services and dataStructures. 
 Controllers handle REST requests and have no buissness logic.
 Services have interfaces and service implementation. This is were all the logic is and it is accessable from controllers by interfaces.
 DataStructures are all the classes and data structures that are used in the project (for example square, line, etc.)
 
 <h3> Components/libraries </h3>
 Lombok - used for getters and setter to have more clean code, without getters and setter overcrowing the screen .
 Spring boot - used for application itself. Very easy configuration and allows a lot of features as REST, Spring Security and etc.
  
