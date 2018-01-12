package com.example.ajsor.aaronsstore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {


    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Fragshow
        View HeyFragment = inflater.inflate(R.layout.fragment_text, container, false);

        HeyFragment.findViewById(R.id.FragTextView);

        return HeyFragment;
    }

}
