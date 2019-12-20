package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Vector;

public class GuideActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<Videos> videos = new Vector<>();

    Button btClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        recyclerView = findViewById(R.id.recyclerVideo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        videos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FmCeO3LrIEs\" frameborder=\"0\" allowfullscreen></iframe>"));
        videos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/v2JUaKn9Apk\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideosAdapter videosAdapter = new VideosAdapter(videos);
        recyclerView.setAdapter(videosAdapter);

        btClose = findViewById(R.id.closeBt);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
