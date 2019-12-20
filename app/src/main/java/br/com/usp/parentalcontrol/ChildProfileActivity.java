package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ChildProfileActivity extends AppCompatActivity {

    EditText ChildNameEdit;
    CheckBox CheckChild;
    Intent childScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_profile);

        ChildNameEdit = findViewById(R.id.childNameEdit);
        CheckChild = findViewById(R.id.checkBoxChild);


        Button btNextChild = findViewById(R.id.btNextChild);
        btNextChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        Button btBackChild = findViewById(R.id.btBackChild);
        btBackChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                childScreen = new Intent(ChildProfileActivity.this, ParentProfileActivity.class);
                childScreen.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(childScreen);
            }
        });

    }
    public void sendData(){

        childScreen = new Intent(ChildProfileActivity.this, ReviewProfileActivity.class);
        Bundle parameters = new Bundle();

        Intent intent = getIntent();
        parameters = intent.getExtras();

        parameters.putString("ChildName", ChildNameEdit.getText().toString());
        parameters.putBoolean("CheckChild", CheckChild.isChecked());

        parameters.putString("FirstName", parameters.getString("FirstName"));
        parameters.putString("LastName", parameters.getString("LastName"));
        parameters.putString("Email", parameters.getString("Email"));
        parameters.putBoolean("CheckBoxParent", parameters.getBoolean("CheckBoxParent"));

        childScreen.putExtras(parameters);
        startActivity(childScreen);
    }
}
