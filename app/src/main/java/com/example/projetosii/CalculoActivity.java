package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class CalculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        // CRIA A VARIÁVEL QUE RECEBE A TAG IMAGEVIEW QUE EXIBIRÁ OS CÁLCULOS
        ImageView myImgView = findViewById(R.id.image_calculo);

        // DEFINE QUAL IMAGEM SERÁ EXIBIDA ATRAVÉS DO SEU NOME
        myImgView.setImageResource(R.drawable.calculo);
    }
}
