package com.objectMapperDemo.ObjectMapper.Repository;

import com.objectMapperDemo.ObjectMapper.Model.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectModel,Long>{
//    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
//    ObjectModel getCoffeeByName(String name);
}
