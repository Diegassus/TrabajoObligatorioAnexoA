package com.example.trabajoobligatorioanexoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trabajoobligatorioanexoa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;
    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvErrores.setText(s);
            }
    });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            vm.login(binding.etUsuario.getText().toString(),binding.etPassword.getText().toString());
        }
    });

        vm.getAccess().observe(this, new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean aBoolean) {
            if(aBoolean){
                Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        }
    });
}
}