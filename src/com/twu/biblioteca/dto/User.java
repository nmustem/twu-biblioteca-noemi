package com.twu.biblioteca.dto;

public class User {

    private String id;

    private String password;

    private String name;

    private String surnames;

    private String email;

    private int phone;

    public User() {

    }

    public User(String id, String password, String name, String surnames, String email, int phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id.equals(user.id) &&
                this.password.equals(user.password);
    }

    @Override
    public String toString() {
        return String.format("| %8s | %-30s | %-23s | %9s |",
                id, (name + " " + surnames).length() > 30 ? (name + " " + surnames).substring(0, 27) + "..." : (name + " " + surnames), email, phone);
    }
}
