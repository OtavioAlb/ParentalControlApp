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

public class RecipientAdapter extends RecyclerView.Adapter<RecipientAdapter.RecipientHolder> {

    public String txtCheckRecipient;
    Context context;
    List<Recipient> list = new ArrayList<>();

    public RecipientAdapter(Context context, List<Recipient> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecipientAdapter.RecipientHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recipient, parent,false);
        return new RecipientHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipientAdapter.RecipientHolder holder, final int position) {

        final Recipient recipient = list.get(position);

        holder.textRecipient.setText(recipient.getRecipient());

        holder.checkRecipient.setChecked(recipient.isSelected);
        holder.checkRecipient.setTag(list.get(position));

        holder.checkRecipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipient recipient1 = (Recipient)holder.checkRecipient.getTag();
                String data="";

                recipient1.setSelected(holder.checkRecipient.isChecked());

                for (int j=0;j<list.size();j++){
                    if (list.get(j).isSelected == true){
                        data = data.trim()+" "+list.get(j).getRecipient().toString().trim();
                        txtCheckRecipient = data;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RecipientHolder extends RecyclerView.ViewHolder{
        TextView textRecipient;
        CheckBox checkRecipient;

        public RecipientHolder(View itemView) {
            super(itemView);

            textRecipient = itemView.findViewById(R.id.item_recipient);
            checkRecipient = itemView.findViewById(R.id.checkRecipient);
        }
    }
}
