package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class CalculoActivity extends AppCompatActivity {

    Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        btnVerificar = findViewById(R.id.button_devices);

        // CRIA A VARIÁVEL QUE RECEBE A TAG IMAGEVIEW QUE EXIBIRÁ OS CÁLCULOS
        ImageView myImgView = findViewById(R.id.image_calculo);

        // DEFINE QUAL IMAGEM SERÁ EXIBIDA ATRAVÉS DO SEU NOME
        myImgView.setImageResource(R.drawable.calculo);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnCar();
            }
        });
    }

    // MÉTODO PARA LIGAR O CARRINHO
    private void turnOnCar() {
        if (btSocket!=null) {
            try {
                // B É A MENSAGEM QUE O ARDUINO RECEBE PARA ATIVAR O CARRINHO
                btSocket.getOutputStream().write("B".getBytes());
            }
            catch (IOException e) {
                msg("Error");
            }
        }
    }

    private void msg(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

}
