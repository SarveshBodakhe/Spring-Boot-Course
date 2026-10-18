package com.sarvesh.SpringBootWebProject1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //This annotation makes this class a controller
public class HomeController {

    @RequestMapping("/") //We are using request mapping to map the request.
    // We do URL mapping using this annotation. Right now we are doing it for home page "/"

    //This method is responsible to call a view technology (index.jsp)
    public String home()
    {
        System.out.println("home method called.");
        return "index.jsp";

        //To return this index.jsp as a html page we need a "Tomcat Jasper" dependency
        //To convert this jsp page into a servlet
    }

    //In one controller we have multiple request mappings for multiple requests.

    //Dispatcher Servlet is responsible to do the mappings, etc.: When it sees an "add" mapping then it calls the add method, etc.

    //Now we have to accept the data from browser that client send via the index.jsp page
    //There are two ways of doing it: 1. Servlet way 2. Spring way

    //1. Servlet way
    @RequestMapping("add") //Here we are mentioning the URL (localhost:8080/add)
    public String add(HttpServletRequest req, HttpSession session)
    {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        System.out.println("In add.");

        int result = num1 + num2;
        System.out.println("Result is: " + result);

        //We are sending the result data to result.jsp page via the session object
        session.setAttribute("result", result);

        return "result.jsp";
    }
}
