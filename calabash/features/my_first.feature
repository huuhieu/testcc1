Feature: Login feature
  As an android developer
  I want to have a sample feature file
  So I can begin testing quickly
  
  Scenario: I can start my app and take main screen's picture
  
  Given I see "Welcom to Team Six Project"
  When I see "Sort Algorithms"
  Then I wait for "What is the algorithm that you want to work with" to appear
  And take picture
  
  Scenario: Test random number array
  
  Given I press the "Counting Sort" button
  When I see "Counting Sort is chosen"
  Then I enter "10" into input field number 1
  And I press the "OK" button
  Then I press the "New" button
  Then I press the "New" button
 
  Scenario: Test Tim Sort feature
  
  Given I press the "Timsort" button
  When I see "Timsort is chosen"
  Then I enter "5" into input field number 1
  And I press the "OK" button
  And I press the "Next" button
  Then I see "Timsort with steps"
  Then I press the "Reset" button
  
  Scenario: Test Merge Sort feature
  
  Given I press the "Merge Sort" button
  When I see "Merge Sort is chosen"
  Then I enter "10" into input field number 1
  And I press the "OK" button
  And I press the "Next" button
  Then I see "Merge Sort with steps"
  Then I scroll down
  And I wait to see "Reset"
  And I press the "Reset" button