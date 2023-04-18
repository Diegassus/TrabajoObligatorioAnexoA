package com.example.trabajoobligatorioanexoa.ui.musica;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajoobligatorioanexoa.R;
import com.example.trabajoobligatorioanexoa.databinding.FragmentHomeBinding;

public class MusicaFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ServicioMusica vm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ServicioMusica.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnPlay.setOnClickListener(view -> {
            vm.startPlaying(getContext(), R.raw.hugo_gimenez);
        });

        binding.btnPause.setOnClickListener(view -> {
            vm.pausePlaying();
        });

        binding.btnStop.setOnClickListener(view -> {
            vm.stopPlaying();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        if (vm != null) {
            vm.stopPlaying();
        }
    }

}