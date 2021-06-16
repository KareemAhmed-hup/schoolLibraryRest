package com.publictions.demo.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.publictions.demo.entity.Publications;
@Repository
public interface PublictionsRepository extends CrudRepository<Publications, Integer> {

 


}
