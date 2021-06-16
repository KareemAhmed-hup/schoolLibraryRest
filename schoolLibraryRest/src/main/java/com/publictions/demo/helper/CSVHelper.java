package com.publictions.demo.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.publictions.demo.entity.Author;
import com.publictions.demo.entity.Publications;
@Component
public class CSVHelper {
	

	public static String Type = "text/csv";
	
	
	static String[] HEADERs = {"description","firstName","isbn"," issueDate","lastName","title","type","email"};
	
	// check if file is csv file 
	public static boolean hasCSVFormat(MultipartFile file) {
		
		if (!Type.equals(file.getContentType())) {
			return false;
		}
		
		return true;
	}
	
	
		public static List<Author> csvAuthors(InputStream is){
			
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			
			CSVParser csvParser = new CSVParser(fileReader, 
			
			CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
		
			List<Author> Authors = new ArrayList<Author>();
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
		
			for(CSVRecord csvRecord : csvRecords) {
				try {
					Author temAuthor = new Author(csvRecord.get("firstName"), 
					csvRecord.get("lastName"),csvRecord.get(0));
			
					Authors.add(temAuthor);
					
				} catch (ArrayIndexOutOfBoundsException| IllegalArgumentException |NullPointerException  e) {
					System.out.println("Info imported has Faild row # "+csvRecord.getRecordNumber()+". Exception " + e);
				}
				

			}
		
			return Authors;
		
		} catch (IOException e) {
			
			throw new RuntimeException("fail to parse CSV File" + e.getMessage());
		}
	}
	
	public static List<Publications> csvPubliction(InputStream is){
		
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			CSVParser csvParser = new CSVParser(fileReader, 
			
			CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
		
			List<Publications> publictions = new ArrayList<Publications>();
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
		
			
			for(CSVRecord csvRecord : csvRecords) {
				
				try {
					
				Publications temPublications = new Publications(
					csvRecord.get(3), 
					csvRecord.get(4),
					csvRecord.get(5));
		
				publictions.add(temPublications);
				} catch (ArrayIndexOutOfBoundsException |IllegalArgumentException|NullPointerException e) {
					System.out.println("Info imported hat faild # "+csvRecord.getRecordNumber()+". Exception"+e);
				}


			}
		
			return publictions;
		
		} catch (IOException e) {
			
			throw new RuntimeException("fail to parse CSV File" + e.getMessage());
		}
	}
	

	
	
	
}
