package com.kpi.acts.OPCourseWork.web;

import com.kpi.acts.OPCourseWork.model.*;
import com.kpi.acts.OPCourseWork.service.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FrontControllerServlet", urlPatterns = "/control/*")
public class FrontControllerServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}