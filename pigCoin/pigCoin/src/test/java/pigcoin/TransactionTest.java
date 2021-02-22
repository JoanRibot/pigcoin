package pigcoin;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pigCoin.BlockChain;
import pigCoin.Transaction;
import pigCoin.Wallet;

public class TransactionTest {
    Wallet wallet1;
    Wallet wallet2;
    Wallet wallet3;
    Wallet wallet4;
    Wallet wallet5;
    Wallet wallet6;

    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;

    BlockChain blockChain;

    @Before
    public void setup(){
        wallet1= new Wallet();
        wallet2 = new Wallet();
        wallet1.generateKeyPair();
        wallet2.generateKeyPair();

        transaction1 = new Transaction("h1", "3", wallet1.getAddress(), wallet2.getAddress(), 29.0, "GO!");
    }
    @Test
    public void constructorTest(){
        assertEquals("h1", transaction1.getHash());
        assertEquals("3",  transaction1.getPrev_hash());
        assertEquals(wallet1.getAddress(), transaction1.getpKey_sender());
        assertEquals(wallet2.getAddress(), transaction1.getpKey_recipent());
        assertEquals(29.0d, transaction1.getPigcoins(),0.0);
        assertEquals("GO!", transaction1.getMessage());
    }

}
