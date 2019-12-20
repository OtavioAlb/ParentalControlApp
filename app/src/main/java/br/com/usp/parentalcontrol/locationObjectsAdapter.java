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

public class locationObjectsAdapter extends RecyclerView.Adapter<locationObjectsAdapter.ObjectHolder> {

    public String checkLocation;
    Context context;
    List<locationObjects> listLoc = new ArrayList<>();

    public locationObjectsAdapter(Context context, List<locationObjects> listLoc) {
        this.context = context;
        this.listLoc = listLoc;
    }

    @Override
    public ObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_loc, parent,false);

        return new locationObjectsAdapter.ObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ObjectHolder holder, final int position) {

        final locationObjects objects = listLoc.get(position);

        holder.textObj.setText(objects.getLocation());

        holder.checkObj.setChecked(objects.isSelected);
        holder.checkObj.setTag(listLoc.get(position));

        holder.checkObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationObjects object1 = (locationObjects)holder.checkObj.getTag();
                String data ="";

                object1.setSelected(holder.checkObj.isChecked());

                listLoc.get(position).setSelected(holder.checkObj.isChecked());

                for (int j=0; j<listLoc.size(); j++){
                    if (listLoc.get(j).isSelected == true){
                        data = data.trim()+" "+ listLoc.get(j).getLocation().toString().trim();
                        checkLocation = data;
                    }
                }
                //Toast.makeText(context, "Selecionados: \n" + data, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listLoc.size();
    }

    public static class ObjectHolder extends RecyclerView.ViewHolder{
        TextView textObj;
        CheckBox checkObj;

        public ObjectHolder(View itemView){
            super(itemView);

            textObj = itemView.findViewById(R.id.item_loc);
            checkObj = itemView.findViewById(R.id.checkLoc);
        }
    }

    public List<locationObjects> getList() {
        return listLoc;
    }
}
