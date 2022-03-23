Feature: Student SignUp


  Scenario: Student creates account successfully
  Given student is on the login page
  When student clicks 'Sign up' button
  And selects Student
  And clicks 'Signup With Breakout EDU'
  And types class code and clicks 'Next'
  And fills up User Info form and clicks 'Next'
  And creates a password and clicks 'Next'
  Then verifies account was created


    Scenario: Student tries to create account with invlid username
      Given student is on the login page
      When student clicks 'Sign up' button
      And selects Student
      And clicks 'Signup With Breakout EDU'
      And types class code and clicks 'Next'
      And he provides invalid username
      Then verifies "Username must be between 6 and 10 characters." message is displayed


      Scenario: Student tries to create an account with not match password
      Given student is on the login page
      When student clicks 'Sign up' button
      And selects Student
      And clicks 'Signup With Breakout EDU'
      And types class code and clicks 'Next'
      And provides not matched password
      Then verifies "Password are not matched" alert is displayed