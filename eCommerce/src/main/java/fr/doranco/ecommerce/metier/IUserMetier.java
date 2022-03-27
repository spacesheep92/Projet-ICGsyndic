package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.User;
import fr.doranco.ecommerce.entity.dto.UserDto;

public interface IUserMetier {

	User addUser(UserDto userDto) throws Exception;
	UserDto addUserDto(UserDto userDto) throws Exception;
	List<UserDto> getUsers() throws Exception;
	User seConnecter(String email, String password) throws Exception;
	UserDto getUserByEmail(String email) throws Exception;
}
