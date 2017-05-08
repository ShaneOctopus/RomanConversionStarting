Feature: In order to reduce confusion with Roman Numerals
  As A reader of roman numerals
  I want to translate the numbers to Arabic numbers

Scenario translate simple numbers
  Given a Roman Numeral
  When I ask for a translation
  Then I get the correct Arabic number:
  | Roman Numeral | Arabic Number |
  | I             | 1 |
  | V             | 5 |
  | X          	  | 10 |
  | L             | 50 |
  | C             | 100 |
  | D             | 500 |
  | M             | 1,000|
  | B             | Invalid Digit |
  | #             | Invalid Digit |
  | 2             | Invalid Digit |

Scenario Outline: translate common number combinations
    When I ask for a translation of a combination "<Complex Roman Numeral>"
    Then I get the correct combination translation "<Arabic Number>"
    Examples:
      | Complex Roman Numeral | Arabic Number |
      | IV             | 4 |
      | IX             | 9 |
      | XC 	       	   | 90 |
      | XL             | 40 |
      | CD             | 400 |
      | CM             | 900 |
      | MMXIII         | 2013 |
      | MMMCMXCIX      | 3999 |

Scenario Outline: flag malformed numbers
    When I ask for a translation of a "<Bad Roman Numeral>"
    Then I get the an invalid numeral error
    Examples:
      | Bad Roman Numeral |
      | VC          |
      | LD          |
      | IIXV        |
      | IC          |
      | CM          |
      | XD          |
      | XM          |

Scenario Outline: translate simple numbers to Roman
    When I ask for a Roman translation of a "<Arabic Number>"
    Then I get the correct Roman Numeral "<Roman Numeral>"
  Examples:
    | Arabic Number | Roman Numeral  |
    | 1             | I 	|
    | 5             | V 	|
    | 256           | CCLVI  	|
    | 1001          | MI 	|
    | 1993          | MVIIM  	|

Scenario Outline: flag malformed Arabic numbers
    When I ask for a Roman translation of a "<Bad Arabic Numeral>"
    Then I get the invalid arabic error
  Examples:
    | Bad Arabic Numeral  |
    | 0                   |
    | 4000                |