package edu.examples.orders.api.rest.controller;

import org.springframework.stereotype.Component;

@Component
public class ApiLinks {
    public static final String LIST_USERS = "/users";
    public static final String ADD_USER = "/user";
    public static final String LIST_USERS_MANAGER = "/users/manager";
    public static final String LIST_USERS_AGENT = "/users/agent";

    public static final String LIST_AGENT = "/agent";
    public static final String LIST_USERS_TECHNICIAN = "/users/technician";
    public static final String LIST_CUSTOMERS = "/customers";
    public static final String ADD_CUSTOMER = "/customer";
    public static final String CHECK_HEALTH = "/healthcheck";

}
