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
public class FragmentColorLens extends Fragment {

    public FragmentColorLens() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_lens, container, false);
    }
}
