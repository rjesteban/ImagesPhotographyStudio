/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.Date;

/**
 *
 * @author El Gato
 */
public class InputMatcher {
    
    public static boolean timeIsRealistic(Date before, Date after){
        return before.before(after);
    }
    
    public static boolean isEmail(String _email){
        return _email.contains("@") && !_email.contains(" ");
    }
    
    public static boolean isContactNumber(String _cNumber){
        if(_cNumber.length()<7 && !_cNumber.contains(" "))
            return true;
        else{
            for(int i = 0 ; i< _cNumber.length() ; i++ ){
                if(!(_cNumber.charAt(i)>='0' && _cNumber.charAt(i)<='9'))
                    return true;
            }
            return false;
    
        }
    }
    
    /*
    public static void main(String[] args) {
        System.out.println(InputMatcher.timeIsRealistic(new Date(2015,3,4,2,4), new Date(2015,3,4,4,5)));
        System.out.println(InputMatcher.isEmail("asdklsj@yahoo.com"));
        System.out.println(InputMatcher.isContactNumber("aasdasdas342"));
        System.out.println(InputMatcher.isContactNumber("4131377"));
    }
    */
    
}
