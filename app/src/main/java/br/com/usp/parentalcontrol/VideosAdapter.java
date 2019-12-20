package br.com.usp.parentalcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {

    List<Videos> videosList;

    public VideosAdapter() {
    }

    public VideosAdapter(List<Videos> videosList) {
        this.videosList = videosList;
    }

    @Override
    public VideoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view, parent, false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder( VideoViewHolder holder, int position) {

        holder.videoWeb.loadData(videosList.get(position).getVideoUrl(), "text/html", "utf-8");

    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }



    public class VideoViewHolder extends RecyclerView.ViewHolder {

        WebView videoWeb;

        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.webView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());

        }
    }
}
