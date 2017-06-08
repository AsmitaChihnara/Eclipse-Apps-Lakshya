package com.example.broadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WifiBroadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Wifi state changed", Toast.LENGTH_LONG).show();
	}
}

