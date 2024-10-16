Feature: Search and Place thr order for Products

@OffersPage
Scenario Outline: Search Experience for Product search in both home and Offers page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> shorname in offers page
And validate product name in Offers page matches with Landing Page

Examples:
| Name |
| Tom  |
| Beet |