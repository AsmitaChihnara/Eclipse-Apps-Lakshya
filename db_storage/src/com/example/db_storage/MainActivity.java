package com.example.db_storage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	EditText et1,et2;
	Button btn1,btn2;
	SQLiteDatabase sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);	
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        sd=openOrCreateDatabase("eveandroid", MODE_PRIVATE, null);
        sd.execSQL("create table if not exists contact_info(name varchar(30),contact_no varchar(10))");
        
    }

    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	if(v.getId()==R.id.button1){
    		String name=et1.getText().toString();
    		String contact_no=et2.getText().toString();
    		sd.execSQL("insert into contact_info values('"+name+"','"+contact_no+"')");
    		Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show();
    	}else{
    		Intent i=new Intent(this,DisplayActivity.class);
    		startActivity(i);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
