Feature: Search Any Vegetable and Place Order
 
Scenario: Search Any Vegetable in both home and offers page
Given User is on Greencart Landing Page
When User searches with short name "Tom" and extract actual name of product
Then User searches same short name "Tom" in offers page and checks product exists

