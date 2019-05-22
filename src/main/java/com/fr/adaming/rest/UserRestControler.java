package com.fr.adaming.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="api")
public class UserRestControler {
	
	@Autowired
	private IUserService service;
	
	@ApiOperation(notes ="ahhahh", value="create")
	
	@RequestMapping(path ="/users", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		service.create(user);
	}
//	@RequestMapping(path = "/users/{email}", method = RequestMethod.GET)
//	public User getByEmail(@PathVariable String email) {
//		return service.getByEmail(email);
//		
//	}
	@RequestMapping(path = "/users", method =RequestMethod.PUT)
	public void update(@RequestBody User user) {
		service.update(user);
	}
	@RequestMapping(path ="/users", method = RequestMethod.DELETE)
	public void delete(Long id) {
		service.delete(id);;
	}
	
}
