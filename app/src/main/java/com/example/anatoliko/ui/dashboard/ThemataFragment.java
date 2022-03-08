package com.example.anatoliko.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.anatoliko.R;

public class ThemataFragment extends Fragment {

    private ThemataViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(ThemataViewModel.class);
        View root = inflater.inflate(R.layout.fragment_themata, container, false);



        return root;
    }
}