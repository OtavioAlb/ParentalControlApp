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

public class AudioObjectsAdapter extends RecyclerView.Adapter<AudioObjectsAdapter.AudioObjectsHolder> {

    public String checkAudio;
    Context context;
    List<AudioObjects> listAudio = new ArrayList<>();

    public AudioObjectsAdapter(Context context, List<AudioObjects> listAudio) {
        this.context = context;
        this.listAudio = listAudio;
    }

    @Override
    public AudioObjectsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_audio, parent, false);

        return new AudioObjectsAdapter.AudioObjectsHolder(view);
    }

    @Override
    public void onBindViewHolder(final AudioObjectsHolder holder, final int position) {

        final AudioObjects objects = listAudio.get(position);

        holder.textAudio.setText(objects.getAudio());

        holder.checkAudio.setChecked(objects.isSelected);
        holder.checkAudio.setTag(listAudio.get(position));

        holder.checkAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioObjects audio1 = (AudioObjects) holder.checkAudio.getTag();
                String data="";

                audio1.setSelected(holder.checkAudio.isChecked());

                listAudio.get(position).setSelected(holder.checkAudio.isChecked());

                for(int j=0;j<listAudio.size();j++){
                    if (listAudio.get(j).isSelected == true){
                        data = data.trim()+" "+ listAudio.get(j).getAudio().toString().trim();
                        checkAudio = data;
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return listAudio.size();
    }

    public static class AudioObjectsHolder extends RecyclerView.ViewHolder  {

        TextView textAudio;
        CheckBox checkAudio;

        public AudioObjectsHolder(View itemView){
            super(itemView);

            textAudio = itemView.findViewById(R.id.item_audio);
            checkAudio = itemView.findViewById(R.id.checkAudio);
        }
    }

    public List<AudioObjects> getList(){
        return listAudio;
    }

}
