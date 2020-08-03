# URL Shortener

In this challenge you will build a URL shortener in Java.
The goal is to build an in-memory look-up: every alias -> URL mapping should be stored in-memory. 
The alias generated will depend on the url received:
- Any url containing “google”:
  - alias will have 5 characters length
  - alias will use only alpha characters
- Any url containing “yahoo”
  - alias will have 7 characters length
  - alias will use alphanumeric characters
- Any other url
  - alias will be based on the url itself by removing every special characters, vowels and numbers from it.

## Endpoints

Your API will need to respond to two endpoints: one for creation, other for retrieving.

### Creation (POST) 

- The creation should use the `POST` verb and use a payload like:```{"url":"https://nearsoft.com"}``` 
- Return the proper status code and alias.

### Retrieval (GET/alias)

- Retrieval should respond to a `GET` request to /<alias> 
- Redirect to the given URL.

Your application should handle duplicate entries
2 equal URLs should have the same alias, but such alias can be different if server is restarted.

### Example
- **POST**: “url”:”www.google.maps.com” returns “alias”:”BdfGT”
- **GET**: “http:localhost/BdfGT” redirect to “www.google.maps.com"

## Execution

1. Clone or download the source code.
2. Install Maven, you can check if you have maven by executing the following command:
```bash
mvn -version
```
3. Open a terminal and execute the following command:
```bash
mvn spring-boot:run
```
4. If it's the first time you run the program it may take a few minutes to start, since the dependencies have to be downloaded.
5. The program will be available at http://localhost:8080.