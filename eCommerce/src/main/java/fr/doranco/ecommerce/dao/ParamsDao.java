package fr.doranco.ecommerce.dao;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.doranco.ecommerce.enums.EnumCryptage;
import fr.doranco.ecommerce.keys.GenerateKeys;
import fr.doranco.ecommerce.model.connection.MyDataSource;

public class ParamsDao implements IParamsDao {

	@Override
	public byte[] getCleCryptage() throws Exception {
		
		String requete = "SELECT * FROM params";
		Connection connection = MyDataSource.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete);
		ResultSet rs = ps.executeQuery();
		byte[] cleCryptage = null;
		if (rs.next()) {
			cleCryptage = rs.getBytes("cle_cryptage");
		} else {
			Key key = GenerateKeys.generateKeyCryptage(EnumCryptage.DES.getAlgorithm(), 56);
			cleCryptage = key.getEncoded();
			addCleCryptage(cleCryptage);
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
		return cleCryptage;
	}

	private void addCleCryptage(byte[] cleCryptage) throws Exception {
		
		String requete = "INSERT INTO params(cle_cryptage) VALUES(?)";
		Connection connection = MyDataSource.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setBytes(1, cleCryptage);
		ps.executeUpdate();
		
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
