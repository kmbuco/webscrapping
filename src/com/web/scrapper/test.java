package com.web.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public test(){
		Document doc = null;

		try {
			//doc = Jsoup.connect("http://www.geog.leeds.ac.uk/courses/other/programming/practicals/general/web/scraping-intro/table.html").get();
			doc = Jsoup.connect("http://jsoup.org/cookbook/extracting-data/dom-navigation").get();
			doc = Jsoup.connect("http://greatdesign.com/").get();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try{
			Element table = doc.getElementById("datatable");
			Elements rows = table.getElementsByTag("TR");
			Elements rowHeaders = table.getElementsByTag("TH");
			
			
			
			for (Element row : rows) {
				Elements tds = row.getElementsByTag("TD");
				for (int i = 0; i < tds.size(); i++) {
					//if (i == 1) 
						System.out.println(tds.get(i).text());
				}
			}
			for(Element Header: rows){
				Elements tds =  Header.getElementsByTag("TH");
				for (int i = 0; i < tds.size(); i++) {
					//if (i == 1) 
						System.out.println(tds.get(i).text());
				}
			}
		}catch(Exception ex){
			//ex.printStackTrace();
			System.out.println("the page does not have tables");
		}
		
		
		try{
			Element content = doc.getElementById("content");
			Elements links = content.getElementsByTag("a");
			for (Element link : links) {
			  String linkHref = link.attr("href");
			  String linkText = link.text();
			}
		}catch(Exception ex){
			System.out.println("the page does not have links");
		}
		
		try{
			Elements links = doc.getElementsByTag("a");
			//Elements linksBody = body.getElementsByTag("a");
			for (Element link : links) {
				String linkHref;
				String linkText;
				
			    linkHref = link.attr("href");
			    linkText = link.text();
			    System.out.println("the link is "+linkText + " The link url is : " + linkHref);
			  }
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			Elements links = doc.getElementsByTag("img");
			//Elements linksBody = body.getElementsByTag("a");
			for (Element link : links) {
			  String linkHref = link.attr("href");
			  String linkText = link.text();
			  System.out.println("the Image is "+ link.attr("src"));
			  //System.out.println("the Image is "+linkText + " The image url is : " + linkHref);
			  
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	public static void main (String args[]) {
		//check if you are online
		Utility util = new Utility();
		if(util.isOnline())
			new test();
		else
			System.out.println("Connect to the internet.");
	}
}
