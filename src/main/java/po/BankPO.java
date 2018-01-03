package po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="Bank")
public class BankPO implements Serializable{
	//created by peng 
	String name;
	double balance;//余额

	public BankPO(){}

	public BankPO(String name, double balance){
		this.name=name;
		this.balance=balance;
	}
	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
