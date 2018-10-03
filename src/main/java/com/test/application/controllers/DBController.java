package com.test.application.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user", method = RequestMethod.POST)
public class DBController {
	@Autowired
	private UserRepo userRepo;

	@GetMapping(path = "/adduser", consumes = "application/json")
	public @ResponseBody String addUser(@RequestBody JSONObject req) {

		UserData userClass = new UserData();
		userClass.setName(req.get("name").toString());
		userClass.setEmail(req.get("email").toString());
		userRepo.save(userClass);

		return "SUCCESS";

	}

	@GetMapping(path = "/getalluser")
	public @ResponseBody Iterable<UserData> getAlluser() {

		return userRepo.findAll();

	}

}
