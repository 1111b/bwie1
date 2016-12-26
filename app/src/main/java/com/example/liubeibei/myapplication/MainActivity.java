package com.example.liubeibei.myapplication;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;
        import org.greenrobot.eventbus.EventBus;
        import org.greenrobot.eventbus.Subscribe;
        import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

    private TextView text;
    int sa;
    private String  n = "我添加了数据";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        text  =  (TextView) findViewById(R.id.name);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OneActivity.class);
                startActivity(intent);

            }
        });

    }


   @Subscribe(threadMode = ThreadMode.MAIN)
    public void str(String  name){
        text.setText(name);
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
