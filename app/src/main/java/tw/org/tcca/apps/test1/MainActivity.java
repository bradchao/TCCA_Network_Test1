package tw.org.tcca.apps.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import static java.net.NetworkInterface.getNetworkInterfaces;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMyIPV2();
    }

    private void getMyIP(){
        new Thread(){
            @Override
            public void run() {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Log.v("bradlog", ip);
                } catch (UnknownHostException e) {
                    Log.v("bradlog", e.toString());
                }

            }
        }.start();
    }

    private void getMyIPV2(){
        new Thread(){
            @Override
            public void run() {
                try {
                    Enumeration<NetworkInterface> ifs =  NetworkInterface.getNetworkInterfaces();
                    while (ifs.hasMoreElements()){
                        NetworkInterface iff = ifs.nextElement();
                        Enumeration<InetAddress> ips =  iff.getInetAddresses();
                        while (ips.hasMoreElements()){
                            InetAddress ip = ips.nextElement();
                            Log.v("bradlog", ip.getHostAddress());
                        }
                    }
                } catch (SocketException e) {
                    Log.v("bradlog", e.toString());
                }
            }
        }.start();
    }

}