package org.pursuit.implicit_intents_app_from_scratch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView sign;
    private TextView dateRange;
    private Button button;
    private static final String ADDRESS = "";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();


        String imageUrl = intent.getStringExtra("image");
        final String zodiacName = intent.getStringExtra("name");
        String dateRange = intent.getStringExtra("date");

        sign.setText(zodiacName);
        Picasso.get()
                .load(imageUrl)
                .into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(ADDRESS + zodiacName + ".html");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);
            }
        });


    }
}
