package com.objectMapperDemo.ObjectMapper.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectMapperDemo.ObjectMapper.Model.ObjectModel;
import com.objectMapperDemo.ObjectMapper.Repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService implements ObjectServiceImpl{
    @Autowired
    private ObjectRepository objectRepository;


    @Override
    public ObjectModel getCoffeeByName(ObjectModel name) {
        return objectRepository.save(name);
    }

    @Override
    public List<ObjectModel> getAllObject() {
        return objectRepository.findAll();
    }

    @Override
    public String getObjects(ObjectModel objectModel) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(objectModel);
    }
}
