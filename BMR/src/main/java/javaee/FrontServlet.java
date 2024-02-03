package javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import framework.context.RequestContext;
import framework.context.ResponseContext;
import framework.controller.ApplicationController;
import javaee.controller.WebApplicationController;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fn/*")
public class FrontServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
        doAction(req,res);
    }    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
        doAction(req,res);
    }
    public void doAction(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
        ApplicationController app = new WebApplicationController();
        req.setCharacterEncoding("UTF-8");
        RequestContext reqc = app.getRequest(req);
        ResponseContext resc = app.getResponse(res);
        app.handleRequest(reqc,resc);

        resc.setResponse(res);
        app.handleResponse(reqc,resc);
    }
}
