package com.jsp.ecommerce.dto;

public class UserDto {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean terms;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public boolean isTerms() { return terms; }
    public void setTerms(boolean terms) { this.terms = terms; }
}