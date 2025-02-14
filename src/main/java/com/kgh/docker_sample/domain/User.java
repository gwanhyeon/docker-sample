package com.kgh.docker_sample.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")  // 테이블 이름을 "user_table"로 변경
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class User  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;



}