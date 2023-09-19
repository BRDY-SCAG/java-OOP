package lab2;

public class BankAccount {
	private double intrst;
	private double balance;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount m = new BankAccount(7.0,1000.0);
		BankAccount n = new BankAccount(); // default constructor 
		System.out.println(m.getBalance());
		System.out.println(m.withdraw(30.5));
		System.out.println(m.applyInterest(2));
		System.out.println(m.deposit(999.0));
		System.out.println(n.getBalance());
		System.out.println(n.getIntrst());
	}
	public BankAccount(double intrst, double balance) { // constructor gives each bank accoutn obj balance and interest rate
		this.intrst = intrst;
		this.balance = balance;
	}
	
	public BankAccount() {
		intrst = 0.0;
		balance = 0.0;
	}
	public double getIntrst() {
		return intrst;
	}
	public void setIntrst(double intrst) {
		this.intrst = intrst;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double deposit(double dollars) {
		balance = dollars + balance;
		return balance;
	}

	public double withdraw(double dollars) {
		balance = balance - dollars;
		return balance;
	}
	
	public double applyInterest(double interestRateYears) { // applies the interest onto the balance then adds interest to balance
		double accountInterest = 0.0;
		accountInterest = (balance * interestRateYears * intrst) / 100;
		balance = accountInterest + balance;
		return balance;
		
		
	}
	
}

