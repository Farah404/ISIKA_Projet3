package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import fr.isika.cda17.project3.model.financialManagement.invoice.StoreInvoice;
import fr.isika.cda17.project3.repository.Dao;

public interface StoreInvoiceDao extends Dao<StoreInvoice> {

	List<StoreInvoice> findAllUserAccountStoreInvoice(Long id);

}
