package com.example.swiggy_layout.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.swiggy_layout.authentication.UserModel;
import com.example.swiggy_layout.R;
import com.example.swiggy_layout.utils.SharedPreferences;

import java.util.HashMap;

public class ProfileFragment extends Fragment {
    private Spinner spinner;
    private ProgressBar progressBar;
    private EditText mobile, name, email, dob;
    private Button update_btn;
    private Spinner Gender_spinner;
    private ProfileViewModel profileViewModel;
    String[] genderArray = {"Male", "Female", "Others"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        spinner = view.findViewById(R.id.Gender_spinner);

        mobile=view.findViewById(R.id.mobile);
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        dob=view.findViewById(R.id.dob);
        update_btn=view.findViewById(R.id.update_btn);
        Gender_spinner=view.findViewById(R.id.Gender_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, genderArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter ko attach kiya h spinner se
        spinner.setAdapter(adapter);

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.getData(getContext(), SharedPreferences.getNumber(getContext()));
        profileViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<UserModel>() {
            @Override
            //yaha pe onChanged me Usermodel ka data  mil gya ab uska kya krna h aage vo likhna padega
            public void onChanged(UserModel userModel) {
                //agar backend se mobile
                if (!userModel.getMobile().isEmpty()) {
                    mobile.setText(userModel.getMobile());
                }
                if (!userModel.getDob().isEmpty()) {
                    dob.setText(userModel.getDob());
                }
                if (!userModel.getName().isEmpty()) {
                    name.setText(userModel.getName());
                }
                if (!userModel.getEmail().isEmpty()) {
                    email.setText(userModel.getEmail());
                }
                if (!userModel.getDob().isEmpty()) {
                    dob.setText(userModel.getDob());
                }
                if (userModel.getGender().isEmpty()) {
                    if (userModel.getGender().equals("male")) {
                        spinner.setSelection(0);
                    } else if (userModel.getGender().equals("female")) {
                        spinner.setSelection(1);
                    } else {
                        spinner.setSelection(2);
                    }

                }
            }
        });

        //updating userdetails on click of update_btn;
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=name.getText().toString();
                String mobile_number=mobile.getText().toString();
                String Email= email.getText().toString();
                String DOB=dob.getText().toString();
                String gen= spinner.getSelectedItem().toString();

                HashMap hashMap=new HashMap();
                hashMap.put("name",username);
                hashMap.put("mob",mobile_number);
                hashMap.put("mail",Email);
                hashMap.put("dob",DOB);
                hashMap.put("gender",gen);

                //API hit ki h
                profileViewModel.update(getContext(), hashMap);



            }
        });


        return view.getRootView();
    }

}