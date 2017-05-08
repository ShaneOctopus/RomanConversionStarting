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
  | X          | 10 |
  | L             | 50 |
  | C             | 100 |
  | D             | 500 |
  | M             | 1,000|
  | B             | Invalid Digit |
  | #             | Invalid Digit |
  | 2             | Invalid Digit |

Scenario translate common subtraction number combinations
  Given a Roman Number simple combination
  When I ask for a translation
  Then I get the correct simple subtraction combination translation in Arabic numbers:
| Roman Numeral | Arabic Number |
| IV             | 4 |
| IX             | 9 |
| XC         | 90 |
| XL             | 40 |
| CD             | 400 |
| CM             | 900 |


Scenario flag malformed numbers
  Given valid digits in the wrong order
  When I ask for a translation
  Then I get the following errors:
  | Error Input | Error Response |
  | VC          | Invalid Number - Only subtract powers of ten (I, X, or C, but not V or L)|
  | LD          | Invalid Number - Only subtract powers of ten (I, X, or C, but not V or L)|
  | IIXV        | Invalid Number - Only subtract one number from another |
  | IC          | Invalid Number - Do not subtract a number from one that is more than 10 times greater |
  | XD          | Invalid Number - Do not subtract a number from one that is more than 10 times greater |
  | CM          | Invalid Number - Do not subtract a number from one that is more than 10 times greater |
  | XM          | Invalid Number - Do not subtract a number from one that is more than 10 times greater |