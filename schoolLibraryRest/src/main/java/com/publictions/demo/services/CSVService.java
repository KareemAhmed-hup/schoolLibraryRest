package com.publictions.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.publictions.demo.dao.AuthorRepository;
import com.publictions.demo.dao.PublictionsRepository;
import com.publictions.demo.entity.Author;
import com.publictions.demo.entity.Publications;
import com.publictions.demo.helper.CSVHelper;

@Service
public class CSVService {

	
	PublictionsRepository publicRepo;
	
	AuthorRepository authorRepository;	
	
	
	@Autowired
	public CSVService(PublictionsRepository publicRepo, AuthorRepository authorRepository) {
		this.publicRepo = publicRepo;
		this.authorRepository = authorRepository;
	}

	public void save (MultipartFile file) {
		
		try {
			
			List<Publications> publList = CSVHelper.csvPubliction(file.getInputStream());
			
			List<Author> authors = CSVHelper.csvAuthors(file.getInputStream());
			
			authorRepository.saveAll(authors);
			
			publicRepo.saveAll(publList);
			
			} catch (IOException e) {
			
			throw new RuntimeException("fail to Stor csv data:" + e.getMessage());
			
			}
			
	}
	

}
