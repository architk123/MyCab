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

public class RegisterPage extends Activity{
	
	EditText t1,t2,t3,t4,t5;
	Button b1;
	SQLiteDatabase db;
	String user,pass,name,mail,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registerpage);
		t1=(EditText) findViewById(R.id.rpeditText1);
		t2=(EditText) findViewById(R.id.rpeditText2);
		t3=(EditText) findViewById(R.id.rpeditText3);
		t4=(EditText) findViewById(R.id.rpeditText4);
		t5=(EditText) findViewById(R.id.rpeditText5);
		b1=(Button) findViewById(R.id.rpbutton1);
		
	}
	
	public void registerName(View v)
	{
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
		int key=0;
		name=t1.getText().toString();
		mail=t2.getText().toString();
		phone=t3.getText().toString();
		user=t4.getText().toString();
		pass=t5.getText().toString();
		Cursor c=db.rawQuery("select * from logindetails;", null);
		while(c.moveToNext())
		{
			String u=c.getString(3);
			if(u.equals(user))
			{
				key=1;
				break;
			}
		}
		if(key==0)
		{
			db.execSQL("insert into logindetails values('"+name+"','"+mail+"','"+phone+"','"+user+"','"+pass+"');");
			Toast.makeText(RegisterPage.this, "Successfully signed up!", Toast.LENGTH_SHORT).show();
			Intent i1=new Intent(RegisterPage.this, CabProviderProfile.class);
			i1.putExtra("username", user);
			i1.putExtra("name", name);
			i1.putExtra("mail", mail);
			i1.putExtra("phoneno", phone);
			startActivity(i1);
		}
		else
		{
			Toast.makeText(RegisterPage.this, "Username already exists!", Toast.LENGTH_LONG).show();
		}
		
		
	}
}
