# Employee Management System

Employee Management System is used to manager record of the employee in the organization. It is used to view records of all the employees and also enable admin to add/modify/delete the records.

## Tech Stack

1. Node 12.7
2. Angular 8
3. Java 8
4. Spring Boot

## Installation

1. Fork it!
2. Goto Application folder at the desired location/folder i.e. : EmployeeAssignment

## Running

Run the below command inside the Application Folder i.e. EmployeeAssignment

```sh
docker-compose up --build
```

Angular Applicaition URL

```sh
http://localhost:4200/login
```

- Username: 
```sh
admin
```
- Password: 
```sh
password
```
![alt text](https://github.com/nitinverma14/EmployeeAssignment/images//blob/main/LoginPage.png)


## Swagger UI

Use the below URL for API details.

```sh
http://localhost:8080/swagger-ui.html
```

For API Testing, usee he following steps:
1. Use "/authenticate" API for generation of Authentication token.\
![alt text](https://github.com/nitinverma14/EmployeeAssignment/images/blob/main/GenerateToken.png)

2. Add Authenticaton code as below:
     - Click on \
    ![alt text](https://github.com/nitinverma14/EmployeeAssignment/images/blob/main/Authorize.png)

     - Add Bearer Token\
    ![alt text](https://github.com/nitinverma14/EmployeeAssignment/images/blob/main/AddBearerToken.png)

     - Run the following API to test the result\
     ![alt text](https://github.com/nitinverma14/EmployeeAssignment/images/blob/main/OtherApi.png)

## Unit Testing

Follow the following steps:
- For Angular
  - Install Visual Studio Code
  - Open the EmployeeManagement Application
  - Open Integrated Terminal
  - Run following command
  ```sh
     npm install
     ```
  ```sh
     ng test --code-coverage
     ```

- For Spring Boot
  - Install Spring Tool Suite
  - Open the employeeService-master app
  - Right click on application and Run as Junit Test


## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## Credits

Nitin Kumar Verma

