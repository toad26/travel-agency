package com.travel.agency.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.agency.dao.GenericDAO;
import com.travel.agency.entities.User;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private GenericDAO<User> genericDAO;
	
	@Override
	public List<User> findAll() {
		return genericDAO.findAll(User.class);
	}

	@Override
	public User readById(Integer id) {
		return genericDAO.readById(User.class, "id", id);
	}

	@Override
	public boolean delete(User obj) {
		return genericDAO.delete(obj);
	}

	@Override
	public User save(User obj) {
		return genericDAO.save(obj);
	}

	@Override
	public User update(User obj) {
		return genericDAO.update(obj);
	}

	@Override
	public User findByUsername(String username) {
		try {
			return (User) genericDAO.getManager().createNativeQuery(
				"SELECT * FROM users WHERE username=:username", User.class)
				.setParameter("username", username).getSingleResult();
		} catch (NoResultException nre){
			return null;
		}
	}
	
	@Override
	public User findByName(String username, String password) {
		try {
			return (User) genericDAO.getManager().createNativeQuery(
				"SELECT * FROM users WHERE username=:username AND password=:sifra", User.class)
				.setParameter("username", username).setParameter("sifra", password).getSingleResult();
		} catch (NoResultException nre){
			return null;
		}
	}

}
