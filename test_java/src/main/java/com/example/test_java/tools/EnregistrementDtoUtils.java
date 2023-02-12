package com.example.test_java.tools;

import com.example.test_java.dto.EnregistrementDto;
import com.example.test_java.dto.ModuleDto;
import com.example.test_java.entity.Enregistrement;
import com.example.test_java.entity.Module;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnregistrementDtoUtils {
    public EnregistrementDto convertToDTO(Enregistrement enregistrement, EnregistrementDto enregistrementDto){
        return  new ModelMapper().map(enregistrement,enregistrementDto.getClass());
    }

    public Enregistrement convertToEnregistrement(Enregistrement enregistrement,EnregistrementDto enregistrementDto){
        return  new  ModelMapper().map(enregistrementDto,enregistrement.getClass());
    }
}
