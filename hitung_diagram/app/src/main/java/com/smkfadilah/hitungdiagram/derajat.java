package com.smkfadilah.hitungdiagram;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import android.transition.*;

import java.util.*;

public class derajat extends Activity
{
	private Intent intent = new Intent();
	EditText persen1,persen2,persen3,persen4,persen5,hasil,td1,td2,td3;
	int per1,per2,per3,per4,per5,data1,data2,data3;
	CheckBox test;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.derajat);

		td1 = (EditText) findViewById(R.id.tmbh_data1);
		td2 = (EditText) findViewById(R.id.tmbh_data2);
		td3 = (EditText) findViewById(R.id.total);
		persen1 = (EditText) findViewById(R.id.persen1);
		persen2 = (EditText) findViewById(R.id.persen2);
		persen3 = (EditText) findViewById(R.id.persen3);
		persen4 = (EditText) findViewById(R.id.persen4);
		persen5 = (EditText) findViewById(R.id.persen5);
		hasil = (EditText) findViewById(R.id.hasil);
		test  = (CheckBox) findViewById(R.id.add_data);

    }

	public void add(View view)
	{
		EditText et1 = (EditText) findViewById(R.id.tmbh_data1);
		EditText et2 = (EditText) findViewById(R.id.tmbh_data2);
		EditText et3 = (EditText) findViewById(R.id.total);
		CheckBox cb1 = (CheckBox) findViewById(R.id.add_data);

		if (cb1.isChecked())
		{
			et1.setVisibility(View.VISIBLE);
			et2.setVisibility(View.VISIBLE);
			et3.setVisibility(View.GONE);

		}
		else
		{
			et1.setVisibility(View.GONE);
			et2.setVisibility(View.GONE);
			et3.setVisibility(View.VISIBLE);
		}
	}

	public void back(View view)
	{
		intent.setClass(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}

	public void check()
	{

		if ("".equals(persen1.getText().toString()))
		{
			persen1.setText("0");
		}
		if ("".equals(persen2.getText().toString()))
		{
			persen2.setText("0");
		}
		if ("".equals(persen3.getText().toString()))
		{
			persen3.setText("0");
		}
		if ("".equals(persen4.getText().toString()))
		{
			persen4.setText("0");
		}
		if ("".equals(persen5.getText().toString()))
		{
			persen5.setText("0");
		}
	}

	public void ambil()
	{

		per1 = Integer.parseInt(persen1.getText().toString());
		per2 = Integer.parseInt(persen2.getText().toString());
		per3 = Integer.parseInt(persen3.getText().toString());
		per4 = Integer.parseInt(persen4.getText().toString());
		per5 = Integer.parseInt(persen5.getText().toString());

		//data2 = Integer.parseInt(td2.getText().toString());

	}

	public void hitung_persen(View view)
	{
		check();
		ambil();

		try
		{


			if (test.isChecked())
			{
				data1 = Integer.parseInt(td1.getText().toString());
				data2 = Integer.parseInt(td2.getText().toString());

				int hitung = per1 + per2 + per3 + per4 + per5;
				int hitung1 = 360 - hitung;
				int hitung2 = ((data2 * hitung1) / data1);
				String mulai = String.format("x = 360 - (%01d + %01d + %01d + %01d + %01d )", per1, per2, per3, per4, per5);
				String mulai1 = String.format("\nx = 360 - %01d", hitung);
				String mulai2 = String.format("\nx = %01d", hitung1);
				String mulai3 = String.format("\nx = (%01d / %01d ) x %01d", hitung1, data1, data2);
				String mulai4 = String.format("\nx = %01d", hitung2);


				hasil.setText(mulai + mulai1 + mulai2 + mulai3 + mulai4);

			}
			else
			{
				data3 = Integer.parseInt(td3.getText().toString());

				int hitung = per1 + per2 + per3 + per4 + per5;
				int hitung1 = 360 - hitung;
				int hitung2 = ((data3 * hitung1) / 360);
				String mulai = String.format("x = 360 - (%01d + %01d + %01d + %01d + %01d )", per1, per2, per3, per4, per5);
				String mulai1 = String.format("\nx = 360 - %01d", hitung);
				String mulai2 = String.format("\nx = %01d", hitung1);
				String mulai3 = String.format("\nx = (%01d / 360) x %01d", hitung1, data3);
				String mulai4 = String.format("\nx = %01d", hitung2);


				hasil.setText(mulai + mulai1 + mulai2 + mulai3 + mulai4);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
