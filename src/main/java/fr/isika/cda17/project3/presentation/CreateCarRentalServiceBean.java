package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class CreateCarRentalServiceBean {

	
	@Inject
	private CarRentalServiceDao carRentalServiceDao;
	
	@Inject
	private UserAccountsDao userAccountsDao;
	
	private UserAccount userAccount;	  
	
	private CarRentalService crs = new CarRentalService();
	
	private Vehicule vehicule = new Vehicule();
	
	private List<UserAccount> userAccountsPurchasers = new LinkedList<>();
	
	public void create() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		crs.setVehicule(userAccount.getVehicule());
		crs.setServicetype(ServiceType.CAR_RENTAL);
		crs.setPublicationDate(LocalDateTime.now());
		crs.setIsRequest(false);
		crs.setUserAccountProvider(userAccount);
		CarRentalService created = carRentalServiceDao.create(crs);
		System.out.println(created);
	}
	
	public void createRequest() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		crs.setVehicule(userAccount.getVehicule());
		crs.setServicetype(ServiceType.CAR_RENTAL);
		crs.setPublicationDate(LocalDateTime.now());
		crs.setIsRequest(false);
		userAccountsPurchasers.add(userAccount);
		crs.setUserAccountsPurchasers(userAccountsPurchasers);
		CarRentalService created = carRentalServiceDao.create(crs);
		System.out.println(created);
	}

	public CarRentalService getCrs() {
		return crs;
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

}