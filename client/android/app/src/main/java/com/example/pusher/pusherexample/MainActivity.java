package com.example.pusher.pusherexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pusher.client.PusherOptions;
import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

public class MainActivity extends AppCompatActivity {

    private int num =1;
    private TextView t = null;
    private Channel channel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("on create!");
        this.t=(TextView)findViewById(R.id.text01);
        this.t.setText("on create!");

        PusherOptions options = new PusherOptions();
        options.setCluster("ap1");
        Pusher pusher = new Pusher("212650b24b67f75e3db6", options);

        this.channel = pusher.subscribe("my-channel");

        this.channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                System.out.println(data);
                //this.t.setText("on create!"+this.num++);
                Toast toast = Toast.makeText(getApplicationContext(),data, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        this.toast("connect!");
        pusher.connect();
    }

    public void toast(String string){

        Toast toast = Toast.makeText(getApplicationContext(),string, Toast.LENGTH_LONG);
        toast.show();
    }
}
