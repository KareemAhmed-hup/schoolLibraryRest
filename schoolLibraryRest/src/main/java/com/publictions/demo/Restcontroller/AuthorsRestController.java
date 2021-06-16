package com.publictions.demo.Restcontroller;

import java.util.List;

import com.publictions.demo.entity.Author;
import com.publictions.demo.services.AuthorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorsRestController {

    @Autowired
    private  AuthorServiceImpl authorservice;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        try {
            // create a new list to pass the Author from service 
            List<Author> authors = authorservice.getAuthors();
            // check if the list is empaty 
            if (authors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // return the list of Authors 
                return new ResponseEntity<>(authors,HttpStatus.OK);
            // or throw exception
        } catch (Exception e) { 
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId){
       
       String message="";
 
            // creat a new object to get the author from service 
            Author tempAuthor = authorservice.getAuthor(authorId);
            message = "not found " + authorId;
            // create if to chek the object is not null 
            if (tempAuthor == null ) {
                
               throw new RuntimeException(message); 
            }
            return tempAuthor;
    }

     // get maping for add the author to Publication 
     @GetMapping("/authors/{authorId}/publications/{pubId}")
     public ResponseEntity<Author> addAuthorToPublication(@PathVariable int authorId,
                                                          @PathVariable int pubId){
         try {
             
            Author tempAuthor = authorservice.addPublictionToAuthor(pubId, authorId);
 
             if (tempAuthor != null)
             {
                 return new  ResponseEntity<>(tempAuthor,HttpStatus.OK);
             }
             return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
 
         } catch (Exception e) {
             return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
         }
 
     }


     // get mappin to return All Authors by Email
     @GetMapping("/authors/email/{email}")
     public List<Author> getAllByEmail(@PathVariable String email){
        return authorservice.findAllByEmail(email);
     }

}


