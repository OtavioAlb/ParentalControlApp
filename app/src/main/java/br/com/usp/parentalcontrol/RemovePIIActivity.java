package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemovePIIActivity extends AppCompatActivity {

    Button btClose;
    Button btRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_pii);

        btRequest = findViewById(R.id.removeRequire);
        btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmRequest();
            }
        });

        btClose = findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void confirmRequest(){
        AlertDialog.Builder requestReturn = new AlertDialog.Builder(this);
        requestReturn.setTitle("Solicitação de remoção de PIIs efetuada!");
        requestReturn.setMessage("A empresa enviará um e-mail com a confirmação da remoção dos dados.");
        requestReturn.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        requestReturn.show();
    }
}
