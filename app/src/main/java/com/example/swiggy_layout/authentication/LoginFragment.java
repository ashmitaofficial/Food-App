package com.example.swiggy_layout.authentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.swiggy_layout.home.HomeActivity;
import com.example.swiggy_layout.R;
import com.example.swiggy_layout.utils.SharedPreferences;

import java.util.HashMap;


public class LoginFragment extends Fragment {
    private Button loginBtn;
    private TextView signupTxt;

    private EditText mobileNumber,password;
    private AuthenticationViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        signupTxt = view.findViewById(R.id.signupTxt);
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, SignupFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
        //viewmodel attached to login fragment
        viewModel=  new ViewModelProvider(this).get(AuthenticationViewModel.class);
        loginBtn = view.findViewById(R.id.loginBtn);
        password=view.findViewById(R.id.password);
        mobileNumber=view.findViewById(R.id.mobileNumber);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user_password=password.getText().toString();
                String user_number=mobileNumber.getText().toString();

                HashMap map=new HashMap();
                map.put("password",user_password);
                map.put("mobile",user_number);

                viewModel.login(getContext(),map);

            }
        });

        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                SharedPreferences.saveLogin(getContext(),userModel.getMobile());

                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view.getRootView();

    }
}