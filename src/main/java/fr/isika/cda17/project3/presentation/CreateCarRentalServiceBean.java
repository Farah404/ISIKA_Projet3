package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;

@ManagedBean
@ViewScoped
public class CreateCarRentalServiceBean {

    @Inject
    private CarRentalServiceDao carRentalServiceDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    private UserAccount userAccount;

    private Service crs = new CarRentalService();

    private Vehicule vehicule = new Vehicule();

    private String startDate;

    private String endDate;

    public void init() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
    }

    public String create() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	
	
	crs	.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.CAR_RENTAL)
		.withProvider(userAccount)
		.withReferenceNumber(createReferenceNumber());

	crs = ((CarRentalService) crs).withVehicule(vehicule);
	carRentalServiceDao.create((CarRentalService) crs);
	return "subServiceList.xhtml";
	}

    public String createRequest() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	
	crs .withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.CAR_RENTAL)
		.withRequest(true)
		.withPurchaser(userAccount)
		.withReferenceNumber(createReferenceNumber());
	
	carRentalServiceDao.create((CarRentalService) crs);
	return "subServiceList.xhtml";
    }
    
    public String createReferenceNumber() {
    	int ref = carRentalServiceDao.findAll().size()+1;
    	String referenceNumber="2022-00" + ref + "-CR";
    	return referenceNumber;
    }

    public CarRentalService getCrs() {
	return (CarRentalService) crs;
    }

    public void setCrs(CarRentalService crs) {
	this.crs = crs;
    }

    public Vehicule getVehicule() {
	return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
	this.vehicule = vehicule;
    }

    public UserAccount getUserAccount() {
	return userAccount;
    }

    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

    public String getStartDate() {
	return startDate;
    }

    public String getEndDate() {
	return endDate;
    }

}
