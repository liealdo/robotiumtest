package com.example.aldo.robotiumtest;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText editText1,editText2;
    private Button button,button2;
    private TextView textView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        textView=(TextView)view.findViewById(R.id.textView);
        editText1= (EditText) view.findViewById(R.id.editText);
        editText2= (EditText) view.findViewById(R.id.editText2);
        button= (Button) view.findViewById(R.id.button);
        button2= (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word1=editText1.getText().toString();
                String word2=editText2.getText().toString();
                if(!isSignedNumeric(word1))
                    textView.setText(getString(R.string.error_message_signed_numeric));
                else if(!isLetter(word2))
                    textView.setText(getString(R.string.error_message_signed_alphabet));
                else
                    textView.setText(getString(R.string.success_message));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DetailActivity.class);
                startActivity(intent);
            }
        });
        Intent intent=getActivity().getIntent();
        if(intent!=null&&intent.getExtras()!=null) {
            String testing = intent.getStringExtra("testing");
            Toast.makeText(getActivity(), testing, Toast.LENGTH_LONG).show();
        }
        return view;
    }

    public boolean isSignedNumeric(String number){
        try {
            int newValue=Integer.parseInt(number);
            if(newValue<1)
                return false;
            else
                return true;
        }catch (NumberFormatException e){
            return  false;
        }
    }

    public boolean isLetter(String word){
        if(word.isEmpty())
            return false;
        for (int i=0;i<word.length();i++)
            if(!Character.isLetter(word.charAt(i)))
                return false;
        return  true;
    }


}
