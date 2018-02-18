/*
Problem Statement
You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

The string has exactly N characters, each of which is either 'A' or 'B'.
The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.

Definition
Class: AB
Method: createString
Parameters: int, int
Returns: String
Method signature: String createString(int N, int K)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- N will be between 2 and 50, inclusive.
- K will be between 0 and N(N-1)/2, inclusive.
Examples
0)
3
2
Returns: "ABB"
This string has exactly two pairs (i, j) mentioned in the statement: (0, 1) and (0, 2).
1)
2
0
Returns: "BA"
Please note that there are valid test cases with K = 0.
2)
5
8
Returns: ""
Five characters is too short for this value of K.
3)
10
12
Returns: "BAABBABAAB"
Please note that this is an example of a solution; other valid solutions will also be accepted.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/

/* I answer the above question
Author: Robert P Mulligan
Created: 2/17/2018
TopCoder Points: 88.22
*/

public class AB {
 
    public static String createString(int N, int K){
        
        String ans = ""; /* string to return */

        /* create a string of all 'B's */
	    for(int i = 0; i < N; i++) {
            ans += "B";
            }
        
        int pairs = 0; /* keep track of the pairs. Add them as we add 'A's */
        
        for(int i = 1; pairs < K; i++) {
        	if(i+1 == N) {return "";} /* if we reach the end, then no pairs */
            
            if( (pairs + (N - i - 1)) <= K) { 
                ans = ans.substring(0, i-1) + 'A' + ans.substring(i);
                /* when an 'A' is added, a pair will delete if it's not the first char */
                if(pairs > 0 ) {pairs += (N - i) - 1;}
                else {pairs += (N - i); }
            	} 

           }
        /* if we equal the pairs, then return -- if not, it wasn't possible */
        if(pairs == K) {
        return ans;
            } else {
            return ""; 
            }
    }
public static void main(String[] args) {

    System.out.println(createString(3, 2));
     System.out.println(createString(2, 0));
     System.out.println(createString(5, 8));
     System.out.println(createString(10, 12));
}
    
}

