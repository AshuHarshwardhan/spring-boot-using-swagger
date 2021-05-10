**Steps to launch application in your local environment:**
1. Checkout code to your local.
2. Import project as gradle project.
3. Wait for some time to download dependencies presnt in build.gradle file.
4. Run DemoApplication.java as java application. This will run application at default port 8080

In this project, I have used in memory h2 database which can be replaced with MS SQL or any other relational database. I have used JPARepository to connect java to database. As soon one starts application, it automatically creates USER table inside h2 database.

URL to access in memory h2 database for this project:  **http://localhost:8080/h2-ui/**

Please update JDBC URL to **jdbc:h2:mem:testdb** and click **"Connect"** to login and access database. After login, you can query database to see your cerated users.

Once application has been started -
1. We should to execute POST call to create new USER resource.
          Method - POST
          URL - http://localhost:8080/users
          Body - {
                    "firstName": "Bill",
                    "lastName": "Gates",
                    "userName": "Bill.Gates",
                    "age": 65,
                    "email": "bill.gates@microsoft.com",
                    "isMarried": true
                  }
                  
 2. We could execute GET call to fetch all USER resources.
          Method - GET
          URL - http://localhost:8080/users
 3. We could execute GET by passing id to fetch specific USER resource.
          Method - GET
          URL - http://localhost:8080/users/1
 4. We could execute PUT call by passing id and USER resource to update existing USER resource in our database.
          Method - PUT
          URL - http://localhost:8080/users/1
 5. We could execute DELETE call by passing id to delete specific USER resource.                 
          Method - DELETE
          URL - http://localhost:8080/users/1
          
          
In this project, I have used Springfox-swagger2 V2.9.2. Swagger UI is one of the most popular tools for generating interactive documentation from using OpenAPI document. Swagger UI generates an interactive API console for users to quickly learn about APIs and experiment with requests. Additionally, Swagger UI supports the OpenAPI spec and integrates with other Swagger tooling. With the help of this we will generate API documentation which will be informative, readable, and easy to follow.

**Default Swagger API documentation** can be accessed at **http://localhost:8080/v2/api-docs**

**Default Swagger API human readable structured documentation** can be accessed at **http://localhost:8080/swagger-ui.html**
