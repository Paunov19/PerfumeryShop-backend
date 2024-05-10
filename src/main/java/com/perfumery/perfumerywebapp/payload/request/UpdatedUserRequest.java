package com.perfumery.perfumerywebapp.payload.request;

import javax.validation.constraints.Email;

public class UpdatedUserRequest {
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String currentPassword;
    private String newPassword;

    public UpdatedUserRequest() {

    }

    public UpdatedUserRequest(String firstName, String lastName, String email, String currentPassword, String newPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
