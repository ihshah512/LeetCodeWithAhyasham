package LinkedList;
import java.util.HashMap;

public class FindEvenValues {

    public static boolean isAnagram(String one, String two){

        if(one.length() != two.length()){
            return false;
        }

        HashMap<Character, Integer> strOneMap = new HashMap<>();
        HashMap<Character, Integer> strTwoMap = new HashMap<>();
        for(int i = 0; i < one.length(); i++) {
            char c = one.charAt(i);
            if (strOneMap.containsKey(c)) {
                strOneMap.put(c, strOneMap.get(c) + 1);
            } else {
                strOneMap.put(c, 1);
            }
        }
            for (int j = 0; j < one.length(); j++) {
                char d = two.charAt(j);
                if (strTwoMap.containsKey(d)) {
                    strTwoMap.put(d, strTwoMap.get(d) + 1);
                } else {
                    strTwoMap.put(d, 1);
                }
            }
               /* if (strTwoMap.size() != strOneMap.size()) {
                    return false;
                }
*/
                for (Character key : strOneMap.keySet()) {
                    if (!strTwoMap.containsKey(key)) {
                        return false;
                    }
                    if (!strOneMap.get(key).equals(strTwoMap.get(key))) {
                        return false;
                    }

                }


                return true;
            }

            public static void main (String[] args){
        String s = "anagrm";
        String t = "mnagra";

        System.out.print(isAnagram(s,t));

            }

        }
/*
An Anagram is a word or phrase formed by rearranging the letters of
a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false



 */
