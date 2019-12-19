package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class CalculoActivity extends AppCompatActivity {

    Button btnVerificar;
    TextView txtView;
    private Bundle extras;
    String numReceived;
    String putNum;
    EditText editText;
    public static BluetoothSocket btSocket = MainActivity.btSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        btnVerificar = findViewById(R.id.button_verificar);
        editText = findViewById(R.id.respBox);
        txtView = findViewById(R.id.textView);

        // PEGA O QUE FOI RECEBIDO DA PÁGINA DE CONFIRMAÇÃO
        extras = getIntent().getExtras();
        if (extras != null){
            numReceived = "q" + extras.getString("numSort");
        }

        // CRIA A VARIÁVEL QUE RECEBE A TAG IMAGEVIEW QUE EXIBIRÁ OS CÁLCULOS
        ImageView myImgView = findViewById(R.id.image_calculo);

        // FUNÇÃO PARA CAPTURAR O ID DA IMAGEM DO DRAWABLE
        int idImage = getResources().getIdentifier(numReceived, "drawable", getPackageName());

        // MOSTRA A IMAGEM DE ACORDO COM O ID
        myImgView.setImageResource(idImage);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNum = editText.getText().toString();
                String idResp = getString(getResources().getIdentifier(numReceived, "string", getPackageName()));
                // AQUI VAI CHAMAR O MÉTODO PARA LIGAR O CARRINHO SE A RESPOSTA ESTIVER CORRETA
                if (putNum.equals(idResp)){
                    txtView.setText("CERTO");
                    txtView.setTextColor(getResources().getColor(R.color.green));
                    turnOnCar();
                } else {
                    txtView.setText("ERRADO");
                    txtView.setTextColor(getResources().getColor(R.color.red));
                }
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
