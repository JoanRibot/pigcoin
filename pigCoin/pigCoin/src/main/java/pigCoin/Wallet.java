package pigCoin;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private PublicKey address;
    private PrivateKey sKey;
    private double total_input = 0.0d;
    private double total_output = 0.0d;
    private double balance = 0.0d;
    private List<Transaction> inputTransactions = new ArrayList<>();
    private List<Transaction> outputTransactions = new ArrayList<>();

	public void setSK(PrivateKey sKey) {
                this.sKey = sKey;
	}

	public void setAddress(PublicKey address) {
                this.address = address; 
	}

	public PublicKey getAddress() {
		return this.address;
	}

        public double getTotal_input(){
                return this.total_input;
        }

        public double getTotal_ouput(){
                return this.total_output;
        }

        public double getBalance(){
                return this.balance;
        }

	public void generateKeyPair() {
                PrivateKey sKey = GenSig.generateKeyPair().getPrivate();
                setSK(sKey);
                PublicKey address = GenSig.generateKeyPair().getPublic();
                setAddress(address);
	}

        private void setTotal_input(double input){
                this.total_input += input;
        }    

        public void loadInputTransactions(BlockChain bChain) {
                bChain.getBlockChain().stream().filter(t -> t.getpKey_recipent().equals(this.address)).filter(t -> this.inputTransactions.indexOf(t) == -1).forEach(t -> {
                        this.inputTransactions.add(t);
                });
        }

        public void loadOutputTransactions(BlockChain bChain){
                bChain.getBlockChain().stream().filter(t -> t.getpKey_sender().equals(this.address)).filter(t -> this.outputTransactions.indexOf(t) == -1).forEach(t -> {
                        this.outputTransactions.add(t);
                });
        }
        
        private void setTotal_output(double output){
                this.total_output += output;
        }

        private void setBalance(){
                this.balance = this.total_input - this.total_output;
        }

        public List<Transaction> getInputTransactions() {
                return this.inputTransactions;
        }

        public List<Transaction> getOutputTransactions(){
                return this.outputTransactions;
        }

        public void loadCoins(BlockChain bChain) {
                bChain.getBlockChain().stream().filter(t -> t.getpKey_recipent().equals(this.address)).filter(t -> this.inputTransactions.indexOf(t) == -1).forEach(t -> {
                        double inpt = t.getPigcoins();
                        setTotal_input(inpt);
<<<<<<< HEAD
                });    
                bChain.getBlockChain().stream().filter(t -> t.getpKey_sender().equals(this.address)).forEach(t -> {
=======
                });

                bChain.getBlockChain().stream().filter(t -> t.getpKey_sender().equals(this.address)).filter(t -> this.outputTransactions.indexOf(t) == -1).forEach(t -> {
>>>>>>> feature
                        double oupt = t.getPigcoins();
                        setTotal_output(oupt);
                });
                
                setBalance();  
        }


        public void loadInputTransactions(BlockChain bChain) {
                bChain.getBlockChain().stream().filter(t -> t.getpKey_recipent().equals(this.address)).forEach(t -> {
                        this.inputTransactions.add(t);
                });
    
        }

<<<<<<< HEAD
        public List<Transaction> getInputTransactions() {
                return this.inputTransactions;
=======
                setBalance();
>>>>>>> feature
        }

        public List<Transaction> getOutputTransactions(){
                return this.outputTransactions;
        }

        public void loadOutputTransactions(BlockChain bChain){
                bChain.getBlockChain().stream().filter(t -> t.getpKey_sender().equals(this.address)).forEach(t -> {
                        this.outputTransactions.add(t);
                });

        }
        @Override
        public String toString(){
                return '\n' + "Wallet = " + getAddress().hashCode() + '\n' +
                        "Total input = " + total_input + '\n' +
                        "Total ouput = " + total_output + '\n' + 
                        "Balance = " + balance;
    }





    
}
