package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralRuleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText editNameRule;
    EditText editDescritpRule;
    TextView textObjects;
    TextView textOperation;

    String webService;
    String objects;

    Intent generalScreen;
    Spinner spinner;
    Button btNext;
    Button btCancel;
    ImageView doubtCore;
    ImageView doubtWeb;
    ImageView doubtOperation;
    ImageView doubtObject;

    RecyclerView recyclerViewOp;
    OperationAdapter opAdapter;
    List<Operation> list = new ArrayList<>();

    RecyclerView recyclerViewObj;
    locationObjectsAdapter objAdapter;
    List<locationObjects> listLoc = new ArrayList<>();

    RecyclerView recyclerViewCam;
    cameraObjectsAdapter camAdapter;
    List<CameraObjects> listCam = new ArrayList<>();

    RecyclerView recyclerViewAudio;
    AudioObjectsAdapter audioAdapter;
    List<AudioObjects> listAudio = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_rule);

        editNameRule = findViewById(R.id.edit_name_rule);
        editDescritpRule = findViewById(R.id.edit_descript_rule);

        textOperation = findViewById(R.id.textOperation);

        recyclerViewOp = findViewById(R.id.recycler_operation);

        doubtCore = findViewById(R.id.doubtCore);
        doubtWeb = findViewById(R.id.doubtWeb);
        doubtOperation = findViewById(R.id.doubtOperation);
        doubtObject = findViewById(R.id.doubtObject);

        recyclerViewOp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        String[] operations = getResources().getStringArray(R.array.operations_array);

        for (int i = 0; i < operations.length; i++) {
            Operation operation1 = new Operation(operations[i], false);
            list.add(operation1);
        }

        opAdapter = new OperationAdapter(GeneralRuleActivity.this, list);
        recyclerViewOp.setAdapter(opAdapter);

        textObjects = findViewById(R.id.textObjects);

        /*CheckBox Location*/
        recyclerViewObj = findViewById(R.id.recycler_locObj);

        recyclerViewObj.setLayoutManager(new LinearLayoutManager(this));

        String[] locObjects = getResources().getStringArray(R.array.loc_objects);

        for (int i = 0; i < locObjects.length; i++) {
            locationObjects objects1 = new locationObjects(locObjects[i], false);
            listLoc.add(objects1);
        }

        objAdapter = new locationObjectsAdapter(GeneralRuleActivity.this, listLoc);
        recyclerViewObj.setAdapter(objAdapter);
        /*---*/

        /*CheckBox Camera*/
        recyclerViewCam = findViewById(R.id.recycler_camObj);

        recyclerViewCam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        String[] camObjects = getResources().getStringArray(R.array.cam_objects);

        for (int i = 0; i < camObjects.length; i++) {
            CameraObjects camera1 = new CameraObjects(camObjects[i], false);
            listCam.add(camera1);
        }

        camAdapter = new cameraObjectsAdapter(GeneralRuleActivity.this, listCam);
        recyclerViewCam.setAdapter(camAdapter);
        /*---*/

        /*CheckBox Audio*/
        recyclerViewAudio = findViewById(R.id.recycler_audObj);

        recyclerViewAudio.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        String[] audioObjects = getResources().getStringArray(R.array.voz_objects);

        for (int i = 0; i < audioObjects.length; i++) {
            AudioObjects audio1 = new AudioObjects(audioObjects[i], false);
            listAudio.add(audio1);
        }

        audioAdapter = new AudioObjectsAdapter(GeneralRuleActivity.this, listAudio);
        recyclerViewAudio.setAdapter(audioAdapter);
        /*---*/


        spinner = findViewById(R.id.spinnerWebService);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_web_service,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opAdapter.checkOps != null ) {
                    sendData();
                } else {
                    operationNull();
                }
            }
        });

        btCancel = findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainScreen = new Intent(GeneralRuleActivity.this, MainActivity.class);
                startActivity(mainScreen);
            }
        });

        doubtCore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCore();
            }
        });
        doubtWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWeb();
            }
        });
        doubtOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOperation();
            }
        });
        doubtObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showObject();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        textOperation.setVisibility(View.INVISIBLE);
        doubtOperation.setVisibility(View.INVISIBLE);
        recyclerViewOp.setVisibility(View.INVISIBLE);

        textObjects.setVisibility(View.INVISIBLE);
        doubtObject.setVisibility(View.INVISIBLE);
        recyclerViewObj.setVisibility(View.INVISIBLE);
        recyclerViewCam.setVisibility(View.INVISIBLE);
        recyclerViewAudio.setVisibility(View.INVISIBLE);

        webService = adapterView.getItemAtPosition(i).toString();

        switch (webService) {
            case "Location service":
                textOperation.setVisibility(View.VISIBLE);
                doubtOperation.setVisibility(View.VISIBLE);
                recyclerViewOp.setVisibility(View.VISIBLE);

                textObjects.setVisibility(View.VISIBLE);
                doubtObject.setVisibility(View.VISIBLE);
                recyclerViewObj.setVisibility(View.VISIBLE);
                recyclerViewCam.setVisibility(View.INVISIBLE);
                recyclerViewCam.setEnabled(false);
                recyclerViewAudio.setVisibility(View.INVISIBLE);
                recyclerViewAudio.setEnabled(false);

                break;

            case "Image service":
                textOperation.setVisibility(View.VISIBLE);
                doubtOperation.setVisibility(View.VISIBLE);
                recyclerViewOp.setVisibility(View.VISIBLE);

                textObjects.setVisibility(View.VISIBLE);
                doubtObject.setVisibility(View.VISIBLE);
                recyclerViewObj.setVisibility(View.INVISIBLE);
                recyclerViewObj.setEnabled(false);
                recyclerViewCam.setVisibility(View.VISIBLE);
                recyclerViewAudio.setVisibility(View.INVISIBLE);
                recyclerViewAudio.setEnabled(false);
                break;

            case "Voice service":
                textOperation.setVisibility(View.VISIBLE);
                doubtOperation.setVisibility(View.VISIBLE);
                recyclerViewOp.setVisibility(View.VISIBLE);

                textObjects.setVisibility(View.VISIBLE);
                doubtObject.setVisibility(View.VISIBLE);
                recyclerViewObj.setVisibility(View.INVISIBLE);
                recyclerViewObj.setEnabled(false);
                recyclerViewCam.setVisibility(View.INVISIBLE);
                recyclerViewCam.setEnabled(false);
                recyclerViewAudio.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void sendData() {
        generalScreen = new Intent(GeneralRuleActivity.this, ExtendRuleActivity.class);

        Bundle parameters = new Bundle();
        parameters.putString("NameRule", editNameRule.getText().toString());
        parameters.putString("DescripRule", editDescritpRule.getText().toString());
        parameters.putString("SpinnerWebservice", webService);
        parameters.putString("CheckOperation", opAdapter.checkOps.toString());
        if (objAdapter.checkLocation != null) {
            parameters.putString("CheckObj", objAdapter.checkLocation.toString());
        } else if (camAdapter.checkCamera != null) {
            parameters.putString("CheckObj", camAdapter.checkCamera.toString());
        } else if (audioAdapter.checkAudio != null) {
            parameters.putString("CheckObj", audioAdapter.checkAudio.toString());
        }


        /*Toast.makeText(GeneralRuleActivity.this, editNameRule.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, editDescritpRule.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, webService, Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, opAdapter.checkOps, Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, objAdapter.checkLocation, Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, camAdapter.checkCamera, Toast.LENGTH_SHORT).show();
        Toast.makeText(GeneralRuleActivity.this, audioAdapter.checkAudio, Toast.LENGTH_SHORT).show();*/


        generalScreen.putExtras(parameters);
        startActivity(generalScreen);
    }

    public void showCore() {
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.txtBoxCore);
        boxWeb.setMessage(R.string.showCore);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;
        boxWeb.show();
    }

    public void showWeb() {
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.txtBoxWeb);
        boxWeb.setMessage(R.string.showWeb);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;
        boxWeb.show();
    }

    public void showOperation() {
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.txtBoxOperation);
        boxWeb.setMessage(R.string.showOperation);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;
        boxWeb.show();
    }

    public void showObject() {
        AlertDialog.Builder boxWeb = new AlertDialog.Builder(this);
        boxWeb.setTitle(R.string.txtBoxObject);
        boxWeb.setMessage(R.string.showObject);
        boxWeb.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
        ;
        boxWeb.show();
    }

    public void operationNull() {
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
