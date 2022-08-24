package fr.isika.cda17.project3.model.solutionManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;

@Entity
public class Solution {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated
    private PaymentSystemChoice paymentSystemChoice;
    
    @Enumerated
    private MessagingSystemChoice messagingSystemChoice;
    
    @Enumerated
    private PriceDeal priceDeal;
    
    private boolean isRatingSystemIncluded;
    
    private boolean isCarPoolingsolutionIncluded;
    
    private boolean isCarRentalSolutionIncluded;
    
    private boolean isParcelSolutionIncluded;
    
    private boolean isPersonalAssistanceSolutionIncluded;
    
    private boolean isPrivate;
    
    @ManyToMany
    private List <EntityAccount> entityAccounts = new LinkedList<>();
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private CustomerInvoice customerInvoice;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private CarPoolingSolution carPoolingSolution;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    private ParcelSolution parcelSolution;

    public Solution() {
	super();
    }

    public Solution(Long id, PaymentSystemChoice paymentSystemChoice, MessagingSystemChoice messagingSystemChoice,
	    PriceDeal priceDeal, boolean isRatingSystemIncluded, boolean isCarPoolingsolutionIncluded,
	    boolean isCarRentalSolutionIncluded, boolean isParcelSolutionIncluded,
	    boolean isPersonalAssistanceSolutionIncluded, boolean isPrivate, List<EntityAccount> entityAccounts,
	    CustomerInvoice customerInvoice, CarPoolingSolution carPoolingSolution, ParcelSolution parcelSolution) {
	super();
	this.id = id;
	this.paymentSystemChoice = paymentSystemChoice;
	this.messagingSystemChoice = messagingSystemChoice;
	this.priceDeal = priceDeal;
	this.isRatingSystemIncluded = isRatingSystemIncluded;
	this.isCarPoolingsolutionIncluded = isCarPoolingsolutionIncluded;
	this.isCarRentalSolutionIncluded = isCarRentalSolutionIncluded;
	this.isParcelSolutionIncluded = isParcelSolutionIncluded;
	this.isPersonalAssistanceSolutionIncluded = isPersonalAssistanceSolutionIncluded;
	this.isPrivate = isPrivate;
	this.entityAccounts = entityAccounts;
	this.customerInvoice = customerInvoice;
	this.carPoolingSolution = carPoolingSolution;
	this.parcelSolution = parcelSolution;
    }

    public PaymentSystemChoice getPaymentSystemChoice() {
        return paymentSystemChoice;
    }

    public void setPaymentSystemChoice(PaymentSystemChoice paymentSystemChoice) {
        this.paymentSystemChoice = paymentSystemChoice;
    }

    public MessagingSystemChoice getMessagingSystemChoice() {
        return messagingSystemChoice;
    }

    public void setMessagingSystemChoice(MessagingSystemChoice messagingSystemChoice) {
        this.messagingSystemChoice = messagingSystemChoice;
    }

    public PriceDeal getPriceDeal() {
        return priceDeal;
    }

    public void setPriceDeal(PriceDeal priceDeal) {
        this.priceDeal = priceDeal;
    }

    public boolean isRatingSystemIncluded() {
        return isRatingSystemIncluded;
    }

    public void setRatingSystemIncluded(boolean isRatingSystemIncluded) {
        this.isRatingSystemIncluded = isRatingSystemIncluded;
    }

    public boolean isCarPoolingsolutionIncluded() {
        return isCarPoolingsolutionIncluded;
    }

    public void setCarPoolingsolutionIncluded(boolean isCarPoolingsolutionIncluded) {
        this.isCarPoolingsolutionIncluded = isCarPoolingsolutionIncluded;
    }

    public boolean isCarRentalSolutionIncluded() {
        return isCarRentalSolutionIncluded;
    }

    public void setCarRentalSolutionIncluded(boolean isCarRentalSolutionIncluded) {
        this.isCarRentalSolutionIncluded = isCarRentalSolutionIncluded;
    }

    public boolean isParcelSolutionIncluded() {
        return isParcelSolutionIncluded;
    }

    public void setParcelSolutionIncluded(boolean isParcelSolutionIncluded) {
        this.isParcelSolutionIncluded = isParcelSolutionIncluded;
    }

    public boolean isPersonalAssistanceSolutionIncluded() {
        return isPersonalAssistanceSolutionIncluded;
    }

    public void setPersonalAssistanceSolutionIncluded(boolean isPersonalAssistanceSolutionIncluded) {
        this.isPersonalAssistanceSolutionIncluded = isPersonalAssistanceSolutionIncluded;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<EntityAccount> getEntityAccounts() {
        return entityAccounts;
    }

    public void setEntityAccounts(List<EntityAccount> entityAccounts) {
        this.entityAccounts = entityAccounts;
    }

    public CustomerInvoice getCustomerInvoice() {
        return customerInvoice;
    }

    public void setCustomerInvoice(CustomerInvoice customerInvoice) {
        this.customerInvoice = customerInvoice;
    }

    public CarPoolingSolution getCarPoolingSolution() {
        return carPoolingSolution;
    }

    public void setCarPoolingSolution(CarPoolingSolution carPoolingSolution) {
        this.carPoolingSolution = carPoolingSolution;
    }

    public ParcelSolution getParcelSolution() {
        return parcelSolution;
    }

    public void setParcelSolution(ParcelSolution parcelSolution) {
        this.parcelSolution = parcelSolution;
    }

    public Long getId() {
        return id;
    }
    
}
