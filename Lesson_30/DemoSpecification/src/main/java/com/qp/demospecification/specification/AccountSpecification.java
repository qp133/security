package com.qp.demospecification.specification;

import com.qp.demospecification.entity.Account;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification {

    public static Specification<Account> buildWhere(String username) {
        Specification<Account> where = null;
        if (username!=null) {
            CustomSpecification usernameCustom = new CustomSpecification("username", username);
            where = Specification.where(usernameCustom);
        }
        return where;
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {
    @NonNull
    private String field;

    @NonNull
    private String value;



    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("username")) {
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
        }

        return null;
    }
}
