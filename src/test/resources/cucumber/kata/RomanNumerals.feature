Feature: In order to reduce confusion with Roman Numerals
  As A reader of roman numerals
  I want to translate the numbers to Arabic numbers

Scenario translate simple numbers
  Given a Roman Numeral
  When I ask for a translation
  Then I get the correct Arabic number

Scenario Outline: translate common number combinations
    When I ask for a translation of a combination "<Complex Roman Numeral>"
    Then I get the correct combination translation "<Arabic Number>"
