package com.example.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.viewbinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Gorsel> gorselArrayList;
    int seciliSiraNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        gorselArrayList = new ArrayList<>();

        Gorsel balon = new Gorsel("Balon",1, R.drawable.balon);
        Gorsel cicek = new Gorsel("Çiçek",2,R.drawable.cicek);
        Gorsel kelebek = new Gorsel("Kelebek",3,R.drawable.kelebek);
        Gorsel kus = new Gorsel("Kuş",4,R.drawable.kus);

        gorselArrayList.add(balon);
        gorselArrayList.add(cicek);
        gorselArrayList.add(kelebek);
        gorselArrayList.add(kus);

        binding.imageViewGorsel.setImageResource(gorselArrayList.get(0).foto);
        binding.bilgi.setText("Bilgi: " + gorselArrayList.get(0).bilgi);
        seciliSiraNo = 0;

        binding.btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geriGelme(view);
            }
        });
        binding.btnIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ileriGitme(view);
            }
        });
    }

    public void geriGelme(View view){
        if (seciliSiraNo > 0){
            seciliSiraNo--;
            binding.imageViewGorsel.setImageResource(gorselArrayList.get(seciliSiraNo).foto);
            binding.bilgi.setText("Bilgi: " + gorselArrayList.get(seciliSiraNo).bilgi);
        }
    }

    public void ileriGitme(View view){
        if(seciliSiraNo < gorselArrayList.size()-1){
            seciliSiraNo++;
            binding.imageViewGorsel.setImageResource(gorselArrayList.get(seciliSiraNo).foto);
            binding.bilgi.setText("Bilgi: " + gorselArrayList.get(seciliSiraNo).bilgi);
        }
    }

}













