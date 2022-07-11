package com.objectMapperDemo.ObjectMapper.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectMapperDemo.ObjectMapper.Model.ObjectModel;
import com.objectMapperDemo.ObjectMapper.Repository.ObjectRepository;
import com.objectMapperDemo.ObjectMapper.Service.ObjectService;
import org.apache.el.parser.AstString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ObjectController {
    @Autowired
    private ObjectRepository objectRepository;
    @Autowired
    private ObjectService objectService;
    @RequestMapping(method = RequestMethod.POST)
    public ObjectModel getCoffeeByName(@RequestBody ObjectModel name){
        return objectService.getCoffeeByName(name);
    }
    @GetMapping("getAllObject")
    public List<ObjectModel> getAllObject(){
        return objectService.getAllObject();
    }
    //Objects Convert To String Using ObjectMapper
    @PostMapping("getObjects")
    //Using @PostMapping we can Give Class Objects Through @RequestBody
    //Here We have to compulsory use @PostMapping for given class object declaration
    public String getObjects(@RequestBody ObjectModel objectModel) throws JsonProcessingException {
        return objectService.getObjects(objectModel);

    }
    // Object Conversion String to Json Using ObjectMapper
    @GetMapping("getGivenDetails")
    public String getObjectModel() throws JsonProcessingException {
        // Here We can Give List of Objects That Need to convert String Using ObjectMapper
        List<ObjectModel> models=new ArrayList<>();//Creating ArrayList
        ObjectMapper objectMapper=new ObjectMapper();//Initialize ObjectMapper
        //Declare The Objects
        models.add(new ObjectModel(1l,"damian", "Developer", "Male"));
        models.add(new ObjectModel(2l, "noel", "Developer", "Male"));
        models.add(new ObjectModel(3l, "amena", "CEO", "Female"));
        models.add(new ObjectModel(4l, "eugenia", "Developer", "Male"));
        models.add(new ObjectModel(5l, "mckee", "Developer", "Female"));
        //writeValueAsString is One Of the Method in ObjectMapper to Convert the String
        return objectMapper.writeValueAsString(models);
    }
}
