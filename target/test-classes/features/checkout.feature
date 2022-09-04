Feature: Place order of product in GreenKart

@PlaceOrder
Scenario Outline: search and checkout product
Given user is on landing page
When user searches short name <Name> in home page and extracts it
And user adds "3" items of selected product to cart
Then user proceeds to checkout page and validates the <Name> of ordered item
And verify the ability to enter promo code and place order

Examples:
|Name|
|tom|