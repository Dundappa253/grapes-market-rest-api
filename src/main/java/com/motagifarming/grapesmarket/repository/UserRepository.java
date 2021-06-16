package com.motagifarming.grapesmarket.repository;

import com.motagifarming.grapesmarket.enitity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}