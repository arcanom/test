package com.example.test_java.controller;


import com.example.test_java.dto.EnregistrementDtoRequest;
import com.example.test_java.dto.EnregistrementDtoResponse;
import com.example.test_java.service.EnregistrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mistreatment")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class EnregistrementController {
    @Autowired
    private EnregistrementService enregistrementService;

    @PostMapping("")
    public ResponseEntity<EnregistrementDtoResponse> create(@RequestBody EnregistrementDtoRequest enregistrementDtoRequest){
        EnregistrementDtoResponse dtoResponse = enregistrementService.create(enregistrementDtoRequest);
        return ResponseEntity.ok(dtoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EnregistrementDtoResponse>> getEnregistrementByModuleId(@PathVariable int id){
        List<EnregistrementDtoResponse> dtoResponse = enregistrementService.findEnregistrementByModuleId(id);
        if(dtoResponse == null){
            return new ResponseEntity<>(dtoResponse, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(enregistrementService.findEnregistrementByModuleId(id));
    }

}
