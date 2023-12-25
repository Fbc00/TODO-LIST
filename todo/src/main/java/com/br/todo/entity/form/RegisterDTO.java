package com.br.todo.entity.form;

import com.br.todo.types.UserRoles;

public record  RegisterDTO (String login, String password, UserRoles role) {}
