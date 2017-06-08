package com.example.dialer;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	EditText et;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(this);
        et=(EditText)findViewById(R.id.editText1);
    }

	 @Override
	    public void onClick(View arg0){
		 String number=et.getText().toString();
	    	Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number));
	    	startActivity(i);
	    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
