package PasswordManager;

import java.io.Serializable;

public class Entry implements Serializable {
    protected String sitename;
    protected String username;
    protected String password;

    public Entry(String sitename, String username, String password) {
        this.sitename = sitename;
        this.username = username;
        this.password = password;
    }

    public String getSitename() {
        return sitename;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return
                "Site: " + sitename + "\n" +
                "Username: " + username + "\n" +
                 "Password: " + password + "\n";
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
