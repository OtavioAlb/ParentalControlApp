package br.com.usp.parentalcontrol.Model;

public class Profile {

    int id;
    String first_name;
    String last_name;
    String email;

    public Profile(int id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    public Profile(String first_name) {
        this.first_name = first_name;
    }

    public Profile(int id, String first_name, String last_name, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
