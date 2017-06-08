package com.example.arith;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=(Button)findViewById(R.id.button1);
        Button btn2=(Button)findViewById(R.id.button2);
        Button btn3=(Button)findViewById(R.id.button3);
        Button btn4=(Button)findViewById(R.id.button4);
        
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onClick(View v)
    {
    	String num1=et1.getText().toString();
    	String num2=et2.getText().toString();
    	int n1=Integer.parseInt(num1);
    	int n2=Integer.parseInt(num2);
    	
    	if(v.getId()==R.id.button1){
    		Toast t=Toast.makeText(this,"Sum: "+(n1+n2), Toast.LENGTH_LONG);
        	t.show();
    	}else if(v.getId()==R.id.button2){
    		Toast t=Toast.makeText(this,"Sub: "+(n1-n2), Toast.LENGTH_LONG);
        	t.show();
    	}else if(v.getId()==R.id.button3){
    		Toast t=Toast.makeText(this,"Mult: "+(n1*n2), Toast.LENGTH_LONG);
        	t.show();
    	}else{
    		Toast t=Toast.makeText(this,"Div: "+(n1/n2), Toast.LENGTH_LONG);
        	t.show();
    	}
    }
    
}
