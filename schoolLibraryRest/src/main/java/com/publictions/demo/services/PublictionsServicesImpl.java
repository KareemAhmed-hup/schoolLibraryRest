package com.publictions.demo.services;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publictions.demo.dao.PublictionsRepository;
import com.publictions.demo.entity.Publications;
import com.publictions.demo.entity.exception.PublictionNotFoundException;

@Service
public class PublictionsServicesImpl {
	
	
	private  PublictionsRepository publicRepo;
	
	
	@Autowired
	public  PublictionsServicesImpl(PublictionsRepository publicRepo) {
		this.publicRepo = publicRepo;
	}

	@Transactional

	public Publications addPubliction(Publications publications) {
		return publicRepo.save(publications);
	}
	
	@Transactional
	public List<Publications> getAllPublictions(){
		return StreamSupport.stream(publicRepo.findAll()
				.spliterator(), false).collect(Collectors.toList()) ;
	}	

	@Transactional
	public List<Publications> getPublictionsByisbn(String isbn){
		return StreamSupport.stream(publicRepo.findAll()
				.spliterator(), false).filter(s->s.getISBN().contentEquals(isbn))
				.collect(Collectors.toList()) ;
	}	


	@Transactional

	public Publications getPublications(int theId) {
		return publicRepo.findById(theId).orElseThrow(
				()-> new PublictionNotFoundException(theId));
	}
	@Transactional

	public Publications deletePubliction(int id) {
		Publications tempPublication = getPublications(id);
		publicRepo.delete(tempPublication);
		
		return tempPublication;
	}
	



	

	
	
	
}
