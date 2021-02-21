package pigCoin;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
    private PublicKey address;
    private PrivateKey sKey;
    private double total_input = 0.0d;
    private double total_output = 0.0d;
    private double balance = 0.0d;

	public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
	}

	public void setAddress(PublicKey address) {
        this.address = address; 
	}

	public PublicKey getAddress() {
		return this.address;
	}

	public void generateKeyPair() {
        PrivateKey sKey = GenSig.generateKeyPair().getPrivate();
        setSK(sKey);
        PublicKey address = GenSig.generateKeyPair().getPublic();
        setAddress(address);
	}
    
    @Override
    public String toString(){
        return "Wallet = " + getAddress().hashCode() + '\n' +
                "Total input = " + total_input + '\n' +
                "Total ouput = " + total_output + '\n' + 
                "Balance = " + balance;
    }
    
}
