package fr.doranco.ecommerce.entity.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "settings")

public class Settings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "settings_id")
	private int id;
	private byte[] EncryptKeyPassword;
	private byte[] EncryptKeyCp;
	
	public Settings() {
		super();
	}
	
	public Settings(int id, byte[] encryptKeyPassword, byte[] encryptKeyCp) {
		super();
		this.id = id;
		EncryptKeyPassword = encryptKeyPassword;
		EncryptKeyCp = encryptKeyCp;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getEncryptKeyPassword() {
		return EncryptKeyPassword;
	}

	public void setEncryptKeyPassword(byte[] encryptKeyPassword) {
		EncryptKeyPassword = encryptKeyPassword;
	}

	public byte[] getEncryptKeyCp() {
		return EncryptKeyCp;
	}

	public void setEncryptKeyCp(byte[] encryptKeyCp) {
		EncryptKeyCp = encryptKeyCp;
	}

	
	
}

