package com.example.mycab;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CabOne extends Activity{
	
	EditText t1,t2;
	String pickup;
	String drop;
	Button b;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cabone);
		t1= (EditText) findViewById(R.id.coeditText1);
		t2=(EditText) findViewById(R.id.coeditText2);
		b=(Button) findViewById(R.id.cobutton1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pickup=t1.getText().toString();
				drop=t2.getText().toString();
				
				SQLiteDatabase db;
				int count=0;
				db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);

				
				Cursor c=db.rawQuery("select * from cabdetails;", null);

				while(c.moveToNext())
				{
					String u=c.getString(3);
					String d=c.getString(4);
					if(u.equalsIgnoreCase(pickup) && d.equalsIgnoreCase(drop))
					{
						count++;
					}
				}
				
				if(count==0)
				{
					//Toast.makeText(CabProviderProfile.this, "No details to show! Fill details first", Toast.LENGTH_SHORT).show();
					AlertDialog.Builder ab=new AlertDialog.Builder(CabOne.this);
				    ab.setMessage("No cabs found on this route!");
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
					Intent i=new Intent(CabOne.this, CabTwo.class);
					i.putExtra("p", pickup);
					i.putExtra("d", drop);
					startActivity(i);	
				}
			}
		});
	}
}
