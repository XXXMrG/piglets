package bean;

import java.sql.ResultSet;

public class users {
    private String username;
    private String password;
    private ResultSet res ;
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
