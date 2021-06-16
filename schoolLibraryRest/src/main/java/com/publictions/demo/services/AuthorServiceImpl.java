package com.publictions.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publictions.demo.dao.AuthorRepository;
import com.publictions.demo.entity.Author;
import com.publictions.demo.entity.Publications;
import com.publictions.demo.entity.exception.AuthorNotFoundException;


@Service
public class AuthorServiceImpl{

	
	private  AuthorRepository authorRepo;

	private  PublictionsServicesImpl publicationservice;
	
	@Autowired
	public  AuthorServiceImpl(AuthorRepository authorRepo,PublictionsServicesImpl publicationservice) {
		this.authorRepo = authorRepo;
		this.publicationservice = publicationservice;
	}

	@Transactional
	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	@Transactional
	public List<Author> getAuthors(){
		return StreamSupport.stream(authorRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Transactional
	public Author getAuthor(int theId) {
		return authorRepo.findById(theId).orElseThrow(
				()-> new AuthorNotFoundException(theId));
	}


	@Transactional
	public List<Author> findAllByEmail(String email){
		return StreamSupport.stream(authorRepo.findAll().spliterator(), false)
		.filter(a->a.getEmail().contentEquals(email)).collect(Collectors.toList()); 
	}


	@Transactional
	public Author addPublictionToAuthor(int publId,int authorId) {
		
		Publications publiction = publicationservice.getPublications(publId);
		
		Author author = getAuthor(authorId);
		
		author.add(publiction);
		
		return author;
	}
	

}
