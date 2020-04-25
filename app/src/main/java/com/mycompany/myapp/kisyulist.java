package com.mycompany.myapp;


import android.app.*;
import android.content.*;
import android.os.*;
import java.util.*;
import android.util.*;
import android.app.LoaderManager.LoaderCallbacks;
import android.view.*;
import android.widget.*;
//import android.view.View.*;

public class kisyulist extends Fragment  implements LoaderCallbacks<Map<String,String>>
{
	private Context context;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		LinearLayout layout=new LinearLayout(getActivity());
		container.addView(layout);
		// TODO: Implement this method
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	

	
	
	
    public void outputlist(LoaderManager lm){
		Bundle bundle=new Bundle();
		bundle.putString("url","http://papimo.jp/h/00041817/hit/index_machine/1-20-260540/");
		lm.initLoader(0,bundle,this);
		System.out.println("6");
		
		
	}

	
	
	@Override
	public Loader<Map<String,String>> onCreateLoader(int id, Bundle args) {
		return new TestLoader(context);
	}

	@Override
	public void onLoadFinished(Loader<Map<String,String>> loader,Map<String,String> map) {
		
		System.out.println("fin");
		
		LinearLayout layout=new LinearLayout(getActivity());
	}

	@Override
	public void onLoaderReset(Loader<Map<String,String>> loader) {
	}
	
	
}
