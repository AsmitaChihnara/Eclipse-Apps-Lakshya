package com.example.contacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class EditActivity extends Activity implements OnClickListener{

	EditText et1,et2,et3,et4;
	Button btn1,btn2;
	SQLiteDatabase sd;
	int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		btn1=(Button)findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		btn2=(Button)findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		try{
		Bundle ob=getIntent().getExtras();
		id=Integer.parseInt(ob.getString("id"));
		
		sd=openOrCreateDatabase("contacts", MODE_PRIVATE, null);
		
		Cursor cur=sd.rawQuery("select * from contact_info where contactid="+id, null);
		
	
			cur.moveToFirst();
			et1.setText(cur.getString(1));
			et2.setText(cur.getString(2));
			et3.setText(cur.getString(3));
			et4.setText(cur.getString(4));
		cur.close();
	}catch(Exception e){
		Toast.makeText(this, "Error :"+e, Toast.LENGTH_LONG).show();
	}
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1){
			String name=et1.getText().toString();
			String contact=et2.getText().toString();
			String email=et3.getText().toString();
			String address=et4.getText().toString();
			
			sd.execSQL("update table contact_info set name='"+name+"',contact_no='"+contact+"',emailid='"+email+"',address='"+address+"' where contactid="+id);
			Toast.makeText(this, "Successfully Updated", Toast.LENGTH_LONG).show();
			finish();
		}else{
			sd.execSQL("delete from contact_info where contactid="+id);
			Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_LONG).show();
			finish();
		}
		Intent i=new Intent(this,ViewActivity.class);
		startActivity(i);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}

}
