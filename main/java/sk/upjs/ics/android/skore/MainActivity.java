package sk.upjs.ics.android.skore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button red;
    private Button blue;
    private int blueP;
    private int redP;
    //ijij
    private Animation scaleUp;

    //TODO -- create anim res, scale_up anim file. Thats all :)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        setContentView(R.layout.activity_main);
        red = (Button)findViewById(R.id.red);
        blue = (Button)findViewById(R.id.blue);
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        blue.setHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        red.setHeight(displayMetrics.heightPixels);


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red.startAnimation(scaleUp);
                redP++;
                red.setText(redP+"");
                if (redP>=21 && blueP<=redP-2){
                    setZeroPoint();
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blue.startAnimation(scaleUp);
                blueP++;
                blue.setText(blueP+"");
                if (blueP>=21&&redP<=blueP-2){
                    setZeroPoint();
                }
            }
        });
    }

    public void setZeroPoint(){
        redP=0;
        red.setText(redP+"");
        blueP=0;
        blue.setText(blueP+"");
    }
}
