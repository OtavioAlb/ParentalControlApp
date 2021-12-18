package br.com.usp.parentalcontrol;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

import br.com.usp.parentalcontrol.Model.Rule;

public class ListRuleAdapter  extends ArrayAdapter<Rule>  {

    private static final String TAG = "ListRuleAdapter";

    private List<Rule> list;
    private Context mContext;
    int mResource;
    private int selected = -1;

    public ListRuleAdapter(Context context, int resource, List<Rule> objects) {
        super(context, resource, objects);
        this.list=list;
        mContext=context;
        mResource = resource;
    }

    /*@Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Rule getItem(int location) {
        return list.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int idRule = getItem(position).getId();
        final String nameRule = getItem(position).getNameRule();
        final String descripRule = getItem(position).getDescriptRule();
        final String webService = getItem(position).getWebServiceRule();
        final String operationCheck = getItem(position).getOperationCheck();
        final String objectCheck = getItem(position).getObjectCheck();
        final String purpose = getItem(position).getPurpose();
        final String recipient = getItem(position).getRecipient();
        final String obligation = getItem(position).getObligation();
        final String retention = getItem(position).getRetention();


        final Rule rule = new Rule(idRule, nameRule, descripRule, webService, operationCheck, objectCheck, purpose,
                recipient, obligation, retention);

        //final Rule rule = new Rule(nameRule,  webService);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView txtName = convertView.findViewById(R.id.txtNameRule);
        TextView txtWeb = convertView.findViewById(R.id.txtWebService);
        ImageView resumeView = convertView.findViewById(R.id.imageResume);
        // politicView = convertView.findViewById(R.id.imagePolitic);
        ImageView revokeView = convertView.findViewById(R.id.imageRevoke);

        txtName.setText(nameRule);
        txtWeb.setText(webService);

        resumeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmBox = new AlertDialog.Builder(getContext());
                confirmBox.setTitle("Rule Description\n");
                confirmBox.setMessage("Privacy rule "+(nameRule).toUpperCase()+" will allow mobile service "+(webService).toUpperCase()+
                                " to perform operation(s) "+(operationCheck).toUpperCase()+" on object(s) "+(objectCheck).toUpperCase()+" for " +
                                "the purpose(s) of use "+(purpose).toUpperCase()+" and can be shared in the form "+(recipient).toUpperCase()+
                                ", having to fulfill the obligation(s) defined in "+(obligation).toUpperCase()+", and retained by the time "
                                +(retention).toUpperCase()+".");



                confirmBox.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                confirmBox.show();
            }
        });

        /*politicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmBox = new AlertDialog.Builder(getContext());
                confirmBox.setTitle("Acessar Política de privacidade");
                confirmBox.setMessage("Você deseja acessar a política de privacidade do provedor de serviço?");
                confirmBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                confirmBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                confirmBox.show();
            }
        });*/

        revokeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder confirmBox = new AlertDialog.Builder(getContext());
                confirmBox.setTitle(R.string.txtRevoke);
                confirmBox.setMessage(R.string.descriRevogar);
                confirmBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                confirmBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                confirmBox.show();
            }
        });

        return convertView;
    }
}
