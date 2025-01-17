package fr.isika.cda17.project3.repository.personManagement.accounts;

import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.repository.Dao;

public interface UserDao extends Dao<User> {
    User findByUserAccountId(Long id);

    UserAccount findByUserAccountEmail(String email);
    
    User findByShoppingCartId(Long id);
    
    
    //Test

}
