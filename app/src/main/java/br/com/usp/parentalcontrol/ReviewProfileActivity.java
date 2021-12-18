package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import br.com.usp.parentalcontrol.util.DatabaseSql;

public class ReviewProfileActivity extends AppCompatActivity {

    DatabaseSql databaseSql;
    CheckBox CheckReview;
    Intent reviewScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_profile);


        CheckReview = findViewById(R.id.checkBoxReview);

        databaseSql = new DatabaseSql(this);

        Button btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmMessage();
            }
        });
        Button btBackReview = findViewById(R.id.btBackReview);
        btBackReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reviewScreen = new Intent(ReviewProfileActivity.this, ChildProfileActivity.class);
                reviewScreen.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(reviewScreen);
            }
        });
    }

    public void confirmMessage(){
        AlertDialog.Builder confirmBox = new AlertDialog.Builder(this);
        confirmBox.setTitle("Confirm");
        confirmBox.setMessage("Are you sure you want to confirm the data?");
        confirmBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addProfile();
                reviewScreen = new Intent(ReviewProfileActivity.this, MainActivity.class);
                startActivity(reviewScreen);
            }
        });
        confirmBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(ReviewProfileActivity.this, "Dados salvos", Toast.LENGTH_SHORT).show();
            }
        });
        confirmBox.show();
    }

    private void addProfile(){
        Intent receiveData = getIntent();
        Bundle parameters = receiveData.getExtras();

        String first_name = parameters.getString("FirstName");
        String last_name = parameters.getString("LastName");
        String email = parameters.getString("Email");
        boolean check_parent = parameters.getBoolean("CheckBoxParent");
        String child_name = parameters.getString("ChildName");
        boolean check_child = parameters.getBoolean("CheckChild");
        boolean check_review = CheckReview.isChecked();


        databaseSql.insert(first_name, last_name, email, check_parent, child_name, check_child, check_review);
    }
}
