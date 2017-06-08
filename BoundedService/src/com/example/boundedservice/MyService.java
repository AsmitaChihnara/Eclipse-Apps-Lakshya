package com.example.boundedservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service{
	IBinder mBinder=new LocalBinder();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	public class LocalBinder extends Binder{
		public MyService getServerInstance(){
			return MyService.this;
		}
	}
	@SuppressLint("SimpleDateFormat") public String getTime(){
		SimpleDateFormat mDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return mDateFormat.format(new Date());
		
	}
}
