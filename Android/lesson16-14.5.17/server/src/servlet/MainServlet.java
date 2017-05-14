package servlet;

import infrastructure.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hackeru on 5/14/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private ArrayList<User> users;

    public MainServlet(){
        users = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            //JSONObject input = new JSONObject(reader.toString());
            JSONObject output = new JSONObject();
            //String action = input.getString("action");
            switch(action) {
                case "login":
                    //System.out.println("login " + input);
                    output.put("result", login(email, password));
                    break;
                case "register":
                    output.put("result", register(email, password));
                    break;

            }
            String res = output.toString();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            response.getWriter().write(res);
            response.getWriter().flush();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().write("good job " + name);

    }

    private int login(String email, String password) throws JSONException {
        User u = new User(email, password);
        for(User user : users){
            if (user.equals(u)){
                return user.getUserID();
            }
        }
        return -1;
    }

    private int register(String email, String password) throws JSONException {
        User u = new User(email, password);
        for (User user : users){
            if (user.getEmail().equals(u.getEmail())){
                return -1;
            }
        }

        int result = u.setUserID();
        users.add(u);
        return result;
    }
}
