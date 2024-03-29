package com.presto.dhara.creditcardapp.creditcard.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.presto.dhara.creditcardapp.R;
import com.presto.dhara.creditcardapp.creditcard.model.CreditCardDetails;
import com.presto.dhara.creditcardapp.creditcard.viewmodel.CreditCardViewModel;
import com.presto.dhara.creditcardapp.databinding.CreditCardFragmentBinding;

public class CreditCardFragment extends Fragment {

    private CreditCardViewModel mViewModel;
    private Context context;
    private Observer<CreditCardDetails> observer;
    private CreditCardFragmentBinding binding;

    public static CreditCardFragment newInstance() {
        return new CreditCardFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.credit_card_fragment, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders
                .of(requireActivity())
                .get(CreditCardViewModel.class);

        if (savedInstanceState == null) {
            mViewModel.init();
        }

        binding.setModel(mViewModel);

        observer = new Observer<CreditCardDetails>() {
            @Override
            public void onChanged(CreditCardDetails cardDetails) {
                showSuccessDialog();
            }
        };
        mViewModel.getCreditCardDetails()
                .observe(this, observer);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // To remove any leaks from happening
        context = null;
        mViewModel.getCreditCardDetails().removeObserver(observer);
        if (observer != null)
            observer = null;
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.success_title)
                .setMessage(R.string.success_msg)
                .setPositiveButton(getString(R.string.success_btn), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        // reset the form fields
                        mViewModel.getCardForm().getDetails().setCardNumber(0L);
                        mViewModel.getCardForm().getDetails().setExpirationDate("");
                        mViewModel.getCardForm().getDetails().setCvvNumber(0);
                        mViewModel.getCardForm().getDetails().setFirstName("");
                        mViewModel.getCardForm().getDetails().setLastName("");
                        binding.ccCreditCardNumber.setText("");
                        binding.ccCreditCardExpiration.setText("");
                        binding.ccCreditCardCvv.setText("");
                        binding.ccCreditCardFirstName.setText("");
                        binding.ccCreditCardLastName.setText("");
                    }
                });

        builder.setCancelable(false);

        // create alert dialog
        AlertDialog alertDialog = builder.create();

        // show it
        alertDialog.show();
    }
}
