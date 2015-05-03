package com.example.mycab;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDetails extends Activity{
	
	EditText t1,t2,t3,t4,t5,t6;
	Button b1,b2;
	SQLiteDatabase db;
	String user,cabservice,cabno,from,to,fare,contactno,phoneno,mail,name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adddetails);
		t1=(EditText) findViewById(R.id.adeditText1);
		t2=(EditText) findViewById(R.id.adeditText2);
		t3=(EditText) findViewById(R.id.adeditText3);
		t4=(EditText) findViewById(R.id.adeditText4);
		t5=(EditText) findViewById(R.id.adeditText5);
		t6=(EditText) findViewById(R.id.adeditText6);
		b1=(Button) findViewById(R.id.adbutton1);
		b2=(Button) findViewById(R.id.adbutton2);
		user=getIntent().getExtras().getString("username");
		phoneno=getIntent().getExtras().getString("phoneno");
		mail=getIntent().getExtras().getString("mail");
		name=getIntent().getExtras().getString("name");
	}
	
	public void addCab(View v)
	{
		cabservice=t1.getText().toString();
		cabno=t2.getText().toString();
		from=t3.getText().toString();
		to=t4.getText().toString();
		fare=t5.getText().toString();
		contactno=t6.getText().toString();
	AlertDialog.Builder ab=new AlertDialog.Builder(AddDetails.this);
			ab.setTitle("Cab details: ");
		//Toast.makeText(AddDetails.this, "+cabservice+", Toast.LENGTH_SHORT).show();
		ab.setMessage("Cabservice: "+cabservice+ "\nCabNo: "+cabno+"\nFrom: "+from+"\nTo: "+to+"\nFare: "+fare+"\nContactNo: "+contactno);
		ab.setCancelable(false);
		ab.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface diaolog, int which) {
				// TODO Auto-generated method stub
				//add intents here
			}
		});
		
		ab.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface diaolog, int which) {
				// TODO Auto-generated method stub
				//add intents here
				db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
				/*
				
				
				String Shivani;
				Shivani="I am Shivani";
				SQLiteDatabase db1;
				db1=openOrCreateDatabase("DatabaseName", MODE_WORLD_WRITEABLE, null);
				db1.execSQL("create table if not exists logindetails (name varchar);");
				db1.execSQL("insert into tablename values(' "+Shivani+"');");
				*/
			
				db.execSQL("insert into cabdetails values('"+user+"','"+cabservice+"','"+cabno+"','"+from+"','"+to+"','"+fare+"','"+contactno+"');");
				Toast.makeText(AddDetails.this, "Sucessfully added", Toast.LENGTH_SHORT).show();
				Intent i1=new Intent(AddDetails.this, CabProviderProfile.class);
				i1.putExtra("username", user);
				i1.putExtra("phoneno", phoneno);
				i1.putExtra("name", name);
				i1.putExtra("mail", mail);
				startActivity(i1);
			}
		});
		
		AlertDialog a=ab.create();
		a.show();
	}
	
	public void goBack(View v)
	{
		Toast.makeText(AddDetails.this, "Going back to your profile", Toast.LENGTH_SHORT).show();
		Intent i2=new Intent(AddDetails.this, CabProviderProfile.class);
		i2.putExtra("username", user);
		i2.putExtra("phoneno", phoneno);
		i2.putExtra("name", name);
		i2.putExtra("mail", mail);
		startActivity(i2);
	}
}
