package com.example.contactmanager;

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
	ArrayList<String> contact;
	SQLiteDatabase sd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		et=(EditText)findViewById(R.id.editText1);
		btn=(Button)findViewById(R.id.button1);
		lv=(ListView)findViewById(R.id.listView1);
		btn.setOnClickListener(this);
		contact=new ArrayList<String>();
		sd=openOrCreateDatabase("asmita", MODE_PRIVATE, null);
		Cursor cur=sd.rawQuery("select id,name from contact_info order by name", null);
		if(cur.getCount()>0){
			cur.moveToFirst();
			while(cur.isAfterLast()==false){
				String id=cur.getString(0);
			String name=cur.getString(1);
			contact.add(name+"/n"+id);
			cur.moveToNext();
		}
		cur.close();
		}else{
			contact.add("No record found.");
		}
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contact);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		// TODO Auto-generated method stub
		String name=contact.get(pos);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String search=et.getText().toString();
		Cursor cur=sd.rawQuery("select name from contact_info ", null);
	}

}
