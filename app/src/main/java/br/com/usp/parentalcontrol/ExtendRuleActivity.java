package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExtendRuleActivity extends AppCompatActivity {

    ImageView doubtPurpose;
    ImageView doubtRecipient;

    Button btNext;
    Button btBack;

    Intent extendScreen;

    RecyclerView recyclerViewPurpose;
    PurposeAdapter purposeAdapter;
    List<Purpose> listPurpose = new ArrayList<>();

    RecyclerView recyclerViewRecipient;
    RecipientAdapter recipientAdapter;
    List<Recipient> listRecipient = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_rule);

        doubtPurpose = findViewById(R.id.doubtPurpose);
        doubtRecipient = findViewById(R.id.doubtRecipient);

        /*CheckBox Audio*/
        recyclerViewPurpose= findViewById(R.id.recylcer_purpose);

        recyclerViewPurpose.setLayoutManager(new LinearLayoutManager(this));

        String[] purposeArray = getResources().getStringArray(R.array.purpose);

        for(int i=0;i<purposeArray.length;i++){
            Purpose purpose1 = new Purpose(purposeArray[i], false);
            listPurpose.add(purpose1);
        }
        purposeAdapter = new PurposeAdapter( ExtendRuleActivity.this,listPurpose);
        recyclerViewPurpose.setAdapter(purposeAdapter);
        /*---*/

        /*CheckBox Recipient*/
        recyclerViewRecipient= findViewById(R.id.recycler_recipient);

        recyclerViewRecipient.setLayoutManager(new LinearLayoutManager(this));

        String[] RecipArray = getResources().getStringArray(R.array.recipients);

        for(int i=0;i<RecipArray.length;i++){
            Recipient recipient1 = new Recipient(RecipArray[i], false);
            listRecipient.add(recipient1);
        }
        recipientAdapter = new RecipientAdapter( ExtendRuleActivity.this,listRecipient);
        recyclerViewRecipient.setAdapter(recipientAdapter);
        /*---*/

        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (purposeAdapter.txcheckPurpose != null){
                    sendData();
                }else if(recipientAdapter.txtCheckRecipient != null){
                    sendData();
                }else{
                    noNull();
                }
            }
        });

        btBack = findViewById(R.id.btCancel);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent generalBackScreen = new Intent(ExtendRuleActivity.this, GeneralRuleActivity.class);
                generalBackScreen.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(generalBackScreen);
            }
        });

        doubtPurpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPurpose();
            }
        });

        doubtRecipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecipient();
            }
        });

        }

    public void sendData(){

        extendScreen = new Intent(ExtendRuleActivity.this, ObligationActivity.class);

        Bundle parameters = new Bundle();

        Intent intent = getIntent();
        parameters = intent.getExtras();

        parameters.putString("Purpose", purposeAdapter.txcheckPurpose);
        parameters.putString("Recipient", recipientAdapter.txtCheckRecipient);

        parameters.putString("NameRule", parameters.getString("NameRule"));
        parameters.putString("DescripRule", parameters.getString("DescripRule"));
        parameters.putString("SpinnerWebservice", parameters.getString("SpinnerWebservice"));
        parameters.putString("CheckOperation", parameters.getString("CheckOperation"));
        parameters.putString("CheckObj", parameters.getString("CheckObj"));

        extendScreen.putExtras(parameters);
        startActivity(extendScreen);
    }

    public void showPurpose(){
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.textPurpose);
        boxWeb.setMessage(R.string.descPurpose);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;boxWeb.show();
    }

    public void showRecipient(){
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.textRecipients);
        boxWeb.setMessage(R.string.descRecipients);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;boxWeb.show();
    }

    public void noNull() {
        AlertDialog.Builder opNull = new AlertDialog.Builder(this);
        opNull.setMessage("Selecting at least one of the field options is required.");
        opNull.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        opNull.show();
    }
}
