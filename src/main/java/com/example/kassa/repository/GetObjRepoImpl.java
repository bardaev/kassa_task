package com.example.kassa.repository;

import com.example.kassa.entity.SkExampleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@Service
public class GetObjRepoImpl implements GetObjRepo {

    private final EntityManager em;

    @Autowired
    public GetObjRepoImpl(EntityManager em) {
        this.em = em;
    }


    @Transactional
    @Override
    public SkExampleTable get(Long id) {
        SkExampleTable skExampleTable = (SkExampleTable) em.createQuery("select s from SkExampleTable s where s.id = :id")
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .setHint("javax.persistence.lock.timeout", 1000)
                .setParameter("id", id)
                .getSingleResult();
        return skExampleTable;
    }
}
