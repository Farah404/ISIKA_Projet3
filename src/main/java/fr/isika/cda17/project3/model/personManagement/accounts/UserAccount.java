package fr.isika.cda17.project3.model.personManagement.accounts;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.model.serviceManagement.Service;

@Entity
@PrimaryKeyJoinColumn(name="id")
@NamedQuery(name = "UserAccount.findByEmail", query = "SELECT ua FROM UserAccount ua WHERE ua.email = :email_param")
public class UserAccount extends Account{

    @OneToOne
    private ShoppingCart shoppingCart;

    @OneToOne(cascade=CascadeType.ALL)
    private BankDetails bankDetails;

    @OneToOne(cascade=CascadeType.ALL)
    private BillingAddress billingAddress;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Wallet wallet;

    @ManyToMany
    private List <Service> services = new LinkedList<>();

    @ManyToMany
    private List <Reservation> reservations = new LinkedList<>();
    


    public UserAccount() {
	super();
    }

  public UserAccount(Long id, String username, String email, String password, String profilePicturePath, boolean isActive,
		  LocalDateTime creationDate, AccountType accountType, ShoppingCart shoppingCart, BankDetails bankDetails,
	    BillingAddress billingAddress, Wallet wallet, List<Service> services, List<Reservation> reservations) {
	super(id, username, email, password, profilePicturePath, isActive, creationDate, accountType);
	this.shoppingCart = shoppingCart;
	this.bankDetails = bankDetails;
	this.billingAddress = billingAddress;
	this.wallet = wallet;
	this.services = services;
	this.reservations = reservations;
    }

//	public UserAccount(ShoppingCart shoppingCart, BankDetails bankDetails, BillingAddress billingAddress, Wallet wallet,
//			List<Service> services, List<Reservation> reservations) {
//		super();
//		this.shoppingCart = shoppingCart;
//		this.bankDetails = bankDetails;
//		this.billingAddress = billingAddress;
//		this.wallet = wallet;
//		this.services = services;
//		this.reservations = reservations;
//	}

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

    public List<Service> getServices() {
	return services;
    }

    public void setServices(List<Service> services) {
	this.services = services;
    }

    public List<Reservation> getReservations() {
	return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
    }


}
