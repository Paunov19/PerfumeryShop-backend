package com.perfumery.perfumerywebapp.payload.request;

import com.perfumery.perfumerywebapp.enums.ERole;

public class ChangeUserRoleRequest {
    private Long userId;
    private ERole newRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ERole getNewRole() {
        return newRole;
    }

    public void setNewRole(ERole newRole) {
        this.newRole = newRole;
    }
}
