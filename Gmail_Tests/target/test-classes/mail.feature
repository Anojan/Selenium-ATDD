@MailBox
Feature: Inbox Functionalities

Scenario: User composes a new mail
Given I am logged into my gmail account
When I click on the Compose button
And I compose a mail
And I close the composed mail
And I navigate to drafts
Then I should be able to see tha mail in the drafts folder