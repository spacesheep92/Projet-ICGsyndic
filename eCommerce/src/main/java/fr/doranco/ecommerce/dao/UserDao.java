package fr.doranco.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.doranco.ecommerce.entity.pojo.User;
import fr.doranco.ecommerce.model.connection.MyDataSource;

public class UserDao implements IUserDao {

	@Override
	public User addUser(User user) throws Exception {
		Connection connection = MyDataSource.getInstance().getConnection();
		
		String requete = "INSERT INTO user(firstname, lastname, phone, email, password) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getPhone());
		ps.setString(4, user.getEmail());
		ps.setBytes(5, user.getPassword());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getInt(1));
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
		return user;
	}

	@Override
	public List<User> getUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		Connection connection = MyDataSource.getInstance().getConnection();
		
		String requete = "SELECT * FROM user WHERE email = ?";
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstname"));
			user.setFirstName(rs.getString("lastname"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getBytes("password"));
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
		return user;
	}

}
