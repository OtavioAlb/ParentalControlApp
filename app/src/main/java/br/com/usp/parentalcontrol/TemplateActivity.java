package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.usp.parentalcontrol.Model.Rule;
import br.com.usp.parentalcontrol.util.DatabaseSql;

public class TemplateActivity extends AppCompatActivity {

    Button btClose;
    Button btSearch;
    Button btSelect;
    ListView listView;
    List<Rule> list;
    DatabaseSql databaseSql;
    ListRuleAdapter templateAdapter;
    int idItemSelected;

    String[] rules = {"Location service rule for games","Image service rule for photos only","Voice service rule for restriction on sending data via microphone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        listView = findViewById(R.id.listViewTemp);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rules);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String teste = adapterView.getItemAtPosition(i).toString();
                switch (teste){
                    case "Location service rule for games":
                        Message1();
                        break;

                    case "Image service rule for photos only":
                        Message2();
                        break;

                    case "Voice service rule for restriction on sending data via microphone":
                        Message3();
                        break;
                }
            }
        });

        btSearch = findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchBox();
            }
        });

        btSelect = findViewById(R.id.btselect);
        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectBox();
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

    public void searchBox(){
        AlertDialog.Builder search = new AlertDialog.Builder(this);
        search.setTitle(R.string.txtBuscar);
        search.setMessage(R.string.descBusca);
        search.setPositiveButton("Search rule", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        search.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        search.show();
    }

    public void selectBox(){
        AlertDialog.Builder select = new AlertDialog.Builder(this);
        select.setTitle(R.string.txtSelecionar);
        select.setMessage(R.string.descSelecionar);
        select.setPositiveButton("Yes, I agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        select.setNegativeButton("No, cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        select.show();
    }


    public void Message1(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Rule Description");
        descriptBox.setMessage("Privacy rule will allow mobile service of LOCATION to perform operations CAPTURE and SEND " +
                        "on objects ABSOLUTE LOCATION and RELATIVE LOCATION for the purpose of use GAME and can be shared in the form " +
                        "GROUP, having to fulfill the obligations defined in PIPEDA and COPPA, and retained by the time STATED PURPOSE.");
        descriptBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }

    public void Message2(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Rule Description");
        descriptBox.setMessage("Privacy rule will allow mobile service of IMAGEM to perform operations CAPTURE and SEND " +
                        "on object PHOTO for the purpose of use ANY and can be shared in the form " +
                        "ANY, having to fulfill the obligation defined in PIPEDA, and retained by the time PERSONALIZED for 2 MONTHS. ");
        descriptBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }

    public void Message3(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Rule Description");
        descriptBox.setMessage("Privacy rule will allow mobile service of VOICE to perform operation SEND on object AUDIO  " +
                        "for the purpose of use GAME and can be shared in the form INDIVIDUAL, " +
                        "having to fulfill the obligations defined in COPPA, and retained by the time LEGAL REQUIREMENT.");
        descriptBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }
}
