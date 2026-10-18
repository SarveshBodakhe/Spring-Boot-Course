package com.sarvesh.SpringBootWebProject1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //This annotation makes this class a controller
public class HomeController {

    @RequestMapping("/") //We are using request mapping to map the request.
    // We do URL mapping using this annotation. Right now we are doing it for home page "/"

    //This method is responsible to call a view technology (index.jsp)
    public String home()
    {
        System.out.println("home method called.");
        return "index";

        //To return this index.jsp as an HTML page we need a "Tomcat Jasper" dependency
        //To convert this jsp page into a servlet
    }

    //In one controller we have multiple request mappings for multiple requests.

    //Dispatcher Servlet is responsible to do the mappings, etc.: When it sees an "add" mapping then it calls the add method, etc.

    //Now we have to accept the data from browser that client send via the index.jsp page
    //There are two ways of doing it: 1. Servlet way 2. Spring way

    //1. Servlet way
//    @RequestMapping("add") //Here we are mentioning the URL (localhost:8080/add)
//    public String add(HttpServletRequest req, HttpSession session)
//    {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//
//        System.out.println("In add.");
//
//        int result = num1 + num2;
//        System.out.println("Result is: " + result);
//
//        //We are sending the result data to result.jsp page via the session object
//        session.setAttribute("result", result);
//
//        return "result.jsp";
//    }

    //2. Spring way
//    @RequestMapping("add") //Here we are mentioning the URL (localhost:8080/add)
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model)
//    //Here num1 and num2 only works when we are getting exact same names from browser like num1 and num2
//    //But to avoid this exact naming rule, we have a @RequestParam annotation in which we have to
//    //mention exact names of variables which we got from browser
//    //So after this you can use any name instead of num1 and num2
//
//
//    //Now I don't want to use this session object here, because we are using MVC architecture
//    //In MVC we have a Model which is used to transfer the data between controller and view technology (JSP)
//    {
//        System.out.println("In add.");
//
//        int result = num1 + num2;
//        System.out.println("Result is: " + result);
//
//       model.addAttribute("result", result);
//
//       //Now I want to remove this ".jsp" file type and make it generic.
         //We are doing this by setting prefix and suffix in resources/application.properties file
//        return "result";
//    }

    @RequestMapping("add")
    //Here we are using only Model to add the data, and we are using view name to return it
    //Instead of using Model, I want to use ModelAndView
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv)
    {
        System.out.println("In add.");

        int result = num1 + num2;
        System.out.println("Result is: " + result);

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }
}
