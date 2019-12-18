package com.example.projetosii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button buttonFundamental;
    Button buttonMedio;
    Button buttonSuperior;

    String categoriaIntervalo;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    public static BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent newInt = getIntent();
        address = newInt.getStringExtra(DeviceActivity.EXTRA_ADDRESS);

        setContentView(R.layout.activity_main);

        buttonFundamental = findViewById(R.id.button_fundamental);
        buttonMedio = findViewById(R.id.button_medio);
        buttonSuperior = findViewById(R.id.button_superior);

        // CHAMA A CLASSE DE CONEXÃO
        //new ConnectBT().execute();

        buttonFundamental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmaActivity.class);
                categoriaIntervalo = "1";
                intent.putExtra("categoriaIntervalo", categoriaIntervalo);
                startActivity(intent);
            }
        });

        buttonMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmaActivity.class);
                categoriaIntervalo = "6";
                intent.putExtra("categoriaIntervalo", categoriaIntervalo);
                startActivity(intent);
            }
        });

        buttonSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmaActivity.class);
                categoriaIntervalo = "11";
                intent.putExtra("categoriaIntervalo", categoriaIntervalo);
                startActivity(intent);
            }
        });
    }

    private void msg(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    // CLASSE PARA CONECTAR COM O MÓDULO BLUETOOTH
    /*private class ConnectBT extends AsyncTask<Void, Void, Void> { // UI thread
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(MainActivity.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) { //while the progress dialog is shown, the connection is done in background
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect(); // start connection
                }
            } catch (IOException e) {
                ConnectSuccess = false; // if the try failed, you can check the exception here
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) { // after the doInBackground, it checks if everything went fine
            super.onPostExecute(result);

            if (!ConnectSuccess) {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }*/
}
