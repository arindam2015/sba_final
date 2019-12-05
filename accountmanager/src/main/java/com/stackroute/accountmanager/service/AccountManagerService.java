package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.AccountManagerModel;

public interface AccountManagerService {
	boolean saveUser(AccountManagerModel accountManager) throws UserAlreadyExistsException;
	 public AccountManagerModel findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

}
