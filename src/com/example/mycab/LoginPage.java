package com.example.mycab;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity{
	EditText t1,t2;
	Button b;
	String user,pass;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);
		t1=(EditText) findViewById(R.id.lpeditText1);
		t2=(EditText) findViewById(R.id.lpeditText2);
		b=(Button) findViewById(R.id.lpbutton1);
	}
	
	public void clickLogin(View v)
	{
		String u,p,ph,n,m,phone;
		int key=0;
		user=t1.getText().toString();
		pass=t2.getText().toString();
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
		Cursor c=db.rawQuery("select * from logindetails;", null);
		while(c.moveToNext())
		{
			u=c.getString(3);
			p=c.getString(4);
			ph=c.getString(2);
			n=c.getString(0);
			m=c.getString(1);
			if(u.equals(user) && p.equals(pass))
			{
				Toast.makeText(LoginPage.this, "Done", Toast.LENGTH_SHORT).show();
				key=1;
				Intent i2=new Intent(LoginPage.this, CabProviderProfile.class);
				i2.putExtra("username", user);
				i2.putExtra("phoneno", ph);
				i2.putExtra("name", n);
				i2.putExtra("mail", m);
				startActivity(i2);
			}
		}
		
		if(key==0)
		{
			Toast.makeText(LoginPage.this, "Login failed!", Toast.LENGTH_SHORT).show();
		}
	}
}
