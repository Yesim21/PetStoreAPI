@petStore @deletePet
Feature: Delete an existing pet

  Scenario: Deleting a pet after adding a pet to store
    Given I have pet information to be added
    When I send a post request to add pet to the store
    When I send a delete request to delete an existing pet
    Then I see pet is deleted successfully
