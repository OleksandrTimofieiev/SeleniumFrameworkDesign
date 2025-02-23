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
├── .gitignore                  # Specifies files and directories ignored by Git
├── pom.xml                     # Maven configuration file
├── README.md                   # Project documentation
└── src/
    └── test/
        └── java/
            ├── dataAndComponents/      # Contains test data, reports, and test classes
            │   ├── data/               # Test data files (e.g., JSON, Excel, CSV) and data reader
            │   ├── reports/            # Test execution reports
            │   ├── tests/             # Test classes (e.g., end-to-end tests)
            │   │   ├── AbstractComponent.java # Base class for reusable UI components
            │   │   ├── ErrorValidation.java # Tests for validating error scenarios
            │   │   ├── CheckOutPage.java # Page class for the check out page
            │   │   ├── LandingPage.java # Page class for the landing page
            │   │   ├── OrderPage.java # Page class for the order page
            │   │   ├── ProductCatalogue.java # Page class for the product catalogue
            │   │   └── StandAloneTest.java # Standalone test class for running individual tests
            ├── resources/         # Resources for test execution
            ├── screenshots/       # Screenshots captured during test execution
            └── testComponents/    # Core framework components (test setup, listeners, etc.)
```

## Reporting

* The framework generates detailed test execution reports using ExtentReports. 
* After running the tests, you can find the reports in the ```reports/``` package.

## Acknowledgments
* Selenium for providing the automation framework.
* TestNG for test execution and parallel testing.
* ExtentReports for reporting.






