package com.kgh.docker_sample.dto;

import com.kgh.docker_sample.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {

  private Long id;
  private String name;
  private String email;

  // Entity → Response 변환
  public static UserResponse fromEntity(User user) {
    return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .build();
  }
}