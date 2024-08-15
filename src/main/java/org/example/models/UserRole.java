package org.example.models;

import java.util.Map;

public class UserRole {
    public static final String ADMIN = "admin";
    public static final String HR = "hr";
    public static final String MANAGEMENT = "management";
    public static final String SALES = "sales";

    int roleId;

    private static final Map<Integer, String> ROLESMAP = Map.of(
            1, ADMIN,
            2, HR,
            3, MANAGEMENT,
            4, SALES
    );

    public UserRole(final int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return ROLESMAP.get(getRoleId());
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(final int roleId) {
        this.roleId = roleId;
    }
}
