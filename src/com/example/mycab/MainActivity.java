package com.example.mycab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	SQLiteDatabase db;
	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
		db.execSQL("create table if not exists logindetails (name varchar,mail varchar, phoneno varchar, username varchar, password varchar);");
		db.execSQL("create table if not exists cabdetails (user varchar, cabservice varchar, cabno varchar, fromloc varchar, toloc varchar, fare varchar, contactno varchar);");
	}
	
	public void functionOne(View v)
	{
		Intent i1=new Intent(MainActivity.this, CabProvider.class);
		startActivity(i1);
	}
	
	public void functionTwo(View v)
	{
		Intent i2=new Intent(MainActivity.this, CabOne.class);
		startActivity(i2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
