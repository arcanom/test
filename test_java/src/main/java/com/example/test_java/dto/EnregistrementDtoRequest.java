package com.example.test_java.dto;

import com.example.test_java.entity.Module;
import lombok.Data;

import java.util.Date;

@Data
public class EnregistrementDtoRequest implements  EnregistrementDto {
    private float rateMeasure;

    private Date dateEnregistrement;
    private float temperatureMeasure;
    
    
    private int moduleId;
}
