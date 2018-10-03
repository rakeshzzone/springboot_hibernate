package com.test.application.controllers;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserData, Long> {

}
