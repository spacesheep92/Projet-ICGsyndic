package fr.doranco.ecommerce.enums;

public enum EnumCryptage {

	DES ("DES"), // 56 bits
	AES ("AES"), // 128, 192, and 256 bits
	BLOWFISH ("Blowfish"),  // 32 bits to 448 bits (step = 8 bits)
	PBE_MD5_DES ("PBEWithMD5AndDES");  // 128 bits, ...
	
	private String algorithm;
	
	private EnumCryptage(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAlgorithm() {
		return algorithm;
	}
	
}
