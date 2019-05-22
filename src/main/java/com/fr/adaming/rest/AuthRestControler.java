package com.fr.adaming.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IAuthService;


@RestController
@RequestMapping(path="api/auth")
public class AuthRestControler {
	@Autowired
	private IAuthService serviceAuth;
	@RequestMapping(path = "/login", method =RequestMethod.POST)
	public String login(@Valid @RequestBody LoginDto loginDto) {
		User u = serviceAuth.login(loginDto.getLongin(), loginDto.getPwd());
		return u.getNameUser();
	}
	
	@RequestMapping(path = "/login", method =RequestMethod.PUT)
	public String register(@Valid @RequestBody RegisterDto registerDto) {
		User u = serviceAuth.register(new User(registerDto.getNameUser(), registerDto.getLastName(), registerDto.getLongin(), registerDto.getPwd(), registerDto.getEquipe()));
		return u.getNameUser();
	}
}
