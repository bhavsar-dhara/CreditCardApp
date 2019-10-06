package com.presto.dhara.creditcardapp;

import com.presto.dhara.creditcardapp.creditcard.datamodel.CreditCardForm;
import com.presto.dhara.creditcardapp.creditcard.ui.CreditCardViewModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /**
     * test for valid sixteen digit CC number = "3379513561108795"
     */
    @Test
    public void cc_details_isCorrect_1() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
        form.getDetails().setCardNumber(3379513561108795L);
        form.getDetails().setExpirationDate("12/24");
        form.getDetails().setCvvNumber(1234);
        form.getDetails().setFirstName("Test First");
        form.getDetails().setLastName("Test Last");
        assertTrue("Form is valid", form.isValid());
    }

    /**
     * test for valid AMEX CC number = "371449635398431"
     */
    @Test
    public void cc_details_isCorrect_2() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
        form.getDetails().setCardNumber(371449635398431L);
        form.getDetails().setExpirationDate("09/22");
        form.getDetails().setCvvNumber(9987);
        form.getDetails().setFirstName("First");
        form.getDetails().setLastName("Last Name");
        assertTrue("Form is valid", form.isValid());
    }

    /**
     * test for valid Discover CC number = "6011111111111117"
     */
    @Test
    public void cc_details_isCorrect_3() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
        form.getDetails().setCardNumber(6011111111111117L);
        form.getDetails().setExpirationDate("04/28");
        form.getDetails().setCvvNumber(654);
        form.getDetails().setFirstName("Sr First");
        form.getDetails().setLastName("Last");
        assertTrue("Form is valid", form.isValid());
    }

    /**
     * test for valid MasterCard CC number = "5555555555554444"
     */
    @Test
    public void cc_details_isCorrect_4() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
        form.getDetails().setCardNumber(5555555555554444L);
        form.getDetails().setExpirationDate("05/31");
        form.getDetails().setCvvNumber(786);
        form.getDetails().setFirstName("Jr First");
        form.getDetails().setLastName("Test Last");
        assertTrue("Form is valid", form.isValid());
    }

    /**
     * test for valid VisaCC number = "4111111111111111"
     */
    @Test
    public void cc_details_isCorrect_5() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
        form.getDetails().setCardNumber(4111111111111111L);
        form.getDetails().setExpirationDate("02/20");
        form.getDetails().setCvvNumber(908);
        form.getDetails().setFirstName("First");
        form.getDetails().setLastName("Last Name");
        assertTrue("Form is valid", form.isValid());
    }

    /**
     * - test for incorrect format of expiration date
     * - test for incorrect number of digits for the credit card number (NOTE: Certain
     * card companies have certain CCN digit lengths and formats
     * See
     * https://www.cybersource.com/developers/getting_started/test_and_manage/best_practices/card_type_id/
     * for additional info)
     * - test for credit card numbers that do not pass Luhn validation
     * - test for incorrect number of digits for CVV (See https://www.cvvnumber.com/cvv.html)
     * - test for no first or last name or incorrect characters. Correct name characters
     * are alphabetical and spaces
     */
    @Test
    public void email_isShort() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
//        form.getFields().setEmail("a@b.c");
//        form.getFields().setPassword("123456");
//        assertTrue("Email should be invalid", !form.isEmailValid(true));
//        assertTrue("Password should be valid", form.isPasswordValid(false));
//        assertTrue("Form is valid, email should be invalid", !form.isValid());
//        assertEquals("Error message should be \"Too short\" not " + form.getEmailError(), "Too short", form.getEmailError());
    }

    @Test
    public void email_isWrongFormat() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
//        form.getFields().setEmail("aaa@baac");
//        form.getFields().setPassword("123456");
//        assertTrue("Email should be invalid", !form.isEmailValid(true));
//        assertTrue("Password should be valid", form.isPasswordValid(false));
//        assertTrue("Form is invalid, email should be invalid", !form.isValid());
//        assertEquals("Error message should be \"Format is invalid\" not " + form.getEmailError(), "Format is invalid", form.getEmailError());
    }

    @Test
    public void password_isShort() {
        CreditCardViewModel vm = new CreditCardViewModel();
        vm.init();
        CreditCardForm form = vm.getForm();
//        form.getFields().setEmail("a@b.cc");
//        form.getFields().setPassword("1234");
//        assertTrue("Email should be valid", form.isEmailValid(false));
//        assertTrue("Password should be invalid", !form.isPasswordValid(true));
//        assertTrue("Form is invalid, password should be invalid", !form.isValid());
//        assertEquals("Error message should be \"Too short\" not " + form.getPasswordError(), "Too short", form.getPasswordError());
    }
}