package kr.ac.kopo.preferencevoting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("콘 선호도 투표");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int voteCount[] = new int[9];
        for (int i =0; i < voteCount.length;i++)
        {
            voteCount[i]= 0;
        }

        ImageView imgv[] = new ImageView[9];
        int imgvId[] = {R.id.img_01,R.id.img_02,R.id.img_03,
                R.id.img_04,R.id.img_05,R.id.img_06,
                R.id.img_07,R.id.img_08,R.id.img_09,
        };
        final String imgName[] = {"기웃","몰라","아니","진짜","맞아","죽어","키메라","풀가동","꼬륵븜"};

        for (int i =0; i < imgv.length; i++)
        {
            final int index;
            index = i;
            imgv[index] = findViewById(imgvId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+": 총 "+voteCount[index]+" 표",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}