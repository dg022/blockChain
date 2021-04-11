package blockChain;
import java.util.ArrayList;
import com.google.gson.*;


public class Main {
	
	public static ArrayList<block> blockchain = new ArrayList<block>(); 
	
	public static Boolean isChainValid() {
		block currentBlock; 
		block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		
		return true;
		}
		return true
		}
	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		blockchain.add(new block("Hi im the first block", "0"));		
		blockchain.add(new block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
	}

}