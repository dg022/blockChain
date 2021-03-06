package blockChain;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class wallet {
	
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	public wallet() {
		generateKeyPair();
	}


public void generateKeyPair() {
	
	try {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
		
		//initalise the key generator and generate a keyPair
		
		keyGen.initialize(ecSpec, random);
		KeyPair keyPair = keyGen.generateKeyPair();
		
		privateKey = keyPair.getPrivate();
		publicKey = keyPair.getPublic();
		
	
}catch(Exception e) {
		throw new RuntimeException(e);
	}
}
}