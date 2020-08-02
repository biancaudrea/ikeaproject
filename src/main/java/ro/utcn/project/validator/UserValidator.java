package ro.utcn.project.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Validate different flows related to user.
 */

public class UserValidator {

    public static String validateUserRegister() {
        /**
         * Do the validation logic.
         * Or return other object.
         * Boolean? Or String list?
         */
        return "OK";
    }
    public boolean validateUsername(String username)
    {
        if(StringUtils.isEmpty(username))
            return false;
        if( StringUtils.length(username)<4)
            return false;
        return true;
    }
    public boolean validatePassword(String password)
    {
        if(StringUtils.isEmpty(password))
            return false;
        if( StringUtils.length(password)<4)
            return false;
        return true;
    }
    public boolean validateDate(String date)
    {
        if(StringUtils.isEmpty(date))
            return false;
        if( StringUtils.length(date)<4)
            return false;
        return true;
    }
    public boolean validateUserEmail(String email)
    {
        if(StringUtils.isEmpty(email))
            return false;
        if( StringUtils.length(email)<4)
            return false;
        if(!StringUtils.contains(email,'@'))
            return false;
        return true;
    }
    public boolean validateAddress(String address)
    {
        if(StringUtils.isEmpty(address))
            return false;
        if( StringUtils.length(address)<4)
            return false;
        return true;
    }
    public boolean validateFirstName(String firstName)
    {
        if(StringUtils.isEmpty(firstName))
            return false;
        if( StringUtils.length(firstName)<3)
            return false;
        return true;
    }
    public boolean validateLastName(String lastName)
    {
        if(StringUtils.isEmpty(lastName))
            return false;
        if( StringUtils.length(lastName)<3)
            return false;
        return true;
    }

   public boolean validatePhoneNumber(String phoneNumber)
   {
       if(StringUtils.isEmpty(phoneNumber))
           return false;
       if( StringUtils.length(phoneNumber)!=10)
           return false;
       return true;
   }
    private void testSomeApacheLibs() {

        /**
         * StringUtils from org.apache.commons.lang3.StringUtils;
         * There are also some StringUtils from Spring and Java.
         * Use the ones from Apache, they are better optimised.
         *
         * The one from Apache does both null and empty check!
         */

        String name = "John";
        if (StringUtils.isNotEmpty(name)) {

        }
        if (StringUtils.isEmpty(name)) {

        }

        /**
         * CollectionUtils from Apache commons
         */
        List<String> list = new ArrayList<>();

        if (CollectionUtils.isEmpty(list)) {

        }

        if (CollectionUtils.isNotEmpty(list)) {

        }
    }
}
