package labs;
class BankAccount implements IIntrest{
	//properties of bank account 
	private static int ID = 0;                       //Internal ID
	private String accountNumber; //ID + 2 random digit number + 2first SSN
	private static final String routingNumber = "00456"; 
	private String name;
	private String SSN; 
	double balance;
	
	public BankAccount(String SSN, double intDeposit) {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("New Account Created!!!");
		balance = intDeposit;
		this.SSN = SSN;
		//everytime a new account is created the ID will increase 
		ID++;
		setAccountNumber();
		balance = intDeposit;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private void setAccountNumber(){
		//math.random generates a value between o and 1
		int Ran = (int) (Math.random() * 100);
		accountNumber = ID + ""+ Ran + SSN.substring(0, 2);
		System.out.println("Your account number: " + accountNumber);
	}
	public void payBill(double Amount){
		balance = balance - Amount;
		System.out.println("Paying bill" + Amount);
		showBalance();
	}
	public void makeDeposit(double Amount){	
		balance = balance + Amount;
		System.out.println("Making Deposit: " + Amount);
		showBalance();
	}
	
	public void showBalance(){
		System.out.println("Balance: " + balance); 
	}
	
	public void accrueIntrest(){	
	}

	@Override
	public void accrue() {
		// TODO Auto-generated method stub
		balance = balance * (1 + Rate/100);
		showBalance();
	}
	@Override
	public String toString(){
		return "[Name: " + name +  "]\n[Account NUmber: " + accountNumber + "]\n" + "[Balance:" + balance + "]";
	}
}


public class BankAccountApp {

	public static void main(String [] args){
		BankAccount acct1 = new BankAccount("076889455", 1000);
		acct1.setName("alex");
		System.out.println(acct1.getName());
		acct1.makeDeposit(500);
		acct1.makeDeposit(800);
		acct1.payBill(1000);
		acct1.accrue();
		System.out.println(acct1.toString());
		
		BankAccount acct2 = new BankAccount("385674234", 2000);
		BankAccount acct3 = new BankAccount("908542135", 500);
		
	
		
		
	}
}
