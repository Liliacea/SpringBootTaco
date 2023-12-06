package com.example.tacocloud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = JdbcIngredientRepositoryTest.class)
@ComponentScan(basePackages = "com.example.tacocloud")
class JdbcIngredientRepositoryTest {

//    @Autowired
 //   private JdbcIngredientRepository dao;

    @Test
    void save() {
    }

    @Test
    void findAll() {
  ///      List<Ingredient> ingredients = dao.findAll();
     //   Assertions.assertEquals(10, ingredients.size());
    }

    @Test
    void findById() {
    }
}