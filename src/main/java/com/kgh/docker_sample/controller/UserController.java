package com.kgh.docker_sample.controller;

import com.kgh.docker_sample.domain.User;
import com.kgh.docker_sample.dto.UserRequest;
import com.kgh.docker_sample.dto.UserResponse;
import com.kgh.docker_sample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
  public static final String API_USER = "/api/users";
  private final UserService userService;

  @GetMapping("/api/users")
  @ResponseBody
  public ResponseEntity<List<UserResponse>> getAllUsersApi() {
    List<UserResponse> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/users")
  public String getAllUsersView(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "users";
  }

  @PostMapping("/api/users")
  @ResponseBody
  public ResponseEntity<UserResponse> createUserApi(@RequestBody UserRequest userRequest) {
    UserResponse user = userService.createUser(userRequest);
    return ResponseEntity.ok(user);
  }

  @GetMapping("/users/add")
  public String addUserForm(Model model) {
    model.addAttribute("userRequest", new UserRequest());
    return "add-user";
  }

  @PostMapping("/users")
  public String createUser(@ModelAttribute UserRequest userRequest) {
    userService.createUser(userRequest);
    return "redirect:/users";
  }

  @GetMapping("/users/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return "redirect:/users";
  }
}
