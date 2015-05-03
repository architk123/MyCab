package com.example.mycab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class ViewDetails extends Activity {
	
	String username,phoneno,mail,name;
	ExpandableListAdapter a;
	ExpandableListView lv;
	List<String> dataHeader;
	HashMap<String, List<String>> dataChild;
	
	SQLiteDatabase db;
	//ListView lv;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewdetails);
		lv=(ExpandableListView) findViewById(R.id.expandableListView1);
		username=getIntent().getExtras().getString("username");
		phoneno=getIntent().getExtras().getString("phoneno");
		mail=getIntent().getExtras().getString("mail");
		name=getIntent().getExtras().getString("name");
		
		prepareListData();
		a=new com.example.mycab.ExpandableListAdapter(this, dataHeader, dataChild);
		lv.setAdapter(a);
		/*
		a = new ExpandableListAdapter() {
			
			@Override
			public void unregisterDataSetObserver(DataSetObserver arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerDataSetObserver(DataSetObserver arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGroupExpanded(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGroupCollapsed(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isChildSelectable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getGroupId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getGroup(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getCombinedGroupId(long arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getCombinedChildId(long arg0, long arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getChildrenCount(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
					ViewGroup arg4) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getChildId(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getChild(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean areAllItemsEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		*/
		/*
		ArrayList l=new ArrayList ();
		Cursor d=db.rawQuery("select * from cabdetails;", null);
		while(d.moveToNext())
		{
			String u=d.getString(0);
			if(u.equals(username))
			{
				l.add("Cabservice: "+d.getString(1)+" \nCabno: "+d.getString(2)+" \nFrom: "+d.getString(3)+"\nTo: "+d.getString(4)+"\nFare: "+d.getString(5)+"\nContact No: "+d.getString(6));
				l.add("\n");
			}
		}
		ArrayAdapter a=new ArrayAdapter (getBaseContext(), android.R.layout.simple_dropdown_item_1line, l);
		lv.setAdapter(a);
	}
	*/
		}
	
	private void prepareListData() {
		// TODO Auto-generated method stub
		dataHeader=new ArrayList<String>();
		dataChild=new HashMap<String, List<String>>();	
		
		int i=0;
		db=openOrCreateDatabase("dbRegister", MODE_WORLD_WRITEABLE, null);
		Cursor d=db.rawQuery("select * from cabdetails;", null);
		while(d.moveToNext())
		{
			String u=d.getString(0);
			if(u.equals(username))
			{
				dataHeader.add("Cabname: "+d.getString(1));
			}
		}
			
		Cursor c=db.rawQuery("select * from cabdetails;", null);
		while(c.moveToNext())
		{
			String u=c.getString(0);
			if(u.equals(username))
			{
					List<String> v=new ArrayList<String>();
					v.add("Cabno: "+c.getString(2));
					v.add("Pickup Location: "+c.getString(3));
					v.add("Drop Location: "+c.getString(4));
					v.add("Fare: "+c.getString(5));
					v.add("Contact Number: "+c.getString(6));
					dataChild.put(dataHeader.get(i), v);
					i++;

			}
		}
	}
}
