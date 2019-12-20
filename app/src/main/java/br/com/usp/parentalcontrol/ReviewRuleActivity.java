package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.usp.parentalcontrol.Model.Rule;
import br.com.usp.parentalcontrol.util.DatabaseSql;

public class ReviewRuleActivity extends AppCompatActivity {

    TextView textDescribName;
    TextView textResumeRule;
    TextView textResumeRule2;
    DatabaseSql databaseSql;
    Intent reviewRule;
    Button btFinish;
    Button btBack;

    String name_rule;
    String descri_rule;
    String spinnerService;
    String operation_check;
    String purpose;
    String recipient;
    String obligation;
    String retention;

    String object;

    Rule rule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_rule);

        databaseSql = new DatabaseSql(this);

        rule = new Rule();

        btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmMessage();
            }
        });

        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reviewBackRule = new Intent(ReviewRuleActivity.this, ObligationActivity.class);
                reviewBackRule.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(reviewBackRule);
            }
        });

        Intent receiveData = getIntent();
        Bundle parameters = receiveData.getExtras();

        rule.setNameRule(parameters.getString("NameRule"));
        name_rule = rule.getNameRule();
        rule.setDescriptRule(parameters.getString("DescripRule"));
        descri_rule = rule.getDescriptRule();
        rule.setWebServiceRule(parameters.getString("SpinnerWebservice"));
        spinnerService = rule.getWebServiceRule();
        rule.setOperationCheck(parameters.getString("CheckOperation"));
        operation_check = rule.getOperationCheck();
        rule.setObjectCheck(parameters.getString("CheckObj"));
        object = rule.getObjectCheck();

        rule.setPurpose(parameters.getString("Purpose"));
        purpose = rule.getPurpose();
        rule.setRecipient(parameters.getString("Recipient"));
        recipient = rule.getRecipient();

        rule.setObligation(parameters.getString("Obligation"));
        obligation = rule.getObligation();
        rule.setRetention(parameters.getString("Retention"));
        retention = rule.getRetention();


        textDescribName = findViewById(R.id.textDescribName);
        textDescribName.setText("Você está criando a regra de privacidade "+(name_rule).toUpperCase()+"." +
                " Por favor, revise cuidadosamente todos os dados informados:");

        textResumeRule = findViewById(R.id.textresumeRule);
        textResumeRule.setText("A regra de privacidade "+(name_rule).toUpperCase()+" permitirá que o serviço móvel "+(spinnerService).toUpperCase()+" realize a(s) operação(ões)"+
                "" +(operation_check).toUpperCase()+" no(s) objeto(s) "+(object).toUpperCase()+", com o(s) propósito(s) de uso "
                +(purpose).toUpperCase()+", podendo ser compartilhado(s) de forma "+(recipient).toUpperCase()+", " +
                "precisando cumprir as obrigações definidas em "+(obligation).toUpperCase()+", e retidas pelo tempo "+(retention).toUpperCase()+".");
    }

    public void confirmMessage(){
        AlertDialog.Builder confirmBox = new AlertDialog.Builder(this);
        confirmBox.setTitle("Confirmar");
        confirmBox.setMessage("Tem certeza que deseja confirmar os dados?");
        confirmBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addRule();
                reviewRule = new Intent(ReviewRuleActivity.this, MainActivity.class);
                startActivity(reviewRule);
            }
        });
        confirmBox.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(ReviewRuleActivity.this, "Dados salvos", Toast.LENGTH_SHORT).show();
            }
        });
        confirmBox.show();
    }

    private void addRule() {


        databaseSql.insertRule(name_rule, descri_rule, spinnerService, operation_check, object, purpose,
                recipient, obligation, retention);
    }
}
