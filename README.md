# Dynamic Validator Integration in Spring Boot

## Overview
This project showcases dynamic validator integration in a Spring Boot application. It allows for the seamless addition and execution of validators annotated with `UserRegisterValidationRegistration`.

## Features
- Dynamic addition of validators for user registration validation
- Seamless execution of validation logic based on specified order
- Integration with Spring's ApplicationContext for streamlined validation process
- Extensibility for adding validators to additional endpoints

## Installation
1. Clone the repository: `git clone [<repository-url>](https://github.com/haseebasifdev/spring-boot-custom-validator.git)`
2. Navigate to the project directory: `cd dynamic-validator-spring-boot`

## Usage
1. Open the project in your preferred IDE.
2. Run the Spring Boot application.
3. Access the application on `http://localhost:8080`.
4. Send requests to the `/register` endpoint to trigger dynamic validation.

## Adding Validators to Additional Endpoints
To add validators to another endpoint:
1. Create a new annotation for the endpoint, similar to `UserRegisterValidationRegistration`.
2. Create a contract validator interface that defines the validation logic.
3. Implement validators for the new endpoint by creating classes that implement the contract validator interface and are annotated with the new annotation, similar to `UserRegisterPasswordValidator`, `UserRegisterEmailValidation`, and `UserRegisterUsernameValidation`.
4. Create a custom validator logic that fetches all validators annotated with the new annotation and integrates them into the validation process, similar to `UserRegisterRequestValidator`.

## Dependencies
- Spring Boot
- Spring MVC
- Lombok
- Maven

## Configuration
- Validator classes should implement the `IUserRegisterRequestValidation` interface and be annotated with `UserRegisterValidationRegistration`.
- Ensure proper configuration of Spring ApplicationContext for dynamic validator integration.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your proposed changes.
