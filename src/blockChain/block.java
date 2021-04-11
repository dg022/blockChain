package blockChain;

import java.util.Date;

public class block {
	
	public String hash; 
	public String previousHash;
	private String data;
	private long timeStamp; 
	public block(String data, String previousHash) {
		
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp  = new Date().getTime();
		this.hash = calculateHash(); 
		
	}
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}

}
