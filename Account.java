public class Account {
    private long accNum;
    private double  balance;
    public Account(long accNum, int balance){
        this.accNum=accNum;
        this.balance=balance;
    }
    public Account(){
        this.accNum=000000000000;
        this.balance=0.0;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -=amount;
            System.out.println("Withdraw R"+amount+". Current balance is R"+balance);
        }
        else{
        System.out.println("Insufficient funds...");
        }
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited R"+amount+". Current balance is R"+balance);
    }
    /*public void checkBalance(){
        System.out.println("Current balance is R"+balance);
    }*/

}
