package String;

/**
 * Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.

 * @author heguangliu
 *
 */
public class ValidNumber{
	public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
}