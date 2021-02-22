package pigcoin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pigCoin.BlockChain;
import pigCoin.Transaction;
import pigCoin.Wallet;

public class BlockChainTest {
    @Test
    public void summarizeTest(){
        Wallet wallet1= new Wallet();
        Wallet wallet2 = new Wallet();
        wallet1.generateKeyPair();
        wallet2.generateKeyPair();
        Transaction transaction1 = new Transaction("h1", "3", wallet1.getAddress(), wallet2.getAddress(), 29.0, "GO!");

        Wallet wallet3 = new Wallet();
        Wallet wallet4 = new Wallet();
        wallet3.generateKeyPair();
        wallet4.generateKeyPair();
        Transaction transaction2 = new Transaction("h4", "1", wallet3.getAddress(), wallet4.getAddress(), 19.0, "Take it!");

        Wallet wallet5 = new Wallet();
        Wallet wallet6 = new Wallet();
        wallet3.generateKeyPair();
        wallet4.generateKeyPair();
        Transaction transaction3 = new Transaction("f1", "5", wallet5.getAddress(), wallet6.getAddress(), 10.0, "Take it!");

        BlockChain blockChain  = new BlockChain();
        blockChain.addOrigin(transaction1);
        blockChain.addOrigin(transaction2);
        blockChain.addOrigin(transaction3);
        assertEquals(3, blockChain.getBlockChain().size());

    }
}
