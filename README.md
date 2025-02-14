
# REST Assured API Testing Framework
This project is an API testing framework built using REST Assured and TestNG.

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6.3 or higher

## Project Structure
```bash
src
├── test
│ ├── java
│ │ └── endpoints/ # Endpoints classes
│ │ └── pages/ # Page classes
│ │ └── payload/ # Payload classes
│ │ └── test/ # Test classes
│ │ └── utils/ # Utility classes
│ ├── pom.xml # Maven project file
│ └── testng.xml # TestNG configuration file
```

## Dependencies
The framework uses the following main dependencies:
- REST Assured
- TestNG
- Jackson (JSON parsing)
- Lombok
- Log4j2

## Getting Started
1. Clone the repository:
```bash
git clone https://github.com/sarvesh371/java-restassured-testng.git
cd java-restassured-testng
```
2. Install dependencies:
```bash
mvn clean install
```
3. Run the tests:
```bash
mvn test
```

## Configuration
- Test suites are defined in `testng.xml`

## Best Practices
1. Follow page object model
2. Maintain test data separately
3. Use appropriate assertions
4. Add meaningful test descriptions
5. Follow proper naming conventions

## Contributing
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details