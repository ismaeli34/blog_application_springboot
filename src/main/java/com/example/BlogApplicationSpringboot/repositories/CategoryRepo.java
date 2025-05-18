package com.example.BlogApplicationSpringboot.repositories;
import com.example.BlogApplicationSpringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
