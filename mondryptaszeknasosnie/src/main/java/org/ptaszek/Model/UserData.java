package org.ptaszek.Model;


public class UserData {

    public UserData(String login, String password){
        this.login = login;
        this.password = password;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
