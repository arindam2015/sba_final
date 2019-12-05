package com.stackroute.accountmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.AccountManagerModel;
import com.stackroute.accountmanager.repository.AccountManagerRepository;
@Service
public class AccountManagerServiceImpl implements AccountManagerService {
	@Autowired
	AccountManagerRepository accountManagerRepository;
	
	public AccountManagerServiceImpl(AccountManagerRepository accountManagerRepository) {
		this.accountManagerRepository=accountManagerRepository;
	}

	@Override
	public AccountManagerModel findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		AccountManagerModel accountManagerModel=this.accountManagerRepository.findByUserIdAndUserPassword(userId, password);
	      if(accountManagerModel!=null)
	        return accountManagerModel;
	      else {
	    	  throw new UserNotFoundException("UserNotFoundException");
	      }
	}

	@Override
	public boolean saveUser(AccountManagerModel accountManager) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		boolean status = false;
	       try {
	    	   Optional<AccountManagerModel> existUser=this.accountManagerRepository.findById(accountManager.getUserId());
	    	 // User existUser= this.userAutheticationRepository.save(user);;
	    	   if(!existUser.isPresent()) {
	              this.accountManagerRepository.save(accountManager);
	              status=true;
	              return status;
	    	   }else {
	    		   throw new UserAlreadyExistsException("UserAlreadyExistsException");
	    	   }
	              
	       }catch(Exception ex) {
	    	   throw new UserAlreadyExistsException("UserAlreadyExistsException");
	       }
	}

}
