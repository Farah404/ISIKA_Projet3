package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;

@Stateless
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer create(Customer customer) {
	try {
	    entityManager.persist(customer);
	    return customer;
	} catch (Exception e) {
	    System.out.println("CustomerDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Customer customer) {
	try {
	    Customer updatedCustomer = this.entityManager.find(Customer.class, customer.getId());
//	    EntityAccount updatedEntityAccount = this.entityManager.find(EntityAccount.class, updatedCustomer.getEntityAccount());
	    updatedCustomer.setFirstName(customer.getFirstName());
	    updatedCustomer.setLastName(customer.getLastName());
	    updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
//	    updatedEntityAccount.setEmail(customer.getEntityAccount().getEmail());
//	    updatedEntityAccount.setPassword(customer.getEntityAccount().getPassword());
//	    updatedEntityAccount.setUsername(customer.getEntityAccount().getUsername());
//	    updatedEntityAccount.setSiretNumber(customer.getEntityAccount().getSiretNumber());
	    updatedCustomer.setEntityAccount(customer.getEntityAccount());
	    entityManager.merge(updatedCustomer);
	} catch (Exception e) {
	    System.out.println("CustomerDao.create() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    Customer customerToDelete = this.entityManager.find(Customer.class, id);
	    entityManager.remove(customerToDelete);
	} catch (Exception e) {
	    System.out.println("CustomerDaoImpl.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public Customer findById(Long id) {
	return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
