@sessionsAmount
Feature: sessionAmountChecks

  Scenario: User should be able to see courses if status is publish
    Given User goes to "crmEnv" for crm
    And user enters "emailForCRM" in emailBox
    And User enters "passwordForCRM" in passwordBox
    And user clicks login button
    And user hoverOver campaigns
    And user clicks campaigns at crm
    And user clicks courses at crm
    And user clicks loadMore until it is unClickable
    Then User lists all campaigns sessions amount at crm
  # for checking each course checked all courses at leo
    And user goes to "leoEnv" for leo
    And user clicks courses at leo
    And user scrolls down
    And user lists all courses sessions amount at leo

    Then user checks courses sessions amount at CRM with all courses sessions amount at loe