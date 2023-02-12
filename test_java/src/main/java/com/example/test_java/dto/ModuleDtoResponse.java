package com.example.test_java.dto;

import com.example.test_java.entity.Enregistrement;
import lombok.Data;

import java.util.List;

@Data
public class ModuleDtoResponse implements  ModuleDto {
    private int id;

    private String name;

    private boolean state;

}
