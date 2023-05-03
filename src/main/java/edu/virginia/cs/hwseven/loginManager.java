package edu.virginia.cs.hwseven;

import java.sql.SQLException;

public class loginManager {
    boolean login(String username, String password) throws SQLException {
        databaseManager databaseManager = new databaseManager();
        databaseManager.connect();
        Student s =databaseManager.getLogin(username);
        if(s.getUserName().equals(username)&& s.getPassword().equals(password)){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) throws SQLException {
        loginManager loginManager = new loginManager();
        System.out.println(loginManager.login("user", "pass"));
    }
}
