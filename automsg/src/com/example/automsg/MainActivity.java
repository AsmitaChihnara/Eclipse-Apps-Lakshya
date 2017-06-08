package com.example.automsg;







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

	Button btn1,btn2;
	EditText et1,et2,et3;
	SQLiteDatabase sd;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		
		sd=openOrCreateDatabase("message", MODE_PRIVATE, null);
		sd.execSQL("create table if not exists message_info(id integer primary key autoincrement,mobileno varchar(10),incoming_text varchar(30),outgoing_text varchar(30))");
    }

    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	String number=et1.getText().toString();
		String intext=et2.getText().toString();
		String outtext=et3.getText().toString();
		if(v.getId()==R.id.button1){
			sd.execSQL("insert into message_info(mobileno,incoming_text,outgoing_text) values('"+number+"','"+intext+"','"+outtext+"')");
			Toast.makeText(this, "Successfully Saved", Toast.LENGTH_LONG).show();
			
		}
		else{
			Intent i=new Intent(this,SecondActivity.class);
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
