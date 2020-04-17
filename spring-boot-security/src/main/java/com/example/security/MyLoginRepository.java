package com.example.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyLoginRepository extends JpaRepository<Login, Long>{

	public Login findByUserName(String userName);
}
