package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RemovePIIActivity extends AppCompatActivity {

    Button btClose;
    Button btRequest;
    EditText justifyRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_pii);

        justifyRemove = findViewById(R.id
        .editRemovePII);

        btRequest = findViewById(R.id.removeRequire);
        btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                justifyRemove.setText("");
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
        requestReturn.setTitle("Request sent!");
        requestReturn.setMessage(R.string.responseRemove);
        requestReturn.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        requestReturn.show();
    }
}
