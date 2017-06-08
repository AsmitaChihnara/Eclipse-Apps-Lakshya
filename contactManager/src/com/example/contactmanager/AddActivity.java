package com.example.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity implements OnClickListener{
	EditText et1,et2,et3,et4;
	Button btn;
	SQLiteDatabase sd;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
		sd=openOrCreateDatabase("asmita", MODE_PRIVATE, null);
		sd.execSQL("create table contact_info(contactid integer primary key autoincrement,name varchar(30),contact_no varchar(10),emailid varchar(45),address varchar(100))");

		
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String name=et1.getText().toString();
		String contact=et2.getText().toString();
		String email=et3.getText().toString();
		String address=et4.getText().toString();
		
		
		sd.execSQL("insert into contact_info(name,contact_no,emailid,address) values('"+name+"','"+contact+"','"+email+"','"+address+"')");
		Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}

}
