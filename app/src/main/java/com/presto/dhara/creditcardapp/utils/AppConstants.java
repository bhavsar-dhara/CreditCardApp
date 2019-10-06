package com.presto.dhara.creditcardapp.utils;

public class AppConstants {

    /**
     * Valid length: 15 digits. First digit must be a 3 and second digit must be a 4 or 7.
     *
     * CVV code - 4 digit
     */
    public static final int AMERICAN_EXPRESS_PREFIX = 3;

    /**
     * Valid length: Up to 19 digits. First digit must be a 4.
     *
     * CVV code - 3 digit
     */
    public static final int VISA_PREFIX = 4;

    /**
     * Valid length: 16 digits.
     *
     * First digit must be 5 and second digit must be in the range 1 through 5 inclusive.
     * The range is 510000 through 559999.
     *
     * First digit must be 2 and second digit must be in the range 2 through 7 inclusive.
     * The range is 222100 through 272099.
     *
     * CVV code - 3 digit
     */
    public static final int MASTERCARD_PREFIX = 5;

    /**
     * Valid length: 16 digits.
     *
     * First 6 digits must be in one of the following ranges:
     *
     * 601100 through 601109
     * 601120 through 601149
     * 601174
     * 601177 through 601179
     * 601186 through 601199
     * 644000 through 659999
     *
     * CVV code - 3 digit
     */
    public static final int DISCOVER_PREFIX = 6;
}
