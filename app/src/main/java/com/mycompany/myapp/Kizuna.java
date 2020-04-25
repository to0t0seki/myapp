package com.mycompany.myapp;


import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import org.jsoup.*;




public class Kizuna
{
	List<Integer> machinelist = new ArrayList<>();
	Map<Integer,Map<String,Object>> kizunaMap = new TreeMap<>();
	public Kizuna(){
		
		/*
		
		
		try{
			Document document = Jsoup.connect("http://papimo.jp/h/00041817/hit/index_sort/220010002/1-20-260540").timeout(10000).get();
			Elements elements = document.select(".btn.btn-main");
			for (Element element : elements) {
				this.machinelist.add(Integer.parseInt(element.text()));
			}		
		}catch(IOException e){
			System.out.println("errors:"+e);
		}*/
	}
	
	public void datainput(){	
		try{
			for(Integer no:this.machinelist){
				Map<String,Object> mapdetail = new TreeMap<>();
				List<List<String>> listrireki = new ArrayList<>();
				Document document = Jsoup.connect("http://papimo.jp/h/00041817/hit/view/"+String.valueOf(no)).timeout(10000).get();
				Elements elements =document.select(".history tr");
				Elements elements1 = document.select("#tab-data-some tbody tr");
				mapdetail.put("big",elements1.select("td").eq(1).text());
				mapdetail.put("reg",elements1.select("td").eq(2).text());
				mapdetail.put("sou",elements1.select("td").eq(5).text());
				mapdetail.put("saisyu",elements1.select("td").eq(6).text());
				if(!(elements.size()==0)){
				elements.remove(0);
				Collections.reverse(elements);
				for (Element element : elements) {
					List<String> list = new ArrayList<>();
					list.add(element.select(".cnt").text());
					list.add(element.select(".time").text());
					list.add(element.select(".start").text());
					list.add(element.select(".out").text());
					list.add(element.select(".sts").text());
					listrireki.add(list);
				}
				}
				mapdetail.put("rireki",listrireki);
				int bc = 0;
				int bt = 0;
				int hamari[] = {0,0};
				int soukaiten = Integer.parseInt((String)mapdetail.get("saisyu"));
				boolean bttyuu = false;
				Iterator iterator = listrireki.iterator();
				while(iterator.hasNext()){
					List<String> list = (List<String>)iterator.next();
					if(list.get(4).equals("BIG") && Integer.parseInt(list.get(2)) > 1){
						soukaiten += Integer.parseInt(list.get(2));
						bc +=1;	
						hamari[0] += Integer.parseInt(list.get(2));
						hamari[1] += 1;
						bttyuu = false;
						}else{
						if(bttyuu ==false){
							bttyuu = true;
							hamari[0]=0;
							hamari[1]=0;
							bt +=1;
						}
					}
				}	
				mapdetail.put("bc",bc);
				mapdetail.put("bt",bt);
				mapdetail.put("hamarig",hamari[0]+Integer.parseInt((String)mapdetail.get("saisyu")));
				mapdetail.put("hamarib",hamari[1]);
				this.kizunaMap.put(no,mapdetail);
				System.out.println("end:"+no);
			}
		}catch(IOException e){
			System.out.println("error"+e);		
		}
	}
	
	public void printhamari(){
		for(int no:kizunaMap.keySet()){
			System.out.println(no);
			for(String s:kizunaMap.get(no).keySet()){
				switch(s){
					case "hamarig":
						System.out.println(kizunaMap.get(no).get(s));
						break;
					case "hamarib":
						System.out.print(kizunaMap.get(no).get(s)+" ");
						break;				
				}
			}
		}
	}
	
	public void printsettei(){
		int totalbt=0;
		int totalbc=0;
		for(int no:kizunaMap.keySet()){
			System.out.println(no);
			for(String s:kizunaMap.get(no).keySet()){
				
				switch(s){
					case "bt":
						System.out.println(kizunaMap.get(no).get(s));
						totalbt+=(int)kizunaMap.get(no).get(s);
						break;
					case "bc":
						System.out.print(kizunaMap.get(no).get(s)+" ");
						totalbc+=(int)kizunaMap.get(no).get(s);
						break;				
				}
			}
		}
		System.out.println("total\nbc:"+totalbc+" bt:"+totalbt);
	}
}
