package com.example.test_java.service;

import com.example.test_java.dto.EnregistrementDto;
import com.example.test_java.dto.EnregistrementDtoRequest;
import com.example.test_java.dto.EnregistrementDtoResponse;
import com.example.test_java.entity.Enregistrement;
import com.example.test_java.entity.Module;
import com.example.test_java.repository.EnregistrementRepository;
import com.example.test_java.repository.ModuleRepository;
import com.example.test_java.tools.EnregistrementDtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EnregistrementService {

    @Autowired
    EnregistrementRepository enregistrementRepository;

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    EnregistrementDtoUtils dtoUtils;

    public EnregistrementDtoResponse create(EnregistrementDtoRequest enregistrementDtoRequest){
        Enregistrement enregistrement =  dtoUtils.convertToEnregistrement(new Enregistrement(),enregistrementDtoRequest);
        return (EnregistrementDtoResponse) dtoUtils.convertToDTO(enregistrementRepository.save(enregistrement),new EnregistrementDtoResponse());
    }
    public List<EnregistrementDtoResponse> findEnregistrementByModuleId(int moduleId){
        List<Enregistrement> enregistrements =  enregistrementRepository.findEnregistrementByModuleId(moduleId);
        List<EnregistrementDtoResponse> responses =  new ArrayList<>();
        for(Enregistrement e: enregistrements){
            EnregistrementDtoResponse enregistrementDtoResponse = (EnregistrementDtoResponse) dtoUtils.convertToDTO(e,new EnregistrementDtoResponse());
            responses.add(enregistrementDtoResponse);
        }
        return responses;
    }

}
