@TF_LoginFeature @Regression
Feature: TechFios Login Functionality Validation
Background:
Given User is on Techfios login page

@Otherlogin1
Scenario Outline: User should be able to login with valid credentials 
When User enters username as "demo@techfios.com"
When User enters password as "abc123" 
When User clicks signin button
Then User should land on dashboard page 
 
  Examples:
  |username          |password|
  |demo@techfios.com |abc123  |
  |demo@techfios.com |abc123  |
  |demo@techfios.com |abc123  |