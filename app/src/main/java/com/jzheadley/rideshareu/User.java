package com.jzheadley.rideshareu;

public class User extends Model {
    public User() {
        super("User");
        this.columns.put("name", null);
    }

    public String getName() {
        return String.valueOf(this.columns.get("name"));
    }

    public void setName(String n) {
        this.columns.put("name", n);
    }
}
