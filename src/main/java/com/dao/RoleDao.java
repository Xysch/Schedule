package com.dao;

import com.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<UserRole, Long> {
}
