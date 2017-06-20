package com.mcstudio.autolinestextview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Rect mRect = new Rect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.tv);

        tv.post(new Runnable() {
            @Override
            public void run() {
                autoLines(tv);
            }
        });

    }

    public void autoLines(TextView tv) {

        tv.getLineBounds(0, mRect);
        int requiredSize = mRect.height() * 2;
        Log.d("mingchun", "requiredSize " + requiredSize);

        Log.d("mingchun", "tv.getHeight() " + tv.getHeight());
        Log.d("mingchun", "tv.getCompoundDrawables()[1].getBounds().height() " + tv.getCompoundDrawables()[1].getBounds().height());
        Log.d("mingchun", "tv.getCompoundDrawablePadding() " + tv.getCompoundDrawablePadding());

        if (tv.getHeight() - tv.getCompoundDrawables()[1].getBounds().height() - tv.getCompoundDrawablePadding() < requiredSize) {
            Log.d("mingchun", "*** setSingleLine true ***");
            tv.setSingleLine(true);
        } else {
            Log.d("mingchun", "*** setSingleLine false ***");
            tv.setSingleLine(false);
        }
    }

    public void increase(View view) {
        final TextView tv = (TextView) findViewById(R.id.tv);
        tv.post(new Runnable() {
            @Override
            public void run() {

                Log.d("mingchun", "tv.getHeight() " + tv.getHeight());

                ViewGroup.LayoutParams params = tv.getLayoutParams();
                params.height = tv.getHeight() + 2;
                tv.setLayoutParams(params);

                autoLines(tv);
            }
        });
    }

    public void decrease(View view) {
        final TextView tv = (TextView) findViewById(R.id.tv);
        tv.post(new Runnable() {
            @Override
            public void run() {

                Log.d("mingchun", "tv.getHeight() " + tv.getHeight());

                ViewGroup.LayoutParams params = tv.getLayoutParams();
                params.height = tv.getHeight() - 2;
                tv.setLayoutParams(params);

                autoLines(tv);
            }
        });

    }

}
