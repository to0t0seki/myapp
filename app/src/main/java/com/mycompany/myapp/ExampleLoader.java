package com.mycompany.myapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;



public class ExampleLoader extends AsyncTaskLoader<Map<String,String>>
{
	private String url="http://papimo.jp/h/00041817/hit/index_machine/1-20-260540/";
	Map<String,String>machinehashmap=new HashMap<>();
	
	public ExampleLoader(Context context) {
        super(context);		
    }
	

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Map<String,String> loadInBackground() {
		try{
			Document document = Jsoup.connect(this.url).timeout(10000).get();
			String maxpage=document.select("#max_page").val();
			for(int i=0;i < Integer.parseInt(maxpage);i++){
				document=Jsoup.connect(this.url+"?page="+String.valueOf((i+1))).timeout(10000).get();
				Elements elements=document.select(".item li a");
				for (Element element : elements) {
					int index = element.select(".name").text().indexOf("台") + 1;
					this.machinehashmap.put(element.select(".name").text().substring(index),element.attr("href"));
				}
			}
		return this.machinehashmap;
		}catch(IOException e){
			return this.machinehashmap;
		}
    }
}
