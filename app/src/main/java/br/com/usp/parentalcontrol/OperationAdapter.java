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

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.OperationHolder> {

    public String checkOps;
    Context context;
    List<Operation> list = new ArrayList<>();

    public OperationAdapter(Context context, List<Operation> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OperationHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_operations, parent,false);

        return new OperationHolder(view);
    }

    @Override
    public void onBindViewHolder(final OperationHolder holder, final int position) {

        final Operation operation = list.get(position);

        holder.textOp.setText(operation.getOperation());

        holder.checkOp.setChecked(operation.isSelected);
        holder.checkOp.setTag(list.get(position));

        holder.checkOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operation operation1 = (Operation)holder.checkOp.getTag();
                String data ="";

                operation1.setSelected(holder.checkOp.isChecked());

                list.get(position).setSelected(holder.checkOp.isChecked());

                for (int j=0; j<list.size(); j++){
                    if (list.get(j).isSelected == true){
                        data = data.trim()+" "+list.get(j).getOperation().toString().trim();
                        checkOps = data;
                    }
                }
                //Toast.makeText(context, "Selecionados: \n" + data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OperationHolder extends RecyclerView.ViewHolder{
        TextView textOp;
        CheckBox checkOp;

        public OperationHolder(View itemView){
            super(itemView);

            textOp = itemView.findViewById(R.id.item_op);
            checkOp = itemView.findViewById(R.id.checkOperation);
        }
    }

    public List<Operation>  getList() {
        return list;
    }
}
