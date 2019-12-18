package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ConfirmaActivity extends AppCompatActivity {

    private Bundle extras;
    Button buttonConfirm;
    String indiceCalculo;
    String numSort;
    Random random = new Random();

    public ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma);

        buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.teste = findViewById(R.id.textView);

        extras = getIntent().getExtras();
        if (extras != null){
            indiceCalculo = extras.getString("categoriaIntervalo");
        }

        if (indiceCalculo.equals("1")){
            numSort = Integer.toString(1 + random.nextInt(5));
        } else if (indiceCalculo.equals("6")){
            numSort = Integer.toString(6 + random.nextInt(5));
        } else if (indiceCalculo.equals("11")){
            numSort = Integer.toString(11 + random.nextInt(5));
        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmaActivity.this, CalculoActivity.class);
                intent.putExtra("numSort", numSort);
                startActivity(intent);
            }
        });
    }

    public static class ViewHolder {
        TextView teste;
    }
}
