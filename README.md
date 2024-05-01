# User-Management
User Management API
This project is a RESTful API for managing users, developed as a test assignment for a Java developer position.

Functionality
The User Management API provides the following functionality:

Create a new user
Update an existing user
Delete a user by email
Fetch a list of users based on their birth date range
Technologies Used
Java
Spring Boot
Spring Data JPA
Hibernate
H2 Database
Swagger
Installation and Usage
To run this project locally, follow these steps:

Clone the repository.
Configure the H2 database settings in the application.properties file.
Build and run the project using Maven or your preferred IDE.
Access the Swagger UI at http://localhost:8080/swagger-ui/index.html.
Examples
Here are some examples of how to use the API:

Create a User: Send a POST request to /api/create with a JSON payload containing user data.
Update a User: Send a PUT request to /api/update with a JSON payload containing updated user data.
Delete a User: Send a DELETE request to /api/delete with the email of the user to be deleted as a query parameter.
Fetch Users by Birth Date Range: Send a GET request to /api/users/search with fromDate and toDate parameters specifying the date range.
Contributors
This project was developed by [Roman Svyshch] .

Contact
For questions or feedback, please contact [svychroman@gmail.com].


Additional Information
For more details, refer to the API Documentation.