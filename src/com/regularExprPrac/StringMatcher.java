package com.regularExprPrac;

public class StringMatcher {

	// returns true if the string matches exactly "true"
    public boolean isTrue(String s){
            return s.matches("true");
    }
    // returns true if the string matches exactly "true" or "True"
    public boolean isTrueVersion2(String s){
            return s.matches("[tT]rue");
    }

    // returns true if the string matches exactly "true" or "True"
    // or "yes" or "Yes"
    public boolean isTrueOrYes(String s){
            return s.matches("[tT]rue|[yY]es");
    }

    // returns true if the string contains exactly "true"
    public boolean containsTrue(String s){
            return s.matches(".*true.*");
    }


    // returns true if the string contains of three letters
    public boolean isThreeLetters(String s){
            return s.matches("[a-zA-Z]{3}");
            // simpler from for
//            return s.matches("[a-Z][a-Z][a-Z]");
    }



    // returns true if the string does not have a number at the beginning
    public boolean isNoNumberAtBeginning(String s){
    	return s.matches("^[^0-9].*");
    	//            return s.matches("^[^\\d].*");
    }
    // returns true if the string contains a arbitrary number of characters except b
    public boolean isIntersection(String s){
            return s.matches("([\\w&&[^b]])*");
    }
    // returns true if the string contains a number less than 300
    public boolean isLessThanThreeHundred(String s){
    	return s.matches("[^\\d]*[12]?[\\d]{1,2}[^\\d]*");
    	//            return s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");
    }

    public static boolean isEmailAddress(String s) {
        return s.matches("^[\\w$]+@\\w+\\.\\w{2,6}$");
    }

    public static void main(String[] args) {
        System.out.println(StringMatcher.isEmailAddress("sd%fsa_asd23@ad.asdfa"));
        System.out.println(StringMatcher.isEmailAddress("$sdfsa_asd23@126.asdfa"));
        System.out.println(StringMatcher.isEmailAddress("23sdfsa_asd23@ad.asdfasdfa"));
        System.out.println(StringMatcher.isEmailAddress("23sdfsa_asd23@ad.cn"));
        System.out.println(StringMatcher.isEmailAddress("23sdfsa_asd23@a*d.cn"));
    }
}
