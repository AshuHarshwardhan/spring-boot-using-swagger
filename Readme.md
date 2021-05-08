**Steps to launch application in your local environment:**
1. Checkout code to your local.
2. Import project as gradle project.
3. Wait for some time to download dependencies presnt in build.gradle file.
4. Run DemoApplication.java as java application. This will run application at default port 8080

In this project, I have used in memory h2 database which can be replaced with MS SQL or any other relational database. I have used JPARepository to connect java to database.

URL to access in memory h2 database for this project:  **http://localhost:8080/h2-ui/**

Please update JDBC URL to **jdbc:h2:mem:testdb** and click **"Connect"** to login and access database. After login, you can query database to see your cerated users.

**Default Swagger API documentation** can be accessed at **http://localhost:8080/v2/api-docs**

**Default Swagger API human readable structured documentation** can be accessed at **http://localhost:8080/swagger-ui.html**
