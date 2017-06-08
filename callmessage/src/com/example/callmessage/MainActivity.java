package com.example.callmessage;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener{

	EditText et;
	Button btn1,btn2,btn3;
	ListView lv;
	SQLiteDatabase sd;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        
        et=(EditText)findViewById(R.id.editText1);
        lv=(ListView)findViewById(R.id.listView1);
        
        sd=openOrCreateDatabase("sms",MODE_PRIVATE, null);
        sd.execSQL("create table if not exists saved_msg(id integer primary key autoincrement,msg varchar(100) not null)");
        		
        		
    }

    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	if(v.getId()==R.id.button1){
    		String msg=et.getText().toString();
    		sd.execSQL("insert into saved_msg(msg) values('"+msg+"')");
    		Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_LONG).show();
    	}else if(v.getId()==R.id.button2){
    		String text=et.getText().toString();
    		sd.execSQL("delete from saved_msg where msg='"+text+"'");
    		Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_LONG).show();
    	}else{
    		String text=et.getText().toString();
    		
    	}
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    	// TODO Auto-generated method stub
    	
    }
   
    
}
