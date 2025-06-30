package kr.ac.kopo.preferencevoting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgName = intent.getStringArrayExtra("imgName");

        TextView[] tv = new TextView[imgName.length];
        RatingBar[] rb = new RatingBar[imgName.length];

        int[] tvId = {R.id.textView_01,R.id.textView_02,R.id.textView_03,
                R.id.textView_04,R.id.textView_05,R.id.textView_06,
                R.id.textView_07,R.id.textView_08,R.id.textView_09};
        int[] rbId = {R.id.rating_01,R.id.rating_02,R.id.rating_03,
                R.id.rating_04,R.id.rating_05,R.id.rating_06,
                R.id.rating_07,R.id.rating_08,R.id.rating_09};

        for (int i =0; i< imgName.length; i++)
        {
            tv[i] = findViewById(tvId[i]);
            rb[i] = findViewById(rbId[i]);
        }
        for (int i =0; i< imgName.length; i++)
        {
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}