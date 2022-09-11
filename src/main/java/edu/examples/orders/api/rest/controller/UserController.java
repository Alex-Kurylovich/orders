package edu.examples.orders.api.rest.controller;

import edu.examples.orders.domain.Agent;
import edu.examples.orders.domain.User;
import edu.examples.orders.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UserController {
	
	final
    UserService usersService;

    public UserController(@Autowired UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = ApiLinks.CHECK_HEALTH)
    public String checkHealth() {
        log.info("check health of server");
        return "Check health passed for local host server";
    }

	@GetMapping(path = ApiLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        log.info("UsersController:  list users");
        List<User> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = ApiLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
        log.info("UsersController:  add user");
        User resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = ApiLinks.LIST_USERS_MANAGER)
    public ResponseEntity<?> listUsersManager() {
        log.info("UsersController:  list users");
        List<User> resource = (List<User>) usersService.findAllUserManager();
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = ApiLinks.LIST_USERS_AGENT)
    public ResponseEntity<?> listUsersAgent() {
        log.info("UsersController:  list users");
        List<User> resource = (List<User>) usersService.findAllUserAgent();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = ApiLinks.LIST_USERS_TECHNICIAN)
    public ResponseEntity<?> listUsersTechnician() {
        log.info("UsersController:  list users");
        List<User> resource = (List<User>) usersService.findAllUserTechnician();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = ApiLinks.LIST_AGENT)
    public ResponseEntity<?> findAgent() {
        log.info("UsersController:  list agents");
        List<Agent> resource = (List<Agent>) usersService.findAllAgent();
        return ResponseEntity.ok(resource);
    }
}
