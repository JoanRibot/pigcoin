package pigCoin;

import java.security.PublicKey;

public class Transaction {
    private String hash;
    private String prev_hash;
    private PublicKey pKey_sender;
    private PublicKey pKey_recipent;
    private double pigcoins;
    private String message;

    public Transaction(){
    }

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipent, double pigcoins,
            String message) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = pKey_sender;
        this.pKey_recipent = pKey_recipent;
        this.pigcoins = pigcoins;
        this.message = message;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPrev_hash() {
        return this.prev_hash;
    }

    public PublicKey getpKey_sender() {
        return this.pKey_sender;
    }

    public PublicKey getpKey_recipent() {
        return this.pKey_recipent;
    }

    public double getPigcoins() {
        return this.pigcoins;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return '\n' +"hash = " + getHash() + '\n' + 
                "prev_hash = " + getPrev_hash() + '\n' +
                "pKey_sender = " + getpKey_sender().hashCode() + '\n' +
                "pKey_recipent = " + getpKey_recipent().hashCode() + '\n' +
                "pigcoins = " + getPigcoins() + '\n' +
                "message = " + getMessage() + '\n';
    }

}
