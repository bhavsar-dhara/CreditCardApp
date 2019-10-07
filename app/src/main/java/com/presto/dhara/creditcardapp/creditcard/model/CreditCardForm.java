package com.presto.dhara.creditcardapp.creditcard.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.presto.dhara.creditcardapp.BR;
import com.presto.dhara.creditcardapp.R;
import com.presto.dhara.creditcardapp.utils.AppConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import timber.log.Timber;

public class CreditCardForm extends BaseObservable {

    private static final String TAG = CreditCardForm.class.getSimpleName();

    private CreditCardDetails details = new CreditCardDetails();
    private CreditCardErrorFields errors = new CreditCardErrorFields();
    private MutableLiveData<CreditCardDetails> buttonClick = new MutableLiveData<>();

    /**
     * method to call to check the form's validity
     *
     * @return boolean true when valid
     */
    @Bindable
    public boolean isValid() {
        boolean valid = validateCardNumber(false) &&
                validateExpirationDate(false) &&
                validateCvvNumber(false) &&
                validateFirstName(false) &&
                validateLastName(false);
        notifyPropertyChanged(BR.cardNumberError);
        notifyPropertyChanged(BR.expirationDateError);
        notifyPropertyChanged(BR.cvvNumberError);
        notifyPropertyChanged(BR.firstNameError);
        notifyPropertyChanged(BR.lastNameError);
        return valid;
    }

    /**
     * method to check the form's validity on submit button click
     *
     * @return boolean true when valid
     */
    private boolean isValidOnButtonClick() {
        boolean valid = validateCardNumber(true) &&
                validateExpirationDate(true) &&
                validateCvvNumber(true) &&
                validateFirstName(true) &&
                validateLastName(true);
        notifyPropertyChanged(BR.cardNumberError);
        notifyPropertyChanged(BR.expirationDateError);
        notifyPropertyChanged(BR.cvvNumberError);
        notifyPropertyChanged(BR.firstNameError);
        notifyPropertyChanged(BR.lastNameError);
        return valid;
    }

    /**
     * validate for incorrect credit card number digits
     * @link https://www.cybersource.com/developers/getting_started/test_and_manage/best_practices/card
     * _type_id/
     * also validate it passes the Luhn validation
     * supports only American Express, Visa, Mastercard, and Discover
     *
     * @param setMessage boolean when true then will set the message on UI
     * @return boolean true when validation is successful
     */
    public boolean validateCardNumber(boolean setMessage) {
        long cardNumber = details.getCardNumber();
        if (cardNumber > 0) {
            if (((getCardLength(cardNumber) >= 15 &&
                    getCardLength(cardNumber) <= 19) &&
                    passesLuhnValidation(cardNumber) &&
                    (checkValidCardType(cardNumber, AppConstants.AMERICAN_EXPRESS_PREFIX) ||
                            checkValidCardType(cardNumber, AppConstants.VISA_PREFIX) ||
                            checkValidCardType(cardNumber, AppConstants.MASTERCARD_PREFIX) ||
                            checkValidCardType(cardNumber, AppConstants.DISCOVER_PREFIX)))) {
                errors.setCardNumber(null);
                notifyPropertyChanged(BR.valid);
                return true;
            } else {
                if (setMessage) {
                    errors.setCardNumber(R.string.error_invalid_card_number);
                    notifyPropertyChanged(BR.valid);
                }
            }
        } else {
            if (setMessage) {
                errors.setCardNumber(R.string.required);
                notifyPropertyChanged(BR.valid);
            }
        }
        return false;
    }

    /**
     * function to get the card number length
     *
     * @param cardNumber credit card number
     * @return length of the card number or size of prefix
     */
    private int getCardLength(long cardNumber) {
        String num = cardNumber + "";
        Timber.d("getCardLength: %s for cardNumber = %s", num.length(), cardNumber);
        return num.length();
    }

    /**
     * function to test whether the credit card number passes the Luhn Algorithm Validation
     *
     * @param cardNumber credit card number
     * @return true if the card number passes the Luhn validation
     */
    private boolean passesLuhnValidation(long cardNumber) {
        int sum = 0;
        boolean alternate = false;
        String strCardNumber = String.valueOf(cardNumber);
        for (int i = strCardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(strCardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        Timber.d("passesLuhnValidation: %s for cardNumber = %s", (sum % 10), cardNumber);
        return (sum % 10 == 0);
    }

    /**
     * function to validate card type
     *
     * @param cardNumber credit card number
     * @param prefix prefix for a particular card type
     * @return true if card number matches the prefix
     */
    private boolean checkValidCardType(long cardNumber, int prefix) {
        long temp = 0L;
        int prefixLength = getCardLength(prefix);
        if (getCardLength(cardNumber) > prefixLength) {
            String num = cardNumber + "";
            temp = Long.parseLong(num.substring(0, prefixLength));
        }
        Timber.d("checkValidCardType: valid = %s for cardNumber = %s and prefix = %s", (temp == prefix), cardNumber, prefix);
        return temp == prefix;
    }

    /**
     * validate expiration date to have correct format (MM YY)
     *
     * @param setMessage boolean when true then will set the message on UI
     * @return boolean true when validation is successful
     */
    public boolean validateExpirationDate(boolean setMessage) {
        String expirationDate = details.getExpirationDate();
        if (expirationDate != null && !expirationDate.equals("")) {
            Timber.d("validateExpirationDate: date = %s", expirationDate);
            String regex = "^(0[1-9]|1[0-2])/([2-9][0-9])|(1[0-1] 19)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(expirationDate);
            if (matcher.matches()) {
                errors.setExpirationDate(null);
                notifyPropertyChanged(BR.valid);
                return true;
            } else {
                if (setMessage) {
                    errors.setExpirationDate(R.string.error_invalid_expiration_date);
                    notifyPropertyChanged(BR.valid);
                }
            }
        } else {
            if (setMessage) {
                errors.setExpirationDate(R.string.required);
                notifyPropertyChanged(BR.valid);
            }
        }
        return false;
    }

    /**
     * validate cvv for incorrect number of digits
     *
     * @link https://www.cvvnumber.com/cvv.html
     * @param setMessage boolean when true then will set the message on UI
     * @return boolean true when validation is successful
     */
    public boolean validateCvvNumber(boolean setMessage) {
        long cardNumber = details.getCardNumber();
        int cvvNumber = details.getCvvNumber();
        Timber.d("validateCvvNumber: cvv = %s", cvvNumber);
        if (validateCardNumber(false)) {
            if (cvvNumber > 0) {
                String regex;
                if (checkValidCardType(cardNumber, AppConstants.AMERICAN_EXPRESS_PREFIX)) {
                    regex = "^[0-9]{4}$";
                } else {
                    regex = "^[0-9]{3}$";
                }
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(String.valueOf(cvvNumber));
                if (matcher.matches()) {
                    errors.setCvvNumber(null);
                    notifyPropertyChanged(BR.valid);
                    return true;
                } else {
                    if (setMessage) {
                        errors.setCvvNumber(R.string.error_invalid_cvv_number);
                        notifyPropertyChanged(BR.valid);
                    }
                }
            } else {
                if (setMessage) {
                    errors.setCvvNumber(R.string.required);
                    notifyPropertyChanged(BR.valid);
                }
            }
        } else {
            if (setMessage) {
                errors.setCvvNumber(R.string.card_number_required);
                notifyPropertyChanged(BR.valid);
            }
        }
        return false;
    }

    /**
     * validate last name to contain only correct characters that is alphabets and spaces
     *
     * @param setMessage boolean when true then will set the message on UI
     * @return boolean true when validation is successful
     */
    public boolean validateFirstName(boolean setMessage) {
        String firstName = details.getFirstName();
        Timber.d("validateFirstName: firstName = %s", firstName);
        if (firstName != null && !firstName.equals("")) {
            String regex = "[\\p{L}\\s]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(firstName);
            if (matcher.matches()) {
                errors.setFirstName(null);
                notifyPropertyChanged(BR.valid);
                return true;
            } else {
                if (setMessage) {
                    errors.setFirstName(R.string.error_invalid_first_name);
                    notifyPropertyChanged(BR.valid);
                }
            }
        } else {
            if (setMessage) {
                errors.setFirstName(R.string.required);
                notifyPropertyChanged(BR.valid);
            }
        }
        return false;
    }

    /**
     * validate last name to contain only correct characters that is alphabets and spaces
     *
     * @param setMessage boolean when true then will set the message on UI
     * @return boolean true when validation is successful
     */
    public boolean validateLastName(boolean setMessage) {
        String lastName = details.getLastName();
        Timber.d("validateLastName: lastName = %s", lastName);
        if (lastName != null && !lastName.equals("")) {
            String regex = "[\\p{L}\\s]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(lastName);
            if (matcher.matches()) {
                errors.setLastName(null);
                notifyPropertyChanged(BR.valid);
                return true;
            } else {
                if (setMessage) {
                    errors.setLastName(R.string.error_invalid_last_name);
                    notifyPropertyChanged(BR.valid);
                }
                return false;
            }
        } else {
            if (setMessage) {
                errors.setLastName(R.string.required);
                notifyPropertyChanged(BR.valid);
            }
        }
        return false;
    }

    public void onClick() {
        if (isValidOnButtonClick()) {
            buttonClick.setValue(details);
        } else {
            Timber.i("onClick: not valid");
        }
    }

    public MutableLiveData<CreditCardDetails> getCreditCardDetails() {
        return buttonClick;
    }

    public CreditCardDetails getDetails() {
        return details;
    }

    @Bindable
    public Integer getCardNumberError() {
        return errors.getCardNumber();
    }

    @Bindable
    public Integer getExpirationDateError() {
        return errors.getExpirationDate();
    }

    @Bindable
    public Integer getCvvNumberError() {
        return errors.getCvvNumber();
    }

    @Bindable
    public Integer getFirstNameError() {
        return errors.getFirstName();
    }

    @Bindable
    public Integer getLastNameError() {
        return errors.getLastName();
    }
}
