package com.zulo.controller;

import java.util.List;

import com.zulo.model.User;
import com.zulo.repository.ZulaDatabase;

public class LoginController {
	private ZulaDatabase db = ZulaDatabase.getInstanceOf();

	public User isValidCredential(String name, String password, int access) {
		List<User> user;
		user = db.getUsers().stream()
				.filter(x -> (x.getAccess() == access && x.getName().equals(name) && x.getPassword().equals(password)))
				.toList();
		if (user.isEmpty() || user == null)
			return null;
		return user.get(0);
	}

}
