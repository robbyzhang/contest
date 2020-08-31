## Integer to Roman
Roman numerals are represented by seven different symbols: <i>I, V, X, L, C, D and M.</i>

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, two is written as <i>II</i> in Roman numeral, just two one's added together. Twelve is written as, <i>XII</i>, which is simply <i>X + II</i>. The number twenty seven is written as <i>XXVII</i>, which is <i>XX + V + II</i>.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <i>IIII</i>. Instead, the number four is written as <i>IV</i>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as <i>IX</i>. There are six instances where subtraction is used:

- Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not <i>IIII</i>. Instead, the number four is written as <i>IV</i>. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as <i>IX</i>. There are six instances where subtraction is used:
- <i>X</i> can be placed before <i>L</i> (50) and <i>C</i> (100) to make 40 and 90. 
- <i>C</i> can be placed before <i>D</i> (500) and <i>M</i> (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
#### Example 1:
```
Input: 3
Output: "III"
```

#### Example 2:
```
Input: 4
Output: "IV"
```

#### Example 3:
```
Input: 9
Output: "IX"
```

#### Example 4:
```
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
```

#### Example 5:
```
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```
