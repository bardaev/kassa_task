package com.example.kassa.controller;

import com.example.kassa.dto.Request;
import com.example.kassa.dto.Response;
import com.example.kassa.service.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private ObjService objService;

    @PostMapping(path = "modify")
    public Response modify(@RequestBody Request req) {
        return objService.add(req.id, req.add);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Client error")
    public void handle() {

    }
}
