package com.example.test_java.tools;

import com.example.test_java.dto.ModuleDto;
import com.example.test_java.entity.Module;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class ModuleDtoUtils {

    public ModuleDto convertToDTO(Module module,ModuleDto moduleDto){
      return  new ModelMapper().map(module,moduleDto.getClass());
    }

    public Module convertToModule(Module module,ModuleDto moduleDto){
        return  new  ModelMapper().map(moduleDto,module.getClass());
    }

}
