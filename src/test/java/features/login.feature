Feature: Login into Applicaton

Scenario Outline: Postitve test validating login
Given Initialize the browse with chrome
Given Navigate to "https://courses.rahulshettyacademy.com" Site
Given Click on Login link in home page to land on secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successful logged in
And Close browsers

Examples: 
|username						|password	|
|test99@gmail.com		|123456		|
#|test9@gmail.com		|12345		|


Scenario: Popup test validation
Given Initialize the browse with chrome
Given Navigate to "http://www.qaclickacademy.com" Site
Given Click on popup link in home page
And Close browsers