package com.fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IEquipeService;

//REST= “Representational State Transfer” basée sur http "Hypertext Transfer Protocol"

@RestController
@RequestMapping(path="api")
public class EquipeRestController {
	@Autowired
	private IEquipeService service;
	@RequestMapping(path ="/equipe", method = RequestMethod.POST)
	public void create(@RequestBody Equipe e) {
		service.create(e);
	}
	@RequestMapping(path = "/equipe", method =RequestMethod.PUT)
	public void update(@RequestBody Equipe equipe) {
		service.update(equipe);
}
}
