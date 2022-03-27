package fr.doranco.ecommerce.keys;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final class GenerateKeys {

	private GenerateKeys() {
		
	}
	
	/**
	 * Permet de gen�rer une cl� de type {@link SecretKey} utilisant l'algorithme {@code algorithm} pour un nombre de bits �gal � {@code keySize}.
	 * 
	 * @param algorithm : L'algorithme utilis�.
	 * @param keySize : Le nombre de bits.
	 * @return Une cl� de type {@link SecretKey}.
	 * 
	 * @throws NullPointerException : Si l'algoritme indiqu� est NULL ou chaine vide.
	 * @throws NoSuchAlgorithmException : Si l'algorithme indiqu� n'est pas pris en charge.
	 * @throws IllegalArgumentException : 
	 * @throws InvalidParameterException : 
	 * 
	 * @author Ryadh HADJ MOKHNECHE.
	 * @since 2022/03/15.
	 * @see generateKeyPair();
	 * 
	 */
	public final static SecretKey generateKeyCryptage(String algorithm, int keySize) throws Exception {
		
		if (algorithm == null || algorithm.isEmpty()) {
			throw new NullPointerException("L'algorithme doit �tre indiqu� !");
		}
		
		switch (algorithm) {
		
			case "DES":
				if (keySize != 56) {
					throw new IllegalArgumentException("le keySize = '" + keySize + "' bits ne convient pas !\n"
							+ "Seul 56 bits est accept�.");
				}
				break;
	
			case "AES":
				List<Integer> keySizeList = Arrays.asList(128, 192, 256);
				if (!keySizeList.contains(keySize)) {
					throw new IllegalArgumentException("le keySize = '" + keySize + "' bits ne convient pas !\n"
							+ "Seul 128, 192 et 256 bits sont accept�s.");
				}
				break;
	
			case "Blowfish":
				break;
	
			case "PBEWithMD5AndDES":
				break;

			default:
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pris en charge !\n"
						+ "Seuls les algorithmes suivants sont concern�s : 'DES'");
		}

		KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
		keyGen.init(keySize);
		return keyGen.generateKey();
	}
	
	public final static KeyPair generateKeySignature() {
		
		return null;
	}
}
