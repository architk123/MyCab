package com.example.mycab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CabProvider extends Activity{

	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cabprovider);
		b1=(Button) findViewById(R.id.cpbutton2);
		b2=(Button) findViewById(R.id.cpbutton1);
	}
	
	public void register(View v)
	{
		Intent i1=new Intent(CabProvider.this, RegisterPage.class);
		startActivity(i1);
	}
	
	public void login(View v)
	{
		Intent i2=new Intent(CabProvider.this, LoginPage.class);
		startActivity(i2);
	}
}
