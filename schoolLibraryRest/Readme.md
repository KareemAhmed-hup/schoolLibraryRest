The Rest API for All Publications is now ready to use
firstly, you must upload the data using the rest API 
http://localhost:8080/api/csv/upload with Post method.
And for test the data is ready to your database please call the Rest API http://localhost:8080/api/authors to Get All Author 
after that, you need to check if the Publications is added with Rest API 
http://localhost:8080/api/publications also you can get all publications by ISBN using the Rest API and add your ISBN 
http://localhost:8080/api/publications/isbn-number
Ex:http://localhost:8080/api/publications/778-1-56619-909-4
also, to get the Publication by Email we need to add the publications to the author using the rest API
http://localhost:8080/api/authors/{authorId}/publications/{publicId}
ex:
http://localhost:8080/api/authors/4/publications/2 
after that, you Cann easily get the publication by email from   
http://localhost:8080/api/authors/email/{your email}
Ex:http://localhost:8080/api/authors/email/rory@scope.com 