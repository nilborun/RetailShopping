package com.example.lenovo.retailshoppingapp.UI.fragment;

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

import com.example.lenovo.retailshoppingapp.R;

public class LoginFragment extends Fragment {
    TextInputLayout mInputLayoutEmail, mInputLayoutPassword;
    AppCompatEditText mLoginEmail_ET, mLoginPassword_ET;
    AppCompatButton mLogin_Btn, mLoginWithFacebook_Btn, mLoginWithGPlus_Btn;
    AppCompatTextView mForgetPassword_TV, mRegister_TV, mSkipThePage_TV, mErrorEmail_TV, mErrorPassword_TV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initializeView(view);

        return view;
    }

    private void initializeView(View view) {
        mInputLayoutEmail = view.findViewById(R.id.wrapper_login_email);
        mInputLayoutPassword = view.findViewById(R.id.wrapper_login_password);
        mLoginEmail_ET = view.findViewById(R.id.et_login_email);
        mLoginPassword_ET = view.findViewById(R.id.et_login_password);
        mLogin_Btn = view.findViewById(R.id.btn_login);
        mLoginWithFacebook_Btn = view.findViewById(R.id.btn_login_with_facebbok);
        mLoginWithGPlus_Btn = view.findViewById(R.id.btn_login_with_google_plus);
        mForgetPassword_TV = view.findViewById(R.id.tv_forget_password);
        mRegister_TV = view.findViewById(R.id.tv_new_account_reg);
        mSkipThePage_TV = view.findViewById(R.id.tv_skip_the_login_page);
        mErrorEmail_TV = view.findViewById(R.id.tv_error_msg_email);
        mErrorPassword_TV = view.findViewById(R.id.tv_error_msg_password);

        mLoginPassword_ET.addTextChangedListener(new TextWatcherUtil(mLoginPassword_ET));
        mLoginEmail_ET.addTextChangedListener(new TextWatcherUtil(mLoginEmail_ET));


        mLogin_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();

            }
        });
    }

    private void submitForm() {
        String correctEmail = getString(R.string.user_name);
        String email = mLoginEmail_ET.getText().toString();
        String password = mLoginPassword_ET.getText().toString();
        String correctPassword = getString(R.string.user_password);

        if (!validateEmail()) {
            return;
        }
        if (!validPassword()) {
            return;
        }
        if (correctEmail.equals(email) && correctPassword.equals(password)) {
            Toast.makeText(getActivity(), "Login Successfulll", Toast.LENGTH_LONG).show();
            mErrorPassword_TV.setVisibility(View.GONE);

        } else {
            mErrorPassword_TV.setVisibility(View.VISIBLE);
            mErrorPassword_TV.setText(getString(R.string.error_full_msg));
        }


    }

    private boolean validateEmail() {
        String email = mLoginEmail_ET.getText().toString();

        if (email.isEmpty()) {
            mErrorEmail_TV.setVisibility(View.VISIBLE);
            mErrorEmail_TV.setText(getString(R.string.error_empty_email));
            return false;

        } else if (!isValidEmail(email)) {

            mErrorEmail_TV.setVisibility(View.VISIBLE);
            mErrorEmail_TV.setText(getString(R.string.error_wrong_email));
            return false;
        } else {
            mErrorEmail_TV.setVisibility(View.GONE);

        }
        return true;
    }

    private boolean validPassword() {
        String password = mLoginPassword_ET.getText().toString();

        if (password.trim().isEmpty()) {

            mErrorPassword_TV.setVisibility(View.VISIBLE);
            mErrorPassword_TV.setText(getString(R.string.error_empty_password));
            return false;
        } else {
            mErrorPassword_TV.setVisibility(View.GONE);
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
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
                case R.id.et_login_email:
                    validateEmail();
                    break;
                case R.id.et_login_password:
                    validPassword();
                    break;
                default:
                    break;
            }

        }

    }
}
