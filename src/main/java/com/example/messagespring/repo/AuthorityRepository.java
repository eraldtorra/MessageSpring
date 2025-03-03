package com.example.messagespring.repo;

import com.example.messagespring.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority getAuthorityById(int i);
}
