Feature: BaseScenarios
  These scenarios can be used in any project

  Scenario: Check home page items
    # 2. Waiting for the structure until the element to be controlled comes to the next screen.
    Given User navigates to home page
    #1. Performing all element controls on application screens.
    When User verify that Painting list is displayed
    #1. Performing all element controls on application screens.
    And Check that the home page navigation bottom icons has show
    # 4. The scroll feature of the screens should be checked.
    And Do it that scroll at home page
    And Go to Others Page
    # 5. The functionality of the display elements should be checked. (Checkbox, Radio Button etc.)
    And Select to language
    #6. Click controls should be done by finding x and y coordinates according to the Attribute value
     #of the element on the screen.
    And Click Be Premium

   