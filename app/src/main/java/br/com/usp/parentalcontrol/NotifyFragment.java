package br.com.usp.parentalcontrol;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyFragment extends Fragment {

    Button faqBt;
    Button chatBt;
    Button removePiiBt;
    Button userDisableBt;
    private ListView listViewNotify;

    TextView txtTerms;
    TextView txtPolitic;

    String[] notifies = {"Compartilhamento: CleverTap", "Coleta de Dados: Cookies", "Compartilhamento: AWS"};


    public NotifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notify, null);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, notifies);

        txtTerms = view.findViewById(R.id.txtTerms);
        txtTerms.setMovementMethod(LinkMovementMethod.getInstance());

        txtPolitic = view.findViewById(R.id.txtPolitic);
        txtPolitic.setMovementMethod(LinkMovementMethod.getInstance());

        listViewNotify = view.findViewById(R.id.listViewNotify);
        listViewNotify.setAdapter(adapter);

        listViewNotify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String teste = adapterView.getItemAtPosition(i).toString();
                switch (teste){
                    case "Compartilhamento: CleverTap":
                        Message1();
                        break;

                    case "Coleta de Dados: Cookies":
                        Message2();
                        break;

                    case "Compartilhamento: AWS":
                        Message3();
                        break;
                }
            }
        });

        chatBt = view.findViewById(R.id.btChat);
        chatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(getContext(), ChatActivity.class);
                startActivity(chatIntent);
            }
        });

        faqBt = view.findViewById(R.id.btFaq);
        faqBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FaqActivity.class);
                startActivity(intent);
            }
        });

        removePiiBt = view.findViewById(R.id.btRemovePII);
        removePiiBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piiIntent = new Intent(getContext(), RemovePIIActivity.class);
                startActivity(piiIntent);
            }
        });

        userDisableBt = view.findViewById(R.id.btDisableAccount);
        userDisableBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertConfirm = new AlertDialog.Builder(getContext());
                alertConfirm.setTitle("Desativar a conta de usuário");
                alertConfirm.setMessage(getResources().getString(R.string.descDisable));
                alertConfirm.setPositiveButton("Sim, tenho certeza.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertConfirm.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertConfirm.show();
            }
        });

        return view;
    }

    public void Message1(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Atualização na política de privacidade");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacao));
        notifyUpdate.setPositiveButton("ver Política completa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        notifyUpdate.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

    public void Message2(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Atualização na política de privacidade");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacaoColeta));
        notifyUpdate.setPositiveButton("ver Política completa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        notifyUpdate.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

    public void Message3(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Atualização na política de privacidade");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacaoCompart));
        notifyUpdate.setPositiveButton("ver Política completa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        notifyUpdate.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

}
