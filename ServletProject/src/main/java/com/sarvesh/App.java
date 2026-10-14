package com.sarvesh;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );

        //To run this Service method or Servlet we have to send the request from our browser
        //(send req to localhost:8080) by default tomcat server port number is 8080
        //We need to run this embedded tomcat to send a request

        Tomcat tomcat = new Tomcat();

        //set the port number for tomcat server
        tomcat.setPort(8080);

        //Mapping of url with the servlet
        //for ex (localhost:8080/hello) we need to map this "hello" to the servlet
        //Servlet Mapping

        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        //Start a server
        tomcat.start();

        //get hold on a server using getServer and keep server running using await
        tomcat.getServer().await();
    }
}
