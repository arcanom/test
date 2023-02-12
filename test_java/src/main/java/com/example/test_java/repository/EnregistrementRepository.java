package com.example.test_java.repository;

import com.example.test_java.entity.Enregistrement;
import com.example.test_java.entity.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnregistrementRepository extends CrudRepository<Enregistrement, Integer> {
    List<Enregistrement>findEnregistrementByModuleId(int moduleId);
}
