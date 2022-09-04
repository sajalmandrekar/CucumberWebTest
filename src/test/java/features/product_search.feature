Feature: Product searching in GreenKart

@HomePage @OfferPage
Scenario Outline: Search product in home and offer page
Given user is on landing page
When user searches short name <Name> in home page and extracts it
Then user searches <Name> on offer page and extracts it
And checks if extracted strings match

Examples:
|Name|
|tom|
|beet|