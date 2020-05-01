package com.U4universeNavigationDrawer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.U4universeNavigationDrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGrade extends Fragment {

    public FragmentGrade() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grade, container, false);
    }
}
