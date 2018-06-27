package bean;

public class User {

    /**
     * asu_id : 1
     * username : Den
     * password : den
     * priv : 2
     */

    private String asu_id;
    private String username;
    private String password;
    private String priv;

    public void setPriv(String priv) {
        this.priv = priv;
    }

    public void setAsu_id(String asu_id) {
        this.asu_id = asu_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPriv() {
        return priv;
    }

}