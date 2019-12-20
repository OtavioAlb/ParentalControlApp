package br.com.usp.parentalcontrol;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.usp.parentalcontrol.util.DatabaseSql;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParentFragment extends Fragment {

    ImageView perfilView;
    TextView textOla;
    Button restrictionBt;
    Button riskBt;
    Button linkBt;
    Button guideBt;
    Button historicBt;
    Button alertBt;
    DatabaseSql databaseSql;
    Activity activity;

    public ParentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_parent, null);

        perfilView = view.findViewById(R.id.imageView);
        textOla = view.findViewById(R.id.textOla);

        databaseSql = new DatabaseSql(getActivity());

        textOla.setText("Olá, "+databaseSql.buscarUser()+"!");

        perfilView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent perfilIntent = new Intent(getContext(), ParentProfileActivity.class);
                //startActivity(perfilIntent);
                Message();
            }
        });

        riskBt = view.findViewById(R.id.risk);
        riskBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent riskIntent = new Intent(getContext(), ClassificationActivity.class);
                startActivity(riskIntent);
            }
        });

        restrictionBt = view.findViewById(R.id.restriction);
        restrictionBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restricIntent = new Intent(getContext(), RestrictionActivity.class);
                startActivity(restricIntent);
            }
        });

        linkBt = view.findViewById(R.id.link);
        linkBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkIntent = new Intent(getContext(), LinkActivity.class);
                startActivity(linkIntent);
            }
        });

        guideBt = view.findViewById(R.id.education);
        guideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent guideIntent = new Intent(getContext(), GuideActivity.class);
                startActivity(guideIntent);
            }
        });

        historicBt = view.findViewById(R.id.historic);
        historicBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historicIntent = new Intent(getContext(), HistoricActivity.class);
                startActivity(historicIntent);
            }
        });

        alertBt = view.findViewById(R.id.btAlert);
        alertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alertIntent = new Intent(getContext(), WarningActivity.class);
                startActivity(alertIntent);
            }
        });

        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void Message(){
        AlertDialog.Builder perfilEdit = new AlertDialog.Builder(getContext());
        perfilEdit.setMessage("Editar os dados de usuário." +
                "\n\n\n Obs: Funcionalidade ainda não implementada.");
        perfilEdit.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        perfilEdit.show();
    }
}
