package pigcoin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pigCoin.Transaction;
import pigCoin.Wallet;

public class TransactionTest {
    @Test
    public void constructorTest(){
        Wallet wallet1= new Wallet();
        Wallet wallet2 = new Wallet();
        wallet1.generateKeyPair();
        wallet2.generateKeyPair();

        Transaction transaction = new Transaction("h1", "3", wallet1.getAddress(), wallet2.getAddress(), 29.0, "GO!");

        assertEquals("h1", transaction.getHash());
        assertEquals("3",  transaction.getPrev_hash());
        assertEquals(wallet1.getAddress(), transaction.getpKey_sender());
        assertEquals(wallet2.getAddress(), transaction.getpKey_recipent());
        assertEquals(29.0d, transaction.getPigcoins(),0.0);
        assertEquals("GO!", transaction.getMessage());

    }
}
