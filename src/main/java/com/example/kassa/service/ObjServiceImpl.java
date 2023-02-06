package com.example.kassa.service;

import com.example.kassa.dto.Response;
import com.example.kassa.entity.SkExampleTable;
import com.example.kassa.repository.AddObjRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjServiceImpl implements ObjService {

    @Autowired
    private AddObjRepo addObjRepo;

    @Override
    public Response add(Long id, Long add) {
        SkExampleTable skExampleTable = addObjRepo.add(id, add);
        Response response = new Response();
        response.current = skExampleTable.getObj().getCurrent();
        return response;
    }
}
