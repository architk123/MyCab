package com.example.mycab;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CabProviderProfile extends Activity{
	TextView t1,t2,t3,t4;
	Button b1,b2,b3;
	String username,name,mail,phoneno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cabproviderprofile);
		t1=(TextView) findViewById(R.id.cbptextView2);
		t2=(TextView) findViewById(R.id.cbptextView3);
		t3=(TextView) findViewById(R.id.cbptextView4);
		t4=(TextView) findViewById(R.id.cbptextView5);
		b1=(Button) findViewById(R.id.cbppbutton1);
		b2=(Button) findViewById(R.id.cbpbutton2);
		b3=(Button) findViewById(R.id.cbpbutton3);
		username=getIntent().getExtras().getString("username");
		name=getIntent().getExtras().getString("name");
		mail=getIntent().getExtras().getString("mail");
		phoneno=getIntent().getExtras().getString("phoneno");
		t1.setText(name);
		t2.setText("Phone number: "+phoneno);
		t4.setText("E-mail id: "+mail);
		t3.setText("Username: "+username);
		
	}
	
	public void logout(View v)
	{
		Intent i1=new Intent(CabProviderProfile.this, MainActivity.class);
		startActivity(i1);
	}
	
	public void addDetail(View v)
	{
		Intent i2=new Intent(CabProviderProfile.this, AddDetails.class);
		i2.putExtra("username", username);
		i2.putExtra("phoneno", phoneno);
		i2.putExtra("name", name);
		i2.putExtra("mail", mail);
		startActivity(i2);
	}
	
	public void viewDetail(View v)
	{
		SQLiteDatabase db;
		int count=0;
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);

		
		Cursor c=db.rawQuery("select * from cabdetails;", null);

		while(c.moveToNext())
		{
			String u=c.getString(0);
			if(u.equals(username))
			{
				count++;
			}
		}
		
		if(count==0)
		{
			//Toast.makeText(CabProviderProfile.this, "No details to show! Fill details first", Toast.LENGTH_SHORT).show();
			AlertDialog.Builder ab=new AlertDialog.Builder(CabProviderProfile.this);
		    ab.setMessage("Fill details first");
		    ab.setIcon(R.drawable.ic_launcher);
		ab.setCancelable(false);
		ab.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface diaolog, int which) {
				// TODO Auto-generated method stub
				//add intents here
			}
		});
		AlertDialog a=ab.create();
		a.show();
		}
		else if(count!=0)
		{
			Intent i3=new Intent(CabProviderProfile.this, ViewDetails.class);
			i3.putExtra("username", username);
			i3.putExtra("phoneno", phoneno);
			i3.putExtra("name", name);
			i3.putExtra("mail", mail);
			startActivity(i3);
		}
	}
}








                             
