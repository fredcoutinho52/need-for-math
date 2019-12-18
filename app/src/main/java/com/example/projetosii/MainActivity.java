package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.buttonFundamental = findViewById(R.id.button_fundamental);
        this.mViewHolder.buttonMedio = findViewById(R.id.button_medio);
        this.mViewHolder.buttonSuperior = findViewById(R.id.button_superior);

        this.mViewHolder.buttonFundamental.setOnClickListener(this);
        this.mViewHolder.buttonMedio.setOnClickListener(this);
        this.mViewHolder.buttonSuperior.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_fundamental){
            Intent intent = new Intent(this, ConfirmaActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button_medio){
            Intent intent = new Intent(this, ConfirmaActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button_superior){
            Intent intent = new Intent(this, ConfirmaActivity.class);
            startActivity(intent);
        }
    }

    public static class ViewHolder {
        Button buttonFundamental;
        Button buttonMedio;
        Button buttonSuperior;
    }
}
