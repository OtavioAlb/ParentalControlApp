package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import br.com.usp.parentalcontrol.Model.Rule;

public class ParentProfileActivity extends AppCompatActivity {

    TextView textOla;
    EditText firstNameParentEdit;
    EditText lastNameParentEdit;
    EditText emailEdit;
    CheckBox CheckParent;
    Intent parentScreen;

    Rule rule;
    Bundle parameters;

    String firstName;
    String lastName;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);

        firstNameParentEdit = findViewById(R.id.first_name_edit);
        lastNameParentEdit = findViewById(R.id.last_name_edit);
        emailEdit = findViewById(R.id.email_edit);
        CheckParent = findViewById(R.id.checkBoxParent);

        Button btNextParent = findViewById(R.id.btNext);
        btNextParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });

        Button btCancelParent = findViewById(R.id.btCancel);
        btCancelParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentScreen = new Intent(ParentProfileActivity.this, MainActivity.class);
                startActivity(parentScreen);
            }
        });
    }

    public void sendData(){

        parentScreen = new Intent(ParentProfileActivity.this, ChildProfileActivity.class);

        parameters = new Bundle();

        parameters.putString("FirstName", firstNameParentEdit.getText().toString());
        parameters.putString("LastName", lastNameParentEdit.getText().toString());
        parameters.putString("Email", emailEdit.getText().toString());
        parameters.putBoolean("CheckBoxParent", CheckParent.isChecked());

        parentScreen.putExtras(parameters);
        startActivity(parentScreen);
    }

}
