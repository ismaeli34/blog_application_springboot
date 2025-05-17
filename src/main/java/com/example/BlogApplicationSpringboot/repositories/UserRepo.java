package com.example.BlogApplicationSpringboot.repositories;

import com.example.BlogApplicationSpringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


}
