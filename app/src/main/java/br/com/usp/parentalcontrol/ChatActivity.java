package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ChatActivity extends AppCompatActivity {

    Button btClose;
    Button btAccess;
    ListView listSubjects;
    String[] subjects = {"Questions", "Complaints", "Suggestions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);

        listSubjects = findViewById(R.id.listViewChat);
        listSubjects.setAdapter(adapter);

        btAccess = findViewById(R.id.btAccess);
        btAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessConfirm();
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

    public void accessConfirm(){
        AlertDialog.Builder accessBox = new AlertDialog.Builder(this);
        accessBox.setMessage("Wait for one of our collaborators to connect..." +
                "\n\n Demo screen.");
        accessBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        accessBox.show();
    }
}
