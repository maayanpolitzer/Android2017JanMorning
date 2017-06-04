package com.maayanpolitzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hackeru on 6/4/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private ArrayList<String> names;

    public MainServlet(){
        names = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null) {
            names.add(name);
            /*
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            response.getWriter().write(names.toString());
        }
        /*
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        if (first != null && second != null){
            try {
                int f = Integer.parseInt(first);
                int s = Integer.parseInt(second);
                response.getWriter().write("it's " + (f + s));
            }catch(NumberFormatException e){
                response.getWriter().write("it's not a number...");
            }
        }
        */

    }

}
