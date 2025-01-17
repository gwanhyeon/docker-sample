package com.kgh.docker_sample.repository;

import com.kgh.docker_sample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
