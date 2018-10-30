# Money-transfer

Run start.sh to start java application using docker.

  - docker-compose.yml - creates mysql container and java container using dockerfile
  - Dockerfile - builds the application using docker and runs wait-and-run.sh
  - scripts/wait-and-run.sh - installs MYSQL client to check status of MYSQL. If MYSQL is installed then run java app, else wait and check status of MYSQL in a few seconds.

# Features

  - Java Spring application 
  - REST API
  - MYSQL Database

I created the class named BankAccount and marked it as my entity. The class has two variables: the id of the account and the amount in the account. Marking the class as an @Entity and @Table(name = "account") shows that somewhere in the database (in this case MYSQL), there is a table called account and has two columns. The id is marked by @Id, as this is the primary key and enforcing non-nullable fields by using @NotNull. Each variable is marked by @Column, which corresponds to a column in the table. 

I created another class named BankTransferModel which contains the "skeleton" of the bank transfer. To do a bank transfer I require an account to withdraw funds, an account to deposit funds, and the amount of money to transfer. This class is used to receive data using the @ResponseBody property, using three variables toAccountId, fromAccountId and amount. 

The BankAccountController is a Controller class as set by @RestController. Here I can send and receive data from the web / curl, to and from the database by using GET/POST/PUT requests. 
    - at localhost:8080/ all bank accounts in database are shown 
    - at localhost:8080/add to add a bank account to the database
    - at localhost:8080/account/{id} to get a bank account from the database
    - at localhost:8080/transfer to transfer funds between bank accounts

Three exception classes are created: BankAccountAlreadyExistsException, BankAccountNotFoundException, TransactionException, to give more information about the exception caught at a particular point in time. 

The BankAccountRepository extends the CRUD (Create, Read, Update Delete) Repository. The repository class is useful as it already contains a lot of useful methods instead of rewriting create/read/update/delete operations. 

The BankAccountService service class contains method to manipulate that to and from the controller, by using the BankAccountRepository extended methods (such as .save()). 

Finally Application runs the Spring Boot application.

application.properties contains connection settings to connect to database. This is set to the my-sql container as created by the dockerfile.

data.sql contains some initial data to populate the database. 

--------------
During development, I ran into two very strange exceptions and dependencies were added as noted here https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j and https://stackoverflow.com/questions/52913597/springboot-org-hibernate-mappingexception-could-not-get-constructor-for-org-hi. 

In the controller class, I opted to add "/account" in localhost:8080/account/{id} as localhost:8080/transfer was giving me a number format exception. "Transfer" was being identified as an id for the get bank account method. 

I opted to structure the package in terms of layer as this is a small application. However, if the application is to be scaled, it would be better to structure the project by feature https://dzone.com/articles/project-package-organization.

Regarding HTTP requests I used a GET request to get all / one bank account, POST request to create a new bank account and PUT to update (transfer) bank accounts. I did not do any deletions, to keep with the scope of the application but this can easily be added. 

I chose to opt for MYSQL database using XAMPP and phpmyadmin interface. I did not use any security as to keep things simple. The database is not created manually, but using application.properties spring.jpa.hibernate.ddl-auto=create property to automatically create the tables in the database according to the entities in the java application. To load them in data-memory storage I opted for Spring entities as explained above. 

For Docker, first I manually created a MYSQL container, then a java container, and then link them. Then I opted to use docker-compose. The application worked when I created the containers manually but not using docker compose. Then I realised what happened: docker-compose installs both containers in parallel. When the java was installed, the java application was then run, which connects to MYSQL - but MYSQL did not finish installation. Thus, I created the wait-and-run.sh file as I explain above. The wait-and-run.sh file checks periodically if the MYSQL has finished installing, and then runs the java application. I added a different port for the database (3336) as usually 3306 would already be in use. 

# Tests

Scripts/tests.sh contains bash file with curl commands
Curl tests.docx contains tests that I run with screenshots