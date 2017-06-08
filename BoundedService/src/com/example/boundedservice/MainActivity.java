package com.example.boundedservice;

import com.example.boundedservice.MyService.LocalBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	

	TextView tv;
	Button btn;
	boolean mBounded;
	MyService ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView1);
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		tv.setText(ms.getTime());
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Intent mIntent=new Intent(this,MyService.class);
		bindService(mIntent, mConnection, BIND_AUTO_CREATE);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if(mBounded){
			unbindService(mConnection);
			mBounded=false;
		}
	}
    
	ServiceConnection mConnection=new ServiceConnection() {
		
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "Service is disconnected", Toast.LENGTH_LONG).show();
			mBounded=false;
			ms=null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "Service is connected", Toast.LENGTH_LONG).show();
			mBounded=true;
			LocalBinder mLocalBinder=(LocalBinder)service;
			ms=mLocalBinder.getServerInstance();
		}
	};
}
