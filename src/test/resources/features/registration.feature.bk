Feature: Registration

  Scenario Outline: Successful registration
    Given Pepito wants to sign up in the application
    When Pepito sends the required information to sign up
      | <name> | <last name> | <age> | <email> |<country>|
    Then Pepito should have a new account created
    Examples:
      | name   | last name | email                    | age | country  |
      | Pepe   | Gomez     | pepegomez@email.com      | 22  | Colombia |
      | Julian | Gonzales  | juliangonzales@email.com | 23  | Colombia |

  Scenario: Missing required fields for registration
    Given Pepito wants to sign up in the application
    When Pepito does not send the required information
    Then Pepito should be told all fields are required

