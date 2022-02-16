package model;

public class User {
    private int id;
    private String Username,Email,Password;

    public User() {
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        Username = username;
        Email = email;
        Password = password;
    }

    public User(String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}
