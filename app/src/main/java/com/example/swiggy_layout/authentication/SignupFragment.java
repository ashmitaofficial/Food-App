package com.example.swiggy_layout.authentication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.swiggy_layout.R;

import java.util.HashMap;


public class SignupFragment extends Fragment {

    private Button CreateBtn;
    private TextView loginTxt;
    private EditText name, mobile, password;

    private AuthenticationViewModel authenticationViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        CreateBtn = view.findViewById(R.id.CreateBtn);
        name = view.findViewById(R.id.name);
        mobile = view.findViewById(R.id.mobile);
        password = view.findViewById(R.id.password);
        loginTxt=view.findViewById(R.id.loginTxt);

        //viewmodel attach
        authenticationViewModel = new ViewModelProvider(this).get(AuthenticationViewModel.class);


        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signup wala fragment pop ho jayega or jo login me backstack laga h vo visible ho jayega
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });

        CreateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String userMobile = mobile.getText().toString();
                String userPass = password.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("name", username);
                hashMap.put("password", userPass);
                hashMap.put("mobile", userMobile);

                authenticationViewModel.signUp(getContext(), hashMap);
            }


        });
        return view.getRootView();
    }
}