package infrastructure;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 5/14/2017.
 */
public class User {

    private static int counter = 0;
    private int userID;
    private String email, password;

    public User(int userID, String email, String password) {
        this.userID = ++counter;
        this.email = email;
        this.password = password;
    }

    public User(JSONObject obj) throws JSONException {
        email = obj.getString("email");
        password = obj.getString("password");
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public int setUserID(){
        userID = ++counter;
        return userID;
    }


    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return userID + ", " + email + ", " + password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof User){
            User u = (User) obj;
            return email.equals(u.email) && password.equals(u.password);
        }
        return false;
    }
}
