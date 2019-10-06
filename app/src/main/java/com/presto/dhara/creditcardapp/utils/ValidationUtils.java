package com.presto.dhara.creditcardapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

//    /**
//     * validate for incorrect credit card number digits
//     * @link https://www.cybersource.com/developers/getting_started/test_and_manage/best_practices/card
//     * _type_id/
//     * also validate it passes the Luhn validation
//     * supports only American Express, Visa, Mastercard, and Discover
//     * @param cardNumber credit card number
//     * @return boolean
//     */
//    public static boolean validateCardNumber(long cardNumber) {
//        return ((getCardLength(cardNumber) >= 15 && getCardLength(cardNumber) <= 19) &&
//                passesLuhnValidation(cardNumber) &&
//                (checkValidCardType(cardNumber, AppConstants.AMERICAN_EXPRESS_PREFIX) ||
//                checkValidCardType(cardNumber, AppConstants.VISA_PREFIX) ||
//                checkValidCardType(cardNumber, AppConstants.MASTERCARD_PREFIX) ||
//                checkValidCardType(cardNumber, AppConstants.DISCOVER_PREFIX)));
//    }
//
//    /**
//     * function to get the card number length
//     * @param cardNumber credit card number
//     * @return length of the card number
//     */
//    private static int getCardLength(long cardNumber) {
//        String num = cardNumber + "";
//        return num.length();
//    }
//
//    /**
//     * function to test whether the credit card number passes the Luhn Algorithm Validation
//     * @param cardNumber credit card number
//     * @return true if the card number passes the Luhn validation
//     */
//    private static boolean passesLuhnValidation(long cardNumber) {
//        int sum = 0;
//        boolean alternate = false;
//        String strCardNumber = String.valueOf(cardNumber);
//        for (int i = strCardNumber.length() - 1; i >= 0; i--) {
//            int n = Integer.parseInt(strCardNumber.substring(i, i + 1));
//            if (alternate) {
//                n *= 2;
//                if (n > 9) {
//                    n = (n % 10) + 1;
//                }
//            }
//            sum += n;
//            alternate = !alternate;
//        }
//        return (sum % 10 == 0);
//    }
//
//    /**
//     * function to validate card type
//     * @param cardNumber credit card number
//     * @param prefix prefix for a particular card type
//     * @return true if card number matches the prefix
//     */
//    private static boolean checkValidCardType(long cardNumber, int prefix) {
//        long temp = 0L;
//        if (getCardLength(cardNumber) > prefix) {
//            String num = cardNumber + "";
//            temp = Long.parseLong(num.substring(0, prefix));
//        }
//        return temp == prefix;
//    }
//
//    /**
//     * validate expiration date to have correct format (MM YY)
//     * @param expirationDate credit card expiration date
//     * @return boolean
//     */
//    public static boolean validateExpirationDate(String expirationDate) {
//        String regex = "^(0[1-9]|1[0-2])\\s([2-9][0-9])|(1[0-1] 19)$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(expirationDate);
//        return matcher.matches();
//    }
//
//    /**
//     * validate cvv for incorrect number of digits
//     * @link https://www.cvvnumber.com/cvv.html
//     * @param cardNumber credit card number
//     * @param cvvNumber credit card cvv number
//     * @return boolean
//     */
//    public static boolean validateCvvNumber(long cardNumber, String cvvNumber) {
//        String regex;
//        if (checkValidCardType(cardNumber, AppConstants.AMERICAN_EXPRESS_PREFIX)) {
//            regex = "^[0-9]{4}$";
//        } else {
//            regex = "^[0-9]{3}$";
//        }
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(cvvNumber);
//        return matcher.matches();
//    }
//
//    /**
//     * validate last name to contain only correct characters that is alphabets and spaces
//     * @param firstName first name associated with credit card number
//     * @return boolean
//     */
//    public static boolean validateFirstName(String firstName) {
//        String regex = "[\\p{L}\\s]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(firstName);
//        return matcher.matches();
//    }
//
//    /**
//     * validate last name to contain only correct characters that is alphabets and spaces
//     * @param lastName last name associated with credit card number
//     * @return boolean
//     */
//    public static boolean validateLastName(String lastName) {
//        String regex = "[\\p{L}\\s]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(lastName);
//        return matcher.matches();
//    }

}
