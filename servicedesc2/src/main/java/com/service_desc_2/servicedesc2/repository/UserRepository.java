package com.service_desc_2.servicedesc2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.service_desc_2.servicedesc2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
