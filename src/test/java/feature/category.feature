Feature: Category

  @category

# when we have a same method but different data for using automation we are using scenario outline rather than using
  # and implementation more method for performing automation look below example they have same method use for rest of
    # the different category name

#    when we are using Scenario Outline we are not able to takescreenshot on report

  Scenario Outline: As a user, I should able to navigate to category page successfully

    When I click on "<category_name>" link
    Then I should able to navigate to related "<category_link>"

    Examples:
      | category_name     | category_link     |
      | Computers         | computers         |
      | Electronics       | electronics       |
      | Apparel           | apparel           |
      | Digital downloads | digital-downloads |
      | Books             | books             |
      | Jewelry           | jewelry           |
      | Gift Cards        | gift-cards        |


