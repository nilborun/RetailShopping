package com.example.lenovo.retailshoppingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

public class AccountOpenFragment extends Fragment {
    TextInputLayout mWrapperFirstName, mWrapperLastName, mWrapperEmail, mWrapperPassword, mWrapperPhoneNo;
    AppCompatEditText mFirstName_ET, mLastName_ET, mRegEmail_ET, mRegPassword_ET, mPhone_ET;
    AppCompatButton mOpenAccount_Btn;
    AppCompatTextView mSkipThePage_TV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_registration, container, false);
        initializeView(view);
        return view;
    }

    private void initializeView(View view) {
        mWrapperFirstName = view.findViewById(R.id.wrapper_first_name);
        mWrapperLastName = view.findViewById(R.id.wrapper_last_name);
        mWrapperEmail = view.findViewById(R.id.wrapper_email);
        mWrapperPassword = view.findViewById(R.id.wrapper_password);
        mWrapperPhoneNo = view.findViewById(R.id.wrapper_phone_number);

        mFirstName_ET = view.findViewById(R.id.et_first_name);
        mLastName_ET = view.findViewById(R.id.et_last_name);
        mRegEmail_ET = view.findViewById(R.id.et_reg_email);
        mRegPassword_ET = view.findViewById(R.id.et_lreg_password);
        mPhone_ET = view.findViewById(R.id.et_phone_number);

        mOpenAccount_Btn = view.findViewById(R.id.btn_create_an_account);
        mSkipThePage_TV = view.findViewById(R.id.tv_skip_the_reg_page);

        mFirstName_ET.addTextChangedListener(new TextWatcherUtil(mFirstName_ET));
        mLastName_ET.addTextChangedListener(new TextWatcherUtil(mLastName_ET));
        mRegEmail_ET.addTextChangedListener(new TextWatcherUtil(mRegEmail_ET));
        mRegPassword_ET.addTextChangedListener(new TextWatcherUtil(mRegPassword_ET));
        mPhone_ET.addTextChangedListener(new TextWatcherUtil(mPhone_ET));

        mOpenAccount_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();

            }
        });

    }

    private void submitForm() {
        if (!validateEmail()) {
            return;
        }
        if (!validFirstName()) {
            return;
        }
        if (!validLastName()) {
            return;
        }
        if (!validPassword()) {
            return;
        }
        if (!validPhoneNumber())
            return;

        Toast.makeText(getActivity(), "Registration Success", Toast.LENGTH_LONG).show();
    }

    class TextWatcherUtil implements TextWatcher {
        private View mView;

        public TextWatcherUtil(View view) {
            mView = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (mView.getId()) {
                case R.id.et_reg_email:
                    validateEmail();
                    break;
                case R.id.et_lreg_password:
                    validPassword();
                    break;
                case R.id.et_first_name:
                    validFirstName();
                    break;
                case R.id.et_last_name:
                    validLastName();
                    break;
                case R.id.et_phone_number:
                    validPhoneNumber();
                    break;
                default:
                    break;
            }

        }

    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocusView(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validPhoneNumber() {
        String phoneNo = mPhone_ET.getText().toString();
        if (phoneNo.isEmpty()) {
            mWrapperPhoneNo.setError(getString(R.string.error_general_for_field));
            requestFocusView(mPhone_ET);
            return false;
        } else {
            mWrapperPhoneNo.setErrorEnabled(false);
        }
        return true;

    }

    private boolean validLastName() {
        String lastName = mLastName_ET.getText().toString();
        if (lastName.isEmpty()) {
            mWrapperLastName.setError(getString(R.string.error_general_for_field));
            requestFocusView(mLastName_ET);
            return false;
        } else {
            mWrapperLastName.setErrorEnabled(false);
        }
        return true;

    }

    private boolean validFirstName() {
        String firstName = mFirstName_ET.getText().toString();
        if (firstName.isEmpty()) {
            mWrapperFirstName.setError(getString(R.string.error_general_for_field));
            requestFocusView(mFirstName_ET);
            return false;
        } else {
            mWrapperFirstName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validPassword() {
        String password = mRegPassword_ET.getText().toString();

        if (password.trim().isEmpty()) {
            mWrapperPassword.setError(getString(R.string.error_empty_password));
            requestFocusView(mRegPassword_ET);

            return false;
        } else {

            mWrapperPassword.setErrorEnabled(false);
        }
        return true;

    }

    private boolean validateEmail() {
        String email = mRegEmail_ET.getText().toString();

        if (email.isEmpty()) {
            mWrapperEmail.setError(getString(R.string.error_empty_email));
            requestFocusView(mRegEmail_ET);
            return false;

        } else if (!isValidEmail(email)) {
            mWrapperEmail.setError(getString(R.string.error_wrong_email));
            requestFocusView(mRegEmail_ET);

            return false;
        } else {
            mWrapperEmail.setErrorEnabled(false);


        }
        return true;

    }
}
