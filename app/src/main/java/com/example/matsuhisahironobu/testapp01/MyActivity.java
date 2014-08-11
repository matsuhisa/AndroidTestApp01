package com.example.matsuhisahironobu.testapp01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.matsuhisahironobu.testapp01.R.id.circleview1;


public class MyActivity extends Activity  implements Runnable, View.OnClickListener{

    private static final long TIMER_PERIOD = 50;
    private Timer mTimer;

    public final class MyTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            MyActivity.this.runOnUiThread(MyActivity.this);
        }
    }



    private boolean mMoving;

    @Override
    public void run()
    {
        CircleView circleView1 = (CircleView) findViewById(R.id.circleview1);
        //CircleView circleView1 = (CircleView) findViewById(circleview1);

        if(mMoving)
        {
            circleView1.setX(circleView1.getX() + 1);
            circleView1.setY(circleView1.getY() + 1);
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.circleview1:
                // 円がタップされたときの動作
                mMoving = false;
                TouchDialog dialog = new TouchDialog();
                dialog.show(getFragmentManager(), "");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mTimer = new Timer(true);
        mTimer.schedule(new MyTimerTask(),TIMER_PERIOD, TIMER_PERIOD);
    }

    @Override
    protected  void onPause()
    {
        super.onPause();
        mTimer.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mMoving = true;

        //CircleView circleView1 = (CircleView) findViewById(R.id.circleView1);
        CircleView circleView1 = (CircleView) findViewById(R.id.circleview1);
        // イベントハンドラ
        circleView1.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
