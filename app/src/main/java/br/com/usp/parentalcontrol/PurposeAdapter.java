package br.com.usp.parentalcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PurposeAdapter extends RecyclerView.Adapter<PurposeAdapter.PurposeHolder> {

    public String txcheckPurpose;
    Context context;
    List<Purpose> list = new ArrayList<>();

    public PurposeAdapter(Context context, List<Purpose> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PurposeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_purpose, parent,false);

        return new PurposeHolder(view);
    }

    @Override
    public void onBindViewHolder(final PurposeHolder holder, final int position) {

        final Purpose purpose = list.get(position);

        holder.textPurpose.setText(purpose.getPurpose());

        holder.checkPurpose.setChecked(purpose.isSelected);
        holder.checkPurpose.setTag(list.get(position));

        holder.checkPurpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Purpose purpose1 = (Purpose)holder.checkPurpose.getTag();
                String data="";

                purpose1.setSelected(holder.checkPurpose.isChecked());

                for (int j=0; j<list.size(); j++){
                    if (list.get(j).isSelected == true){
                        data = data.trim()+" "+list.get(j).getPurpose().toString().trim();
                        txcheckPurpose = data;
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PurposeHolder extends RecyclerView.ViewHolder{
        TextView textPurpose;
        CheckBox checkPurpose;

        public PurposeHolder(View itemView){
            super(itemView);

            textPurpose = itemView.findViewById(R.id.item_purpose);
            checkPurpose = itemView.findViewById(R.id.checkPurpose);
        }

    }

    public List<Purpose> getList(){
        return list;
    }
}
