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

    String[] rules = {"Regra de serviço de localização para jogos","Regra de serviço de imagem apenas para fotos","Regra de serviço de voz para restrição no envio de dados via microfone"};

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
                    case "Regra de serviço de localização para jogos":
                        Message1();
                        break;

                    case "Regra de serviço de imagem apenas para fotos":
                        Message2();
                        break;

                    case "Regra de serviço de voz para restrição no envio de dados via microfone":
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
        search.setTitle("Buscar regra externa");
        search.setMessage("Esta opção habilita o usuário buscar arquivos .xml de regras predefinidas externas à ferramenta." +
                "\n\n\n Obs: funcionalidade ainda não implementada.");
        search.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        search.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        search.show();
    }

    public void selectBox(){
        AlertDialog.Builder select = new AlertDialog.Builder(this);
        select.setTitle("Selecionar regra");
        select.setMessage("Você confirma a seleção do modelo de regra?" +
                "\n Ao confirmar você habilita a regra para utilização, a qual será adicionada em sua tabela de regras de privaciadde em \"Gerenciar regras\"." +
                "\n\n\n Obs: funcionalidade ainda não implementada.");
        select.setPositiveButton("Sim, confirmo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        select.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        select.show();
    }


    public void Message1(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Descrição da regra");
        descriptBox.setMessage("A regra de privacidade permitirá que o serviço móvel de LOCALIZAÇÃO realize as operações "+
                "LER e ESCREVER nos objetos LOCALIZAÇÃO ABSOLUTA E LOCALIZAÇÃO RELATIVA, com o propósito de uso JOGOS, " +
                "podendo ser compartilhado para GRUPO (multi-jogador), precisando cumprir as obrigações definidas em PIPEDA E COPPA, e retidas pelo tempo do PROPÓSITO DEFINIDO.");
        descriptBox.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }

    public void Message2(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Descrição da regra");
        descriptBox.setMessage("A regra de privacidade permitirá que o serviço móvel de IMAGEM realize as operações "+
                "LER e ESCREVER no objeto FOTO, com o propósito de uso QUALQUER UM, " +
                "podendo ser compartilhado para QUALQUER UM, precisando cumprir as obrigações definidas em PIPEDA, e retidas pelo tempo PERSONALIZADO DE 2 MESES.");
        descriptBox.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }

    public void Message3(){
        AlertDialog.Builder descriptBox = new AlertDialog.Builder(this);
        descriptBox.setTitle("Descrição da regra");
        descriptBox.setMessage("A regra de privacidade permitirá que o serviço móvel de VOZ realize as operações "+
                "ESCREVER no objeto ÁUDIO, com o propósito de uso JOGOS, " +
                "podendo ser compartilhado para INDIVIDUAL, precisando cumprir as obrigações definidas em COPPA, e retidas pelo tempo do REQUISITO LEGAL.");
        descriptBox.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        descriptBox.show();
    }
}
