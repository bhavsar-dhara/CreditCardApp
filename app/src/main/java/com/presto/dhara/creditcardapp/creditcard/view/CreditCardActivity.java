package com.presto.dhara.creditcardapp.creditcard.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.presto.dhara.creditcardapp.R;

public class CreditCardActivity extends AppCompatActivity {

    CreditCardViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.credit_card_activity);

        viewModel = ViewModelProviders
                .of(this)
                .get(CreditCardViewModel.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CreditCardFragment.newInstance())
                    .commitNow();
            viewModel.init();
        }
    }
}
