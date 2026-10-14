package com.sarvesh;


//The only purpose of this HelloServlet isto greet the user

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//This annotation way is only works with external tomcat
//In this case we are using embedded tomcat, so we have to do manual configurations in App.java
//@WebServlet("/hello") //(hello) means for which request you want to work with
//So whenever someone requests for "hello" call this "HelloServlet"
public class HelloServlet extends HttpServlet {

    //service is one of the important method in the servlet,
    //which gets executed whenever you send the request

    //Whenever you want this servlet to work, you have to define this method.

    //Whatever data coming from client is stored in req object.
    //Whatever data you (server) want to share to the client is stored in res object.

    //Instead of service() i am using doGet() method
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //We are sending request to a server
        System.out.println("In Service");

        //Set the type of data res object will have
        res.setContentType("text/html");

        //We are sending data back to client
        res.getWriter().println("<h2><b>Hello World!!!</b></h2>");
    }
}
