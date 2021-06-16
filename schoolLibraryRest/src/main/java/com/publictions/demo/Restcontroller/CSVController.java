package com.publictions.demo.Restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.publictions.demo.helper.CSVHelper;
import com.publictions.demo.message.ResponseMessage;
import com.publictions.demo.services.CSVService;
import com.publictions.demo.services.PublictionsServicesImpl;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/csv")
public class CSVController {
	
	@Autowired
	CSVService fileService;
	@Autowired
	PublictionsServicesImpl publictionService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile( @RequestParam("file")  MultipartFile file){
		
		String message ="";
		
		if (CSVHelper.hasCSVFormat(file)) {

			try {
					fileService.save(file);
				
					message = "Uploaded the file Successfully" + file.getOriginalFilename();
					
					return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
					
				} catch (Exception e) {

					message= e.getMessage() + file.getOriginalFilename() + "!";
					
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
			
		}
		
		message="please upload a csv file!";
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	

	
	
	
	
	
	
	
	
	
	

}
