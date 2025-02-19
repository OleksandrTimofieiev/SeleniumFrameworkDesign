# Selenium Framework Design

## Overview
This repository contains a Selenium-based test automation framework designed to streamline the process of writing, maintaining, and executing automated tests for web applications. 
The framework is built with scalability, maintainability, and reusability in mind.

## Features
* Modular Design: The framework is designed with a modular structure, making it easy to extend and maintain.

* Cross-Browser Testing: Supports testing across multiple browsers (e.g., Chrome, Firefox, Edge).

* Data-Driven Testing: Utilizes external data sources (e.g., Excel, JSON) for test data management.

* Reporting: Integrated with reporting tools (e.g., ExtentReports) to generate detailed test execution reports.

* Parallel Execution: Supports parallel test execution using TestNG or other test runners.

* Page Object Model (POM): Follows the Page Object Model design pattern for better maintainability.

* CI/CD Integration: Ready to integrate with CI/CD tools like Jenkins, GitHub Actions, or GitLab CI.

## Prerequisites
* Before using this framework, ensure you have the following installed:
* Java JDK (version 8 or higher).
* Maven (for dependency management).
* Browser drivers (e.g., ChromeDriver, GeckoDriver).
* IDE (e.g., IntelliJ IDEA, Eclipse).

## Installation
* Clone the repository:
```git clone https://github.com/OleksandrTimofieiev/SeleniumFrameworkDesign.git```

* Navigate to the project directory:
```cd SeleniumFrameworkDesign```

* Install dependencies using Maven:
```sh
mvn clean install
```

## Usage
### Running Tests:
* To run all tests:
```sh
mvn test
```

* To run specific test suites:
```sh
mvn test -DsuiteXmlFile=testng.xml
```

### Adding New Tests:
* Create new test classes in the ```src/test/java``` directory.
* Follow the Page Object Model (POM) design pattern for maintainability.

## Project Structure
SeleniumFrameworkDesign
```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/          # Page classes following POM
│   │   │   ├── utils/          # Utility classes (e.g., helpers, config readers)
│   │   │   └── base/           # Base classes (e.g., BaseTest, WebDriver setup)
│   │   └── resources/          # Configuration files (e.g., config.properties)
│   └── test/
│       ├── java/
│       │   └── tests/          # Test classes
│       └── resources/          # Test data (e.g., Excel, JSON files)
├── test-output/                # Test reports and logs
├── pom.xml                     # Maven configuration
└── README.md                   # Project documentation
```

## Reporting

* The framework generates detailed test execution reports using ExtentReports. 
* After running the tests, you can find the reports in the ```test-output/``` directory.

## Acknowledgments
* Selenium for providing the automation framework.
* TestNG for test execution and parallel testing.
* ExtentReports for reporting.






