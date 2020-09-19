package tw.org.tcca.apps.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMyIP();
    }

    private void getMyIP(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Log.v("bradlog", ip);
                } catch (UnknownHostException e) {
                    Log.v("bradlog", e.toString());
                }

            }
        }.start();
    }

}