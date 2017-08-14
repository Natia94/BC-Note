package com.example.natia.cuny;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Natia on 8/11/17.
 */

public class LanguageFragment extends Fragment  {


    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.language,container,false);
        addListenerButton();

        return view;
    }

    public void addListenerButton () {

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_Group);
        btnDisplay = (Button) view.findViewById(R.id.btn_Display);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) view.findViewById(selectedId);

                Toast.makeText(getActivity(), radioButton.getText(),Toast.LENGTH_LONG).show();
                getActivity().onBackPressed();

            }
        });

    }





}


