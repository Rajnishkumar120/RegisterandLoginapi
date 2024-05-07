package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyUser;

@Repository
public interface UserRepository extends CrudRepository<MyUser,Integer>{

    Optional<MyUser> findByUsername(String username);
    
    
}
