Feature: verify login activity

Scenario: User login

Given Open "<URL>" application 
Then Click on account link
Then Enter user name and Pass word 
Then click login option
Then successfully verify user login 
