package com.example.test_java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.test_java.entity.Module;

import java.util.List;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Integer> {
        Module findModuleById(int id);

        List<Module> findAll();
}
