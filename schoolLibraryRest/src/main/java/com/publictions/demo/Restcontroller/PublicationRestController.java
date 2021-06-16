package com.publictions.demo.Restcontroller;

import java.util.List;

import com.publictions.demo.entity.Publications;
import com.publictions.demo.services.PublictionsServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicationRestController {
    
    @Autowired
    private PublictionsServicesImpl publictionservice;


    // get all Publiction from the database 
    @GetMapping("/publications")
	public ResponseEntity<List<Publications>> getAllPublictions(){
		try {
            // create list to read the data from Serice layer 
			List<Publications> publictions = publictionservice.getAllPublictions();
			// check if the data is isEmpty 
			if (publictions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			// return the list of Publication 
			return new ResponseEntity<>(publictions,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/publications/{isbn}")
	public ResponseEntity<List<Publications>> getPublictionsByisbn(@PathVariable String isbn){
		try {
            // create list to read the data from Serice layer 
			List<Publications> publictions = publictionservice.getPublictionsByisbn(isbn);
			// check if the data is isEmpty 
			if (publictions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			// return the list of Publication 
			return new ResponseEntity<>(publictions,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

   





}
