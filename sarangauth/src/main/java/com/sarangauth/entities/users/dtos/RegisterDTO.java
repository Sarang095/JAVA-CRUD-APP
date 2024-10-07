package com.sarangauth.entities.users.dtos;

import com.sarangauth.entities.users.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}