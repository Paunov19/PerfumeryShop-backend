package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.enums.ERole;
import com.perfumery.perfumerywebapp.models.User;

import java.util.List;

public interface AdminService {

    User addEmployee(User user);
    List<User> getAllEmployees();
    void deleteEmployee(Long employeeId);
    User changeEmployeeRole(Long employeeId, ERole newRole);
}
