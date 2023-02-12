package com.example.test_java.dto;

import lombok.Data;

@Data
public class ModuleDtoRequest implements  ModuleDto {
    private String name;

    private boolean state;
}
