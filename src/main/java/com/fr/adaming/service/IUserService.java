package com.fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.User;
@Service

public interface IUserService {
	
	public User create(User user);
	public User readByID(Long id);
	public List<User> readAll();
	public void update(User user);
	public User getByEmail(User user);
	public boolean delete(Long id);
}
