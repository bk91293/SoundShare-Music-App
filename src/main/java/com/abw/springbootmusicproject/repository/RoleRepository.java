package com.abw.springbootmusicproject.repository;

import com.abw.springbootmusicproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
        }
