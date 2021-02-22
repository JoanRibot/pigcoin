package pigcoin;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pigCoin.BlockChain;
import pigCoin.Transaction;
import pigCoin.Wallet;

public class WalletTest {
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

        wallet3 = new Wallet();
        wallet4 = new Wallet();
        wallet3.generateKeyPair();
        wallet4.generateKeyPair();
        transaction2 = new Transaction("h4", "1", wallet3.getAddress(), wallet1.getAddress(), 35.0, "Take it!");

        wallet5 = new Wallet();
        wallet6 = new Wallet();
        wallet5.generateKeyPair();
        wallet6.generateKeyPair();
        transaction3 = new Transaction("f1", "5", wallet5.getAddress(), wallet6.getAddress(), 10.0, "Take it!");

        blockChain  = new BlockChain();
        blockChain.addOrigin(transaction1);
        blockChain.addOrigin(transaction2);
        blockChain.addOrigin(transaction3);

    }

    @Test 
    public void loadCoinsTest(){
        wallet1.loadCoins(blockChain);

        assertEquals(35.0d, wallet1.getTotal_input(),0.01);
        assertEquals(29.0d, wallet1.getTotal_ouput(),0.01);
        assertEquals(6.0d, wallet1.getBalance(),0.01);


    }

}
