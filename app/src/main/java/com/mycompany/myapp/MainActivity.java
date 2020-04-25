package com.mycompany.myapp;


import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.graphics.*;
import android.app.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;


public class MainActivity extends AppCompatActivity
{

	private static int s=  R.drawable.abc_textfield_search_default_mtrl_alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		System.out.println("6");
		int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
        int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

		LinearLayout baselayout = new LinearLayout(this);


		super.onCreate(savedInstanceState);

/*
		baselayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(baselayout);

		LinearLayout layout1 = new LinearLayout(this);
		layout1.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 120));
		baselayout.addView(layout1);

		LinearLayout layout2 = new LinearLayout(this);
		layout2.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 120));
		baselayout.addView(layout2);
		
		LinearLayout layout3 = new LinearLayout(this);
		layout3.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 120));
		baselayout.addView(layout3);
		layout2.setId(1);
		
		
		kisyulist k =new kisyulist();
		FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
	int a=View.generateViewId();
		//transaction.add(

		Button kisyubutton =new Button(this);
		kisyubutton.setText("kisyulist");
		kisyubutton.setWidth(100);
		kisyubutton.setHeight(40);
		kisyubutton.setTextSize(8);
		layout1.addView(kisyubutton);*/

/*

		LinearLayout scrolllayout =new LinearLayout(this);

		LoaderManager loadermanager =getLoaderManager();
		kisyulist klist =new kisyulist(this);
		klist.outputlist(loadermanager);


		for(int i=0;i<10;i++){
			Button button=new Button(this);
			button.setText(String.valueOf(i));
			button.setWidth(100);
			button.setHeight(40);
			button.setTextSize(8);
			scrolllayout.addView(button);
		}

		scrollView.addView(scrolllayout);

*/
/*
		baselayout.setBackgroundColor(Color.WHITE);
		layout1.setBackgroundColor(Color.BLUE);
		layout2.setBackgroundColor(Color.RED);
		layout3.setBackgroundColor(Color.BLUE);



*/



		/*	button.setOnClickListener(new View.OnClickListener(){
		 @Override 
		 public void onClick(View view){
		 Bundle bundle=new Bundle();
		 bundle.putString("url","http://papimo.jp/h/00041817/hit/index_machine/1-20-260540/");
		 LoaderManager loadermanager =getLoaderManager();
		 loadermanager.initLoader(0,bundle,MainActivity.this);

		 }
		 });*/


		
	}
}

