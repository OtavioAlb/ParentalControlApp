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

    String[] notifies = {"Sharing: CleverTap", "Data collect: Cookies", "Sharing: AWS"};


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
        txtTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceTerms();
            }
        });
        //txtTerms.setMovementMethod(LinkMovementMethod.getInstance());

        txtPolitic = view.findViewById(R.id.txtPolitic);
        txtPolitic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrivacyPolice();
            }
        });
        //txtPolitic.setMovementMethod(LinkMovementMethod.getInstance());

        listViewNotify = view.findViewById(R.id.listViewNotify);
        listViewNotify.setAdapter(adapter);

        listViewNotify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String teste = adapterView.getItemAtPosition(i).toString();
                switch (teste){
                    case "Sharing: CleverTap":
                        Message1();
                        break;

                    case "Data collect: Cookies":
                        Message2();
                        break;

                    case "Sharing: AWS":
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
                alertConfirm.setTitle("Deactivate user\'s account");
                alertConfirm.setMessage(getResources().getString(R.string.descDisable));
                alertConfirm.setPositiveButton("Yes, i\'m sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertConfirm.setNegativeButton("No, cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertConfirm.show();
            }
        });

        return view;
    }

    public void ServiceTerms(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Service terms");
        notifyUpdate.setMessage(R.string.termosDesc);
        notifyUpdate.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        notifyUpdate.show();
    }

    public void PrivacyPolice(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Privacy policy");
        notifyUpdate.setMessage(R.string.politicDesc);
        notifyUpdate.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        notifyUpdate.show();
    }

    public void Message1(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Privacy policy update");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacao));
        notifyUpdate.setPositiveButton("See full policy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PoliticLink();
            }
        });
        notifyUpdate.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

    public void Message2(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Privacy policy update");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacaoColeta));
        notifyUpdate.setPositiveButton("See full policy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PoliticLink();
            }
        });
        notifyUpdate.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

    public void Message3(){
        AlertDialog.Builder notifyUpdate = new AlertDialog.Builder(getContext());
        notifyUpdate.setTitle("Privacy policy update");
        notifyUpdate.setMessage(getResources().getString(R.string.atualizacaoCompart));
        notifyUpdate.setPositiveButton("See full policy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PoliticLink();
            }
        });
        notifyUpdate.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        notifyUpdate.show();
    }

    public void PoliticLink(){
        AlertDialog.Builder seePolitc = new AlertDialog.Builder(getContext());
        seePolitc.setMessage(R.string.politicDesc);
        seePolitc.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        seePolitc.show();
    }

}
