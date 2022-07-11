package com.objectMapperDemo.ObjectMapper.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.objectMapperDemo.ObjectMapper.Model.ObjectModel;

import java.util.List;


public interface ObjectServiceImpl {
    ObjectModel getCoffeeByName(ObjectModel name);

    List<ObjectModel> getAllObject();

    String getObjects(ObjectModel objectModel) throws JsonProcessingException;
}
