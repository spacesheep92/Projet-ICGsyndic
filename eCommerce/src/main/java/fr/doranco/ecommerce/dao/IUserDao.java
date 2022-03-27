package fr.doranco.ecommerce.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.User;

public interface IUserDao {

	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	User getUserByEmail(String email) throws Exception;
}
