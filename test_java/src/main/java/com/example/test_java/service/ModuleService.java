package com.example.test_java.service;

import com.example.test_java.dto.ModuleDtoRequest;
import com.example.test_java.dto.ModuleDtoResponse;
import com.example.test_java.entity.Module;
import com.example.test_java.repository.ModuleRepository;
import com.example.test_java.tools.ModuleDtoUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ModuleDtoUtils moduleDtoUtils;

    public ModuleDtoResponse create(ModuleDtoRequest moduleDtoRequest){
        Module module = moduleDtoUtils.convertToModule(new Module(),moduleDtoRequest);
        return (ModuleDtoResponse) moduleDtoUtils.convertToDTO(moduleRepository.save(module),new ModuleDtoResponse());
    }



    public List<ModuleDtoResponse> findAll(){
        List<Module> modules =  moduleRepository.findAll();
        List<ModuleDtoResponse> responses =  new ArrayList<>();
        for(Module module: modules){
            ModuleDtoResponse moduleDtoResponse = (ModuleDtoResponse) moduleDtoUtils.convertToDTO(module,new ModuleDtoResponse());
            responses.add(moduleDtoResponse);
        }
        return  responses;
    }


}
