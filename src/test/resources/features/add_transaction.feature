Feature: Add transaction

  Scenario: Add new transaction
    Given Pepito is logged into the application
      | user | pass |
    When  Pepito enters the required information for the new transaction
      | 12-12-2024 | 200 | transaction testing |
    Then Pepito should see a new transaction in the transaction list with correct details
      | transaction testing | 200 |
