package com.example.kassa.repository;

import com.example.kassa.entity.SkExampleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class AddObjRepoImpl implements AddObjRepo {

    private final EntityManager em;
    private final GetObjRepo getObjRepo;

    @Autowired
    public AddObjRepoImpl(EntityManager em, GetObjRepo getObjRepo) {
        this.em = em;
        this.getObjRepo = getObjRepo;
    }

    @Transactional
    @Override
    public SkExampleTable add(Long id, Long add) {
        SkExampleTable skExampleTable = getObjRepo.get(id);
        skExampleTable.getObj().setCurrent(skExampleTable.getObj().getCurrent() + add);
        em.merge(skExampleTable);
        em.flush();

        return skExampleTable;
    }

}
