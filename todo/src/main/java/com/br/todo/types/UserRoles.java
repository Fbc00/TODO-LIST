package com.br.todo.types;

public enum UserRoles {

    ADMIN("admin"),
    USER("user");
    public final String role;


    UserRoles(String role) {
        this.role = role;
    }
}
