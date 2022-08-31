package Bank;

class SavingsAccount extends BankAccount {
    private double maxWithdrawals;
    private double withdrawalsPerMonth;

    SavingsAccount(String firstName, String lastName, String 
                    accountNumber, double balance, double 
                    interestRate, double maxWithdrawals, double 
                    withdrawalsPerMonth) {
        super(firstName, lastName, accountNumber, balance,
              interestRate);
        this.maxWithdrawals = maxWithdrawals;
        this.withdrawalsPerMonth = withdrawalsPerMonth;
    }
}