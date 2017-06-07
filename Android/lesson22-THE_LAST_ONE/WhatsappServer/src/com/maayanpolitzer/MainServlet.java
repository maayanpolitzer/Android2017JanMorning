package com.maayanpolitzer;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by hackeru on 6/7/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost();");
        StringBuffer sb = new StringBuffer();
        String line;
        BufferedReader reader = request.getReader();
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        try {
            JSONObject input = new JSONObject(sb.toString());
            JSONObject output = new JSONObject();

            int firstNumber = input.getInt("first");
            int secondNumber = input.getInt("second");
            int result = 0;
            switch (input.getString("action")){
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
            }
            output.put("response", result);

            String res = output.toString();
            response.setContentType("application/json");
            response.getWriter().write(res);
        } catch (JSONException e) {
            response.getWriter().write(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
    }
}
