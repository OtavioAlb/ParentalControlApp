package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinkActivity extends AppCompatActivity {

    TextView pipedaLink;
    TextView coppaLink;
    TextView gdprLink;
    Button btClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        pipedaLink = findViewById(R.id.pipedaLink);
        pipedaLink.setMovementMethod(LinkMovementMethod.getInstance());

        coppaLink = findViewById(R.id.coppaLink);
        coppaLink.setMovementMethod(LinkMovementMethod.getInstance());

        gdprLink = findViewById(R.id.GDPRLink);
        gdprLink.setMovementMethod(LinkMovementMethod.getInstance());

        btClose = findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
