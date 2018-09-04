package com.smkfadilah.hitungdiagram;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;


public class MainActivity extends Activity 
{
	private Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void Diagram_persen(View view)
	{
		intent.setClass(getApplicationContext(), persen.class);
		startActivity(intent);
	}
	
	public void Diagram_kuadrat(View view)
	{
		intent.setClass(getApplicationContext(), derajat.class);
		startActivity(intent);
	}
	
	public void Diagram_angka(View view)
	{

	}
}
