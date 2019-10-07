package com.presto.dhara.creditcardapp.creditcard.viewmodel;

import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.presto.dhara.creditcardapp.creditcard.model.CreditCardDetails;
import com.presto.dhara.creditcardapp.creditcard.model.CreditCardForm;

public class CreditCardViewModel extends ViewModel {

    private static final String TAG = CreditCardViewModel.class.getSimpleName();

    private CreditCardForm cardForm;
    private View.OnFocusChangeListener onFocusCardNumber;
    private View.OnFocusChangeListener onFocusExpirationDate;
    private View.OnFocusChangeListener onFocusCvvNumber;
    private View.OnFocusChangeListener onFocusFirstName;
    private View.OnFocusChangeListener onFocusLastName;

    public void init() {
        cardForm = new CreditCardForm();

        onFocusCardNumber = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText() != null && et.getText().length() > 0 && !focused) {
                    cardForm.validateCardNumber(true);
                }
            }
        };

        onFocusExpirationDate = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText() != null && et.getText().length() > 0 && !focused) {
                    cardForm.validateExpirationDate(true);
                }
            }
        };

        onFocusCvvNumber = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText() != null && et.getText().length() > 0 && !focused) {
                    cardForm.validateCvvNumber(true);
                }
            }
        };

        onFocusFirstName = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText() != null && et.getText().length() > 0 && !focused) {
                    cardForm.validateFirstName(true);
                }
            }
        };

        onFocusLastName = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText() != null && et.getText().length() > 0 && !focused) {
                    cardForm.validateLastName(true);
                }
            }
        };
    }

    public CreditCardForm getCardForm() {
        return cardForm;
    }

    public View.OnFocusChangeListener getCardNumberOnFocusChangeListener() {
        return onFocusCardNumber;
    }

    public View.OnFocusChangeListener getExpirationDateOnFocusChangeListener() {
        return onFocusExpirationDate;
    }

    public View.OnFocusChangeListener getCvvNumberOnFocusChangeListener() {
        return onFocusCvvNumber;
    }

    public View.OnFocusChangeListener getFirstNameOnFocusChangeListener() {
        return onFocusFirstName;
    }

    public View.OnFocusChangeListener getLastNameOnFocusChangeListener() {
        return onFocusLastName;
    }

    public void onButtonClick() {
        cardForm.onClick();
    }

    public MutableLiveData<CreditCardDetails> getCreditCardDetails() {
        return cardForm.getCreditCardDetails();
    }

    public CreditCardForm getForm() {
        return cardForm;
    }

    @BindingAdapter({"error"})
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(
                    editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }

    @BindingAdapter({"onFocus"})
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
