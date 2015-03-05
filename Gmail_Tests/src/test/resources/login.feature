Feature: Login

@Login
Scenario:User logs into the gmail account using valid username and password
Given I am in the gmail account page
When I enter the valid username as "rtestuserlogin"
And I enter the valid password as "rtestuser"
And I click on the Sign in button
Then I should be able to login to my gmail account

@Logout
Scenario: User logs out of the gmail account
Given I am logged into my gmail account
When I click on the sign out button
Then I should be able to log out of my account
