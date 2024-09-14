@tag
Feature: Error validation

  @tag2
  Scenario Outline: Title
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      |name                    |password    |
      |test1000332@gmail.com   |M267280     |