Feature: In order to reduce confusion with incorrect numbers
  As A user of roman numerals
  I want to capture incorrect translation attempts

  Scenario Outline: translation error numbers
    When I ask for a translation of an invalid "<Roman Numeral>"
    Then I get the invalid numeral error
    Examples:
      | Roman Numeral |
      | B             |
      | #             |
      | 2             |

  Scenario Outline: flag malformed numbers
    When I ask for a translation of an invalid "<Bad Roman Numeral>"
    Then I get the invalid numeral error
    Examples:
      | Bad Roman Numeral |
      | VC          |
      | LD          |
      | IIXV        |
      | IC           |
      | XD          |
      | XM          |

  Scenario Outline: flag bad Arabic numbers
    When I ask for a Roman translation of a invalid "<Bad Arabic Numeral>"
    Then I get the invalid Arabic error
    Examples:
      | Bad Arabic Numeral  |
      | 0                   |
      | 4000                |
