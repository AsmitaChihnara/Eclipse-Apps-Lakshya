package com.example.audiomanager;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	Button btn1,btn2,btn3,btn4;
	AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        		
        
    }


    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	if(v.getId()==R.id.button1){
    		int mode=am.getRingerMode();
    		if(mode==0){
    			Toast.makeText(this, "Silent Mode", Toast.LENGTH_LONG).show();
    		}else if(mode==1){
    			Toast.makeText(this, "Vibration Mode", Toast.LENGTH_LONG).show();
    		}else{
    			Toast.makeText(this, "Ringing Mode", Toast.LENGTH_LONG).show();
    		}
    	}else if(v.getId()==R.id.button2){
    		am.setRingerMode(0);
    	}else if(v.getId()==R.id.button3){
    		am.setRingerMode(1);
    	}else{
    		am.setRingerMode(2);
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
