package fr.isika.cda17.project3.model.financialManagement.invoice;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private String invoiceNumber;

    private LocalDate invoiceIssueDate;

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    public Invoice() {
	super();
    }

    public Invoice(Long id, String invoiceNumber, LocalDate invoiceIssueDate, InvoiceType invoiceType) {
	super();
	this.id = id;
	this.invoiceNumber = invoiceNumber;
	this.invoiceIssueDate = invoiceIssueDate;
	this.invoiceType = invoiceType;
    }

    public String getInvoiceNumber() {
	return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
	this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceIssueDate() {
	return invoiceIssueDate;
    }

    public void setInvoiceIssueDate(LocalDate invoiceIssueDate) {
	this.invoiceIssueDate = invoiceIssueDate;
    }

    public InvoiceType getInvoiceType() {
	return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
	this.invoiceType = invoiceType;
    }

    public Long getId() {
	return id;
    }

}
