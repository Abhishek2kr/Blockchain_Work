package noobchain;
import java.util.Date;

public class Block {
     
	public String hash;
	public String previousHash;
	private String data; // our data will be simple message.
	private long timeStamp; // as number of milliseconds since 1/1/1970.
	private int nonce;
	
	//Block constructer
	public Block(String data,String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); 
	}
	
	public String calculateHash() {
		String calculatehash = StringUtil.applySha256(previousHash + 
				Long.toString(timeStamp) + Integer.toString(nonce) +
				data
				);
		return calculatehash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0','0');
		while(!hash.substring(0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
			
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
