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

public class cameraObjectsAdapter extends RecyclerView.Adapter<cameraObjectsAdapter.CamObjectHolder> {

    public String checkCamera;
    Context context;
    List<CameraObjects> listCam = new ArrayList<>();

    public cameraObjectsAdapter(Context context, List<CameraObjects> listCam) {
        this.context = context;
        this.listCam = listCam;
    }

    @Override
    public cameraObjectsAdapter.CamObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cam, parent,false);

        return new cameraObjectsAdapter.CamObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CamObjectHolder holder, final int position) {

        final CameraObjects objects = listCam.get(position);

        holder.textCam.setText(objects.getCamera());

        holder.checkCam.setChecked(objects.isSelected);
        holder.checkCam.setTag(listCam.get(position));

        holder.checkCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraObjects camera1 = (CameraObjects)holder.checkCam.getTag();
                String data ="";

                camera1.setSelected(holder.checkCam.isChecked());

                listCam.get(position).setSelected(holder.checkCam.isChecked());

                for (int j=0; j<listCam.size(); j++){
                    if (listCam.get(j).isSelected == true){
                        data = data.trim()+" "+ listCam.get(j).getCamera().toString().trim();
                        checkCamera = data;
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return listCam.size();
    }

    public static class CamObjectHolder extends RecyclerView.ViewHolder{
        TextView textCam;
        CheckBox checkCam;

        public CamObjectHolder(View itemView){
            super(itemView);

            textCam = itemView.findViewById(R.id.item_cam);
            checkCam = itemView.findViewById(R.id.checkCam);
        }
    }

    public List<CameraObjects> getList() {
        return listCam;
    }
}