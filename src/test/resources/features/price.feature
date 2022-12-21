@Price @smoke
Feature: PriceCheck

  Scenario: User should be able to see courses if status is publish
    Given User goes to "crmEnv" for crm
    And user enters "emailForCRM" in emailBox
    And User enters "passwordForCRM" in passwordBox
    And user clicks login button
    And user hoverOver campaigns
    And user clicks campaigns at crm
    And user clicks courses at crm
    And user clicks loadMore until it is unClickable
    And user clicks random one course at crm lists courses price
  # for checking each course checked all courses at leo
    And user goes to "leoEnv" for leo
    And user clicks courses at leo
    And user scrolls down
    And user clicks leo course which it is same random course at crm
    #And user clicks live virtual
    #And user clicks date
    #And user clicks add to chart button
    #And user lists price
    #And user clicks close button
    #And user clicks faceToFace
    #And user clicks date for FaceToFace
    #And user clicks add to chart button
    #And user lists price for faceToFace
   #And user clicks close button
    Then user checks prices in leo with crm
