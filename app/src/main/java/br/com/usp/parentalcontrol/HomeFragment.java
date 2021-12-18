package br.com.usp.parentalcontrol;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.usp.parentalcontrol.Model.Rule;
import br.com.usp.parentalcontrol.util.DatabaseSql;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ListView listView;
    private Button btNewRule;
    private Button btEditRule;
    private Button btDeleteRule;
    DatabaseSql databaseSql;
    ListRuleAdapter ruleAdapter;
    List<Rule> list;
    private int selected = -1;
    int idItemSelected;

    Rule rule;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        listView = view.findViewById(R.id.listViewRule);
        databaseSql = new DatabaseSql(getActivity());

        final ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header,listView,false);
        listView.addHeaderView(headerView);

        list = databaseSql.getAllRules();

        ruleAdapter = new ListRuleAdapter(getActivity(), R.layout.adapter_listview_layout, list);
        listView.setAdapter(ruleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //view.setSelected(true);
                //view.setBackgroundResource(R.color.colorPrimary);
                idItemSelected =  i;
                //System.out.println();
            }
        });


        btNewRule = (Button) view.findViewById(R.id.btNew);
        btNewRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRuleConfirm();
            }
        });

        btEditRule = view.findViewById(R.id.btEdit);
        btEditRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder editBox = new AlertDialog.Builder(getContext());
                editBox.setMessage("Edit the selected privacy rule." +
                        "\n\n Functionality not implemented.");
                editBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                editBox.show();
            }
        });

        btDeleteRule = (Button) view.findViewById(R.id.btDelete);
        btDeleteRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseSql.deleteRule(idItemSelected);
                list.clear();
                list.addAll(databaseSql.getAllRules());
                ruleAdapter.notifyDataSetChanged();
            }
        });

        // Inflate the layout for this fragment

        return view;
    }

    public void createRuleConfirm(){
        AlertDialog.Builder confirmBox = new AlertDialog.Builder(getContext());
        confirmBox.setMessage("Select a method to create the privacy rule:");
        confirmBox.setNegativeButton("From scratch", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent newRule = new Intent(getContext(), GeneralRuleActivity.class);
                startActivity(newRule);
            }
        });
        confirmBox.setPositiveButton("Template based", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent templateIntent = new Intent(getContext(), TemplateActivity.class);
                startActivity(templateIntent);
            }
        });
        confirmBox.show();
    }

}
