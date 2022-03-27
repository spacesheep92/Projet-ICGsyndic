package fr.doranco.ecommerce.metier;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.ecommerce.model.connection.MyDataSource;
import fr.doranco.ecommerce.dao.IParamsDao;
import fr.doranco.ecommerce.dao.IUserDao;
import fr.doranco.ecommerce.dao.UserDao;
import fr.doranco.ecommerce.algo.AlgorithmeCryptage;
import fr.doranco.ecommerce.enums.EnumCryptage;
import fr.doranco.ecommerce.dao.ParamsDao;
import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.entity.pojo.User;


public class UserMetier implements IUserMetier {

	private IUserDao userDao = new UserDao();
	private IParamsDao paramsDao = new ParamsDao();
	
	@Override
	public User addUser(UserDto userDto) throws Exception {
		
		User user = new User();
		user.setLastName(userDto.getlastName().toUpperCase());
		user.setFirstName(userDto.getfirstName().substring(0, 1).toUpperCase().concat(userDto.getfirstName().substring(1).toLowerCase()));
		user.setEmail(userDto.getEmail());
		
		byte[] cleCryptage = paramsDao.getCleCryptage();
		SecretKey key = new SecretKeySpec(cleCryptage, 0, cleCryptage.length, EnumCryptage.DES.getAlgorithm());
		byte[] passwordCrypte = AlgorithmeCryptage.encrypt(userDto.getPassword(), key, EnumCryptage.DES.getAlgorithm());
		user.setPassword(passwordCrypte);
		
		return userDao.addUser(user);
	}

	@Override
	public List<UserDto> getUsers() throws Exception {
		
		List<UserDto> userDto = new ArrayList<UserDto>();

		return userDto;
	}

	@Override
	public UserDto getUserByEmail(String email) throws Exception {
		Connection connection = MyDataSource.getInstance().getConnection();
		
		String requete = "SELECT * FROM user WHERE email = ?";
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		UserDto user = null;
		if (rs.next()) {
			user = new UserDto();
			user.setId(rs.getString("id"));
			user.setfirstName(rs.getString("firstname"));
			user.setlastName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setbirthday(rs.getString("birthday"));
			user.setPassword(rs.getString("password"));
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
		return user;
	}

	@Override
	public User seConnecter(String email, String password) throws Exception {
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			byte[] cleCryptage = paramsDao.getCleCryptage();
			Key key = new SecretKeySpec(cleCryptage, EnumCryptage.DES.getAlgorithm());
			String passwordDataBase = AlgorithmeCryptage.decrypt(user.getPassword(), key, EnumCryptage.DES.getAlgorithm());
			if (passwordDataBase.equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public UserDto addUserDto(UserDto userDto) throws Exception {
		
		User user = new User();
		userDao.addUser(user);
		userDto.setId(String.valueOf(user.getId()));
		
		return userDto;
	}

}
