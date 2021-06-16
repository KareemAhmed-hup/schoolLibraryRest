package com.publictions.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.publictions.demo.entity.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {


    public List<Author> getAuthorsByEmail(String email);
    

}
