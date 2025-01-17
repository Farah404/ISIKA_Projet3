package fr.isika.cda17.project3.model.personManagement.accounts;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.solutionManagement.Solution;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@NamedQuery(name = "EntityAccount.findByEmail", query = "SELECT ea FROM EntityAccount ea WHERE ea.email = :email_param")
public class EntityAccount extends Account {

    private String name;

    private int siretNumber;

    private boolean isPrivate;

    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.ALL)
    private BankDetails bankDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private BillingAddress billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToOne(cascade = CascadeType.MERGE)
    private Solution solution;

    public EntityAccount() {
	super();
    }

    public EntityAccount(Long id, String username, String email, String password, String profilePicturePath,
	    boolean isActive, LocalDateTime creationDate, AccountType accountType, String name, int siretNumber,
	    boolean isPrivate, ShoppingCart shoppingCart, BankDetails bankDetails, BillingAddress billingAddress,
	    Wallet wallet, Solution solution) {
	super(id, username, email, password, profilePicturePath, isActive, creationDate, accountType);
	this.name = name;
	this.siretNumber = siretNumber;
	this.isPrivate = isPrivate;
	this.shoppingCart = shoppingCart;
	this.bankDetails = bankDetails;
	this.billingAddress = billingAddress;
	this.wallet = wallet;
	this.solution = solution;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getSiretNumber() {
	return siretNumber;
    }

    public void setSiretNumber(int siretNumber) {
	this.siretNumber = siretNumber;
    }

    public boolean isPrivate() {
	return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
	this.isPrivate = isPrivate;
    }

    public ShoppingCart getShoppingCart() {
	return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
    }

    public BankDetails getBankDetails() {
	return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
	this.bankDetails = bankDetails;
    }

    public BillingAddress getBillingAddress() {
	return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
    }

    public Wallet getWallet() {
	return wallet;
    }

    public void setWallet(Wallet wallet) {
	this.wallet = wallet;
    }

    public Solution getSolution() {
	return solution;
    }

    public void setSolution(Solution solution) {
	this.solution = solution;
    }

}