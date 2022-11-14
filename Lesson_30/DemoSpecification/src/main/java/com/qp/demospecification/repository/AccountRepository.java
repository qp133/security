package com.qp.demospecification.repository;

import com.qp.demospecification.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends  JpaRepository<Account, Integer>,
                                            JpaSpecificationExecutor<Account> {

}