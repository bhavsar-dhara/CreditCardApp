package com.presto.dhara.creditcardapp.creditcard.model;

class CreditCardErrorFields {

    private Integer cardNumber;
    private Integer expirationDate;
    private Integer cvvNumber;
    private Integer firstName;
    private Integer lastName;

    Integer getCardNumber() {
        return cardNumber;
    }

    void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    Integer getExpirationDate() {
        return expirationDate;
    }

    void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    Integer getCvvNumber() {
        return cvvNumber;
    }

    void setCvvNumber(Integer cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    Integer getFirstName() {
        return firstName;
    }

    void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    Integer getLastName() {
        return lastName;
    }

    void setLastName(Integer lastName) {
        this.lastName = lastName;
    }
}
