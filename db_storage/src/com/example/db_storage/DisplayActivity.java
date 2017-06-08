package com.example.db_storage;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayActivity extends Activity {

	ListView lv;
	SQLiteDatabase sd;
	ArrayList<String> al;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		lv=(ListView)findViewById(R.id.listView1);
		sd=openOrCreateDatabase("eveandroid", MODE_PRIVATE, null);
		al=new ArrayList<String>();
		Cursor cur=sd.rawQuery("select * from contact_info", null);
		if(cur.getCount()>0){
			cur.moveToFirst();
			while(cur.isAfterLast()==false){
				String name=cur.getString(0);
				String contact_no=cur.getString(1);
				al.add(name+"\n"+contact_no);
				cur.moveToNext();
				
			}
			cur.close();
		}else{
			al.add("Record not found");
			
		}
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
		lv.setAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

}
