package com.stackroute.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.accountmanager.model.AccountManagerModel;
@Repository
public interface AccountManagerRepository  extends JpaRepository<AccountManagerModel, String>{
	@Query("select u from AccountManagerModel u where u.userId = (?1) and u.userPassword = (?2)")
	AccountManagerModel findByUserIdAndUserPassword(String userId, String userPassword);

}
