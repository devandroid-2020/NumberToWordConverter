# Number To Word Converter

This application is convert numbers to english word.<br>
 Example : `100` in english `One hundred` or `224` in english `Two hundred twenty four`

The application supports numbers up-to 6 digits, i.e., numbers from 0 to 999999.

Idea is to create arrays that store individual parts of output strings.
One array is used for single digits, one for numbers from 10 to 19, one for 20, 30, 40, 50, .. etc, and one for powers of 10.

The given number is divided in two parts: first two digits and last two digits, and the two parts are printed separately.
