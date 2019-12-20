package br.com.usp.parentalcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ObligationAdapter extends RecyclerView.Adapter<ObligationAdapter.ObligationHolder> {

    public String txtCheckObligation;
    Context context;
    List<Obligation> list = new ArrayList<>();

    public ObligationAdapter(Context context, List<Obligation> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ObligationHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_obligation, parent,false);

        return new ObligationHolder(view);
    }

    @Override
    public void onBindViewHolder(final ObligationAdapter.ObligationHolder holder, int position) {

        final Obligation obligation = list.get(position);

        holder.textObligation.setText(obligation.getObligation());

        holder.checkObligation.setChecked(obligation.isSelected);
        holder.checkObligation.setTag(list.get(position));

        holder.checkObligation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Obligation obligation1 = (Obligation)holder.checkObligation.getTag();
                String data="";

                obligation1.setSelected(holder.checkObligation.isChecked());

                for (int j=0;j<list.size();j++){
                    if (list.get(j).isSelected == true){
                        data = data.trim()+" "+list.get(j).getObligation().toString().trim();
                        txtCheckObligation = data;
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ObligationHolder extends RecyclerView.ViewHolder{

        TextView textObligation;
        CheckBox checkObligation;

        public ObligationHolder(View itemView) {
            super(itemView);

            textObligation = itemView.findViewById(R.id.item_obligation);
            checkObligation = itemView.findViewById(R.id.checkObligation);

        }

    }

    public List<Obligation> getList(){
        return list;
    }

}
