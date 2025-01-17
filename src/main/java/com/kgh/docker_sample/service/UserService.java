package com.kgh.docker_sample.service;

import com.kgh.docker_sample.domain.User;
import com.kgh.docker_sample.dto.UserRequest;
import com.kgh.docker_sample.dto.UserResponse;
import com.kgh.docker_sample.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  @Transactional(readOnly = true)
  public List<UserResponse> getAllUsers() {
    return userRepository.findAll().stream()
            .map(UserResponse::fromEntity)
            .collect(Collectors.toList());
  }
  public UserResponse createUser(UserRequest request) {
    User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .build();
    User savedUser = userRepository.save(user);
    return UserResponse.fromEntity(savedUser);
  }
  @Transactional
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
