package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ObligationActivity extends AppCompatActivity {

    RadioGroup radioRetention;
    RadioButton radioButton;
    Intent ObliRetScreen;
    Intent extendBackScreen;
    Button btNext;
    Button btBack;
    ImageView doubtObligation;
    ImageView doubtRetention;

    Spinner spinnerNumber;
    Spinner spinnerDate;

    RecyclerView recyclerViewObligation;
    ObligationAdapter obligationAdapter;
    List<Obligation> listObligation = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obligation);

        spinnerNumber = findViewById(R.id.spinnerNumber);
        ArrayAdapter<CharSequence> adapterNumber = ArrayAdapter.createFromResource(this, R.array.spinner_number,
                android.R.layout.simple_spinner_item);
        adapterNumber.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumber.setAdapter(adapterNumber);

        spinnerDate = findViewById(R.id.spinnerDate);
        ArrayAdapter<CharSequence> adapterDate = ArrayAdapter.createFromResource(this, R.array.spinner_date,
                android.R.layout.simple_spinner_item);
        adapterDate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDate.setAdapter(adapterDate);

        /*CheckBox Audio*/
        recyclerViewObligation= findViewById(R.id.recycler_obligation);

        recyclerViewObligation.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        String[] obligationArray = getResources().getStringArray(R.array.obligation);

        for(int i=0;i<obligationArray.length;i++){
            Obligation obligation1= new Obligation (obligationArray[i], false);
            listObligation.add(obligation1);
        }
        obligationAdapter = new ObligationAdapter(ObligationActivity.this, listObligation);
        recyclerViewObligation.setAdapter(obligationAdapter);
        /*---*/

        doubtObligation = findViewById(R.id.doubtObligation);
        doubtObligation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showObligation();
            }
        });

        doubtRetention = findViewById(R.id.doubtRetention);
        doubtRetention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRetention();
            }
        });

        spinnerNumber.setVisibility(View.INVISIBLE);
        spinnerDate.setVisibility(View.INVISIBLE);
        radioRetention = findViewById(R.id.radioRetention);
        radioRetention.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (radioRetention.getCheckedRadioButtonId()){
                    case R.id.noRetention:
                        spinnerNumber.setVisibility(View.INVISIBLE);
                        spinnerDate.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.propositoDefinido:
                        spinnerNumber.setVisibility(View.INVISIBLE);
                        spinnerDate.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.legalRequirement:
                        spinnerNumber.setVisibility(View.INVISIBLE);
                        spinnerDate.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.businessPractices:
                        spinnerNumber.setVisibility(View.INVISIBLE);
                        spinnerDate.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.indefinitely:
                        spinnerNumber.setVisibility(View.INVISIBLE);
                        spinnerDate.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radioCustom:
                        spinnerNumber.setVisibility(View.VISIBLE);
                        spinnerDate.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });


        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (obligationAdapter.txtCheckObligation != null){
                    sendData();
                }else{
                    nomNull();
                }
            }
        });

        btBack = findViewById(R.id.btCancel);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                extendBackScreen = new Intent(ObligationActivity.this, ExtendRuleActivity.class);
                extendBackScreen.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(extendBackScreen);
            }
        });

    }

    public void checkButton(View v){
        int radioID = radioRetention.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);

    }

    public void sendData(){

        ObliRetScreen = new Intent(ObligationActivity.this, ReviewRuleActivity.class);
        Bundle parameters = new Bundle();

        Intent intent = getIntent();
        parameters = intent.getExtras();

        parameters.putString("Obligation", obligationAdapter.txtCheckObligation);
        parameters.putString("Retention", radioButton.getText().toString());

        parameters.putString("NameRule", parameters.getString("NameRule"));
        parameters.putString("DescripRule", parameters.getString("DescripRule"));
        parameters.putString("SpinnerWebservice", parameters.getString("SpinnerWebservice"));
        parameters.putString("CheckOperation", parameters.getString("CheckOperation"));
        parameters.putString("CheckObj", parameters.getString("CheckObj"));

        parameters.putString("Purpose", parameters.getString("Purpose"));
        parameters.putString("Recipient", parameters.getString("Recipient"));

        ObliRetScreen.putExtras(parameters);
        startActivity(ObliRetScreen);
    }

    public void showObligation(){
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle("Obligations");
        boxWeb.setMessage(getResources().getString(R.string.popupObligation));
        boxWeb.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;boxWeb.show();
    }

    public void showRetention(){
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle("Retention");
        boxWeb.setMessage(getResources().getString(R.string.popupRetention));
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;boxWeb.show();
    }

    public void nomNull() {
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
