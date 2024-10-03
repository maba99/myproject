package com.service_desc_2.servicedesc2.repository;

import com.service_desc_2.servicedesc2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
