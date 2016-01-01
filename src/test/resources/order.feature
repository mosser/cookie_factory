Feature: Ordering Cookies, Cookies on Demand by The Cookie Factory

  Cookie on Demand (CoD) is an innovative system allowing TCF's customers to order customized
  cookies one the web and pick them up warm from the oven in a given bakery.

  This feature is dedicated to the ordering of cookies.

  Background: This context is true for all the upcoming scenarios
    Given a customer named Carter who want to buy a cookie
    Then  Carter is considered as a regular customer in CoD

  Scenario: "As a customer, I want to consult the product catalogue so that I can list the pre-made recipes"
    Then the list of the 3 pre-made recipes is available

  Scenario: "As Carter, I want to select an item to order so that I can order it"
    When Carter selects to buy 4 pieces of CHOCOLALALA
    Then Carter's order contains this very item: 4xCHOCOLALALA
    And  Carter's order contains 1 item

  Scenario: "As Carter, I want to select multiple items so that I can make a composite order"
    When Carter selects to buy 4 pieces of CHOCOLALALA
    And  Carter selects to buy 3 pieces of DARK_TEMPTATION
    Then Carter's order contains this very item: 4xCHOCOLALALA
    And  Carter's order contains this very item: 3xDARK_TEMPTATION
    And  Carter's order contains 2 items

  Scenario: "As Carter, I want to add cookies at anytime so that I do not have to remember the contents of my cart"
    When Carter selects to buy 3 pieces of CHOCOLALALA
    And  Carter selects to buy 8 pieces of CHOCOLALALA
    Then Carter's order contains 1 item
    And  Carter's order contains this very item: 11xCHOCOLALALA

  Scenario: "As Carter, I want to remove cookies from my cart so that I become less fat at the end"
    When Carter selects to buy 3 pieces of CHOCOLALALA
    And  Carter selects to remove 2 pieces of CHOCOLALALA
    Then Carter's order contains this very item: 1xCHOCOLALALA
    And  Carter selects to remove 1 piece of CHOCOLALALA
    Then Carter's order contains 0 item

  Scenario: "As Carter, I want to send my cart to the system so that I'll pick up my cookies at some point"
    When Carter selects to buy 3 pieces of CHOCOLALALA
    And  Carter selects to buy 2 pieces of DARK_TEMPTATION
    And  Carter sends his order to CoD
    Then Carter's order contains 0 item
    Then Carter has a voucher stored in his account
    And  Carter's voucher contains an identifier
    And  Carter's voucher contains 5 cookies