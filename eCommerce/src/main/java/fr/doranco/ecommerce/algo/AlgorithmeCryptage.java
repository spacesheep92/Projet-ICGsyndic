package fr.doranco.ecommerce.algo;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Cipher;

public final class AlgorithmeCryptage {
	
	private static List<String> cipherAlgorithms = Arrays.asList("DES", "AES", "Blowfish", "PBEWithMD5AndDES");
	
	private AlgorithmeCryptage() {
		
	}
	
	public static final byte[] encrypt(String messageToEncrypt, Key key, String algorithm) throws Exception {
		
		if (messageToEncrypt == null || algorithm.isEmpty()) {
			throw new NullPointerException("Le message � crypter ne doit pas �tre NULL ou vide !");
		}
		if (key == null) {
			throw new NullPointerException("La cl� de cryptage ne doit pas �tre NULL !");
		}
		if (algorithm == null || algorithm.isEmpty()) {
			throw new NullPointerException("L'algorithme doit �tre indiqu� !");
		}
		
		if (!cipherAlgorithms.contains(algorithm)) {
			throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge.");
		}
		switch (algorithm) {
		
			case "DES":
			case "AES":
			case "Blowfish":
			case "PBEWithMD5AndDES":
				Cipher cipher = Cipher.getInstance(algorithm);
				cipher.init(Cipher.ENCRYPT_MODE, key);
				return cipher.doFinal(messageToEncrypt.getBytes("UTF-8"));
				
			default :
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore impl�ment�.");
		}
	}

	public static final String decrypt(byte[] messageCrypte, Key key, String algorithm) throws Exception {
		
		if (messageCrypte == null) {
			throw new NullPointerException("Le message � d�crypter ne doit pas �tre NULL !");
		}
		if (key == null) {
			throw new NullPointerException("La cl� de cryptage ne doit pas �tre NULL !");
		}
		if (algorithm == null || algorithm.isEmpty()) {
			throw new NullPointerException("L'algorithme doit �tre indiqu� !");
		}
		
		if (!cipherAlgorithms.contains(algorithm)) {
			throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge.");
		}
		switch (algorithm) {
		
			case "DES":
			case "AES":
			case "Blowfish":
			case "PBEWithMD5AndDES":
				Cipher cipher = Cipher.getInstance(algorithm);
				cipher.init(Cipher.DECRYPT_MODE, key);
				byte[] messageDecrypte = cipher.doFinal(messageCrypte);
				return new String(messageDecrypte);
			
			default :
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge.");
		}
		
	}

}
