package com.clouway.test.jmock.validator;

import com.clouway.test.jmock.sms.SMS;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/30/15
 */
public class MessageValidator {
     public boolean isValid(SMS sms){
         if(sms.getMessage().equals("") || sms.getTitle().equals("") || sms.getRecipient().equals("")){
             return false;
         }
         if(sms.getMessage().length()<1 || sms.getMessage().length()>120){
             return false;
         }
         return true;
     }
}
