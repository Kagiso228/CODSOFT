import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ATMMachine {
    private Account account;

    public ATMMachine(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: R" + account.getBalance());
    }
    public static void main(String[] args){
        ArrayList<String> transactions= new ArrayList<String>();

        //ZonedDateTime capeTownDateTime= ZonedDateTime.now(ZoneId.of("Africa/Johannesburg"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Account Number");
        long accNum= scanner.nextLong();
        Account account= new Account();
        ATMMachine atm= new ATMMachine(account);



        while(true){
            long startTime = System.currentTimeMillis();
           System.out.println("\nChoose the option below...\n1) Withdraw Cash\n2) Deposit Cash\n3) Check Balance\n4) Print the bank statement\n5) Exit");
           int option = scanner.nextInt();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            if(elapsedTime<20000){
                if(option==1){
                    System.out.println("Enter the amount you would like to withdraw");
                    double cash= scanner.nextDouble();
                    atm.withdraw(cash);
                    transactions.add(LocalDateTime.now().toString()+"     Withdrawn R"+cash+" ...  Balance: R"+ account.getBalance());

                } else if (option==2) {
                    System.out.println("Enter the amount you would like to deposit");
                    double cash= scanner.nextDouble();
                    atm.deposit(cash);
                    transactions.add(LocalDateTime.now().toString()+"     Deposited R"+cash+"...  Balance: R"+ account.getBalance());

                } else if (option==3) {
                    atm.checkBalance();

                } else if (option==4) {
                    System.out.println("This Account belongs to, Account Number: "+accNum);
                    System.out.println("This is the bank statement generated on "+ LocalDate.now()+" at "+ LocalTime.now());
                    if(transactions.size()<1){
                        System.out.println("No Transactions were done so far.");
                    }
                    else{
                        for(int i=0; i< transactions.size();i++){
                            System.out.println(transactions.get(i));
                        }
                    }

                } else if (option==5) {
                    System.out.println("Goodbye");
                    System.exit(0);

                }
                else {
                    System.out.println("Invalid option! Try Again.");
                }

            }else{
                System.out.println("Error! Transaction cannot proceed.... You've taken too long to respond...");
                System.exit(0);
            }


        }
    }
}

