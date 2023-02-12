package com.example.test_java.controller;

import com.example.test_java.dto.ModuleDtoRequest;
import com.example.test_java.dto.ModuleDtoResponse;
import com.example.test_java.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("")
    public ResponseEntity<ModuleDtoResponse> create(@RequestBody ModuleDtoRequest moduleDtoRequest){
        ModuleDtoResponse dtoResponse = moduleService.create(moduleDtoRequest);
        return ResponseEntity.ok(dtoResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ModuleDtoResponse>> getAllModule(){
        List<ModuleDtoResponse> dtoResponses =  moduleService.findAll();
        if(dtoResponses.size() ==0){
            return new ResponseEntity<>(dtoResponses, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(moduleService.findAll());
    }
}
