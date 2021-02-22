package pigCoin;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Transaction> blockChain = new ArrayList<>();


    public void addOrigin(Transaction transaction){
        blockChain.add(transaction);
    }

    public List<Transaction> getBlockChain(){
        return this.blockChain;
    }

	public void summarize() {
        for(Transaction transaction:this.blockChain){
            System.out.println('\n' +transaction.toString() + '\n');
        }
	}

    public void summarize(int position){
        System.out.println('\n' + blockChain.get(position).toString());
    }

}
