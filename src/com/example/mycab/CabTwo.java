package com.example.mycab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class CabTwo extends Activity{
	
	String pick,dro;
	ExpandableListAdapter a;
	ExpandableListView lv;
	List<String> dHeader;
	HashMap<String, List<String>> dChild;
	
	SQLiteDatabase db;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cabtwo);
		lv=(ExpandableListView) findViewById(R.id.ctexpandableListView1);
		pick=getIntent().getExtras().getString("p");
		dro=getIntent().getExtras().getString("d");
		
		prepareListData();
		a=new com.example.mycab.ExpandableListAdapter(this, dHeader, dChild);
		lv.setAdapter(a);
}
	
	private void prepareListData() {
		// TODO Auto-generated method stub
		dHeader=new ArrayList<String>();
		dChild=new HashMap<String, List<String>>();	
		
		int i=0;
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
		Cursor d=db.rawQuery("select * from cabdetails;", null);
		
		while(d.moveToNext())
		{
			String u=d.getString(3);
			String e=d.getString(4);
			if(u.equalsIgnoreCase(pick) && e.equalsIgnoreCase(dro))
			{
					dHeader.add("Cabname: "+d.getString(1));
			}
		}
			
		Cursor c=db.rawQuery("select * from cabdetails;", null);
		while(c.moveToNext())
		{
			String u=c.getString(3);
			String e=c.getString(4);
			if(u.equalsIgnoreCase(pick) && e.equalsIgnoreCase(dro))
			{
					List<String> v=new ArrayList<String>();
					v.add("Cabno: "+c.getString(2));
					v.add("Pickup Location: "+c.getString(3));
					v.add("Drop Location: "+c.getString(4));
					v.add("Fare: "+c.getString(5));
					v.add("Contact Number: "+c.getString(6));
					dChild.put(dHeader.get(i), v);
					i++;

			}
		}
	}
}
		/*
		while(d.moveToNext())
		{
			String u=d.getString(3);
			String e=d.getString(4);
			if(u.equals(pick) && e.equals(dro))
			{
				dHeader.add("Cabname: "+d.getString(1));
			}
		}
			
		Cursor c=db.rawQuery("select * from cabdetails;", null);
		while(c.moveToNext())
		{
			String u=c.getString(3);
			String e=d.getString(4);
			if(u.equals(pick) && e.equals(dro))
			{
					List<String> v=new ArrayList<String>();
					v.add("Cabno: "+c.getString(2));
					v.add("Pickup Location: "+c.getString(3));
					v.add("Drop Location: "+c.getString(4));
					v.add("Fare: "+c.getString(5));
					v.add("Contact Number: "+c.getString(6));
					dChild.put(dHeader.get(i), v);
					i++;

			}
		}
		*/
	/*
	private void prepareListData() {
		dHeader = new ArrayList<String>();
		dChild = new HashMap<String, List<String>>();

		// Adding child data
		dHeader.add("Top 250");
		dHeader.add("Now Showing");
		dHeader.add("Coming Soon..");

		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("The Shawshank Redemption");
		top250.add("The Godfather");
		top250.add("The Godfather: Part II");
		top250.add("Pulp Fiction");
		top250.add("The Good, the Bad and the Ugly");
		top250.add("The Dark Knight");
		top250.add("12 Angry Men");

		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("The Conjuring");
		nowShowing.add("Despicable Me 2");
		nowShowing.add("Turbo");
		nowShowing.add("Grown Ups 2");
		nowShowing.add("Red 2");
		nowShowing.add("The Wolverine");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("2 Guns");
		comingSoon.add("The Smurfs 2");
		comingSoon.add("The Spectacular Now");
		comingSoon.add("The Canyons");
		comingSoon.add("Europa Report");

		dChild.put(dHeader.get(0), top250); // Header, Child data
		dChild.put(dHeader.get(1), nowShowing);
		dChild.put(dHeader.get(2), comingSoon);
	}
	}
	*/



