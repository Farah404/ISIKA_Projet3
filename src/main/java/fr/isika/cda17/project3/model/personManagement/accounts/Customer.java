package fr.isika.cda17.project3.model.personManagement.accounts;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Customer extends Person{
    
    private int phoneNumber;
    

    public Customer() {
	super();
    }

    public Customer(Long id, String firstName, String lastName, Account account, int phoneNumber) {
	super(id, firstName, lastName, account);
	this.phoneNumber = phoneNumber;

    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
