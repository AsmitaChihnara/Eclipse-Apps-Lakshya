package com.example.contacts;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ViewActivity extends Activity implements  OnClickListener,OnItemClickListener{
	EditText et;
	Button btn;
	ListView lv;
	ArrayList<String> al;
	ArrayList<String> alc;
	SQLiteDatabase sd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		et=(EditText)findViewById(R.id.editText1);
		btn=(Button)findViewById(R.id.button1);
		lv=(ListView)findViewById(R.id.listView1);
		btn.setOnClickListener(this);
		al=new ArrayList<String>();
		alc=new ArrayList<String>();
		sd=openOrCreateDatabase("contacts", MODE_PRIVATE, null);
		Cursor cur=sd.rawQuery("select contactid,name from contact_info order by name", null);
		if(cur.getCount()>0){
			cur.moveToFirst();
			while(cur.isAfterLast()==false){
				String id=cur.getString(0);
			String name=cur.getString(1);
			al.add(name);
			alc.add(id);
			cur.moveToNext();
		}
		cur.close();
		}else{
			al.add("No record found.");
		}
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		try{
		String id=alc.get(arg2);
		
		Intent i=new Intent(this,EditActivity.class);
		i.putExtra("id", id);
		finish();
		startActivity(i);
		}catch(Exception e){
			Toast.makeText(this, "Error: "+e, Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String search=et.getText().toString();
		try{
			al.clear();
			alc.clear();
			
			Cursor cur=sd.rawQuery("select contactid,name from contact_info where name like '"+search+"%'", null);
			if(cur.getCount()>0){
				cur.moveToFirst();
				while(cur.isAfterLast()==false){
					String id=cur.getString(0);
				String name=cur.getString(1);
				al.add(name);
				alc.add(id);
				cur.moveToNext();
			}
			cur.close();
			}else{
				al.add("Record not found");
			}
			ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
			lv.setAdapter(aa);
		}catch(Exception e){
			Toast.makeText(this, "Error :"+e, Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);
		return true;
	}
	

}
