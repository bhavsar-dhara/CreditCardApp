package com.presto.dhara.creditcardapp.creditcard.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.presto.dhara.creditcardapp.R;
import com.presto.dhara.creditcardapp.creditcard.datamodel.CreditCardDetails;
import com.presto.dhara.creditcardapp.databinding.CreditCardFragmentBinding;

public class CreditCardFragment extends Fragment {

    private CreditCardViewModel mViewModel;
    private Context context;
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

        binding.setModel(mViewModel);

        mViewModel.getCreditCardDetails()
                .observe(this, new Observer<CreditCardDetails>() {
            @Override
            public void onChanged(CreditCardDetails cardDetails) {
                    Toast.makeText(context, R.string.success_msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
