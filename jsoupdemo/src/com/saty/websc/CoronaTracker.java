package com.saty.websc;

import java.io.IOException;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements;
public class CoronaTracker{  
    public static void main( String[] args ) throws IOException{  
    			System.out.println("===============================================");
    			System.out.println("Java API for tracking COVID-19 Cases in India");
    			System.out.println("=================================================================================================");
                Document doc = Jsoup.connect("https://www.mohfw.gov.in/").get();  
                Elements sampleDiv = doc.getElementsByClass("table-responsive");
               
                Elements table = doc.select("tr");
                
                
                //System.out.println(table);
                int count_row = 0;
                System.out.print("S.No"+"     "+"State"+"            "+"     "+"Indian-Confirmed"+"         "+"Foreign-Confirmed"+"      "+"Cured"+"     "+"Death");
                System.out.println();
                System.out.println("=================================================================================================");
                
                for(Element data: table) {
                	if(count_row++ >= 129) {
                	
                	Elements one = data.select("td");
                	
                	int count = 0;
                	for(Element two: one) {
                		count++;
                		if(count == 2) {
                			int spaces = 17-two.text().length()+6;
                			StringBuffer sb = new StringBuffer();
                			for(int k=0;k<spaces;k++) {
                				sb.append(" ");
                			}
                		System.out.print(two.text()+sb.toString());
                		}
                		else {
                			if(two.text().length() == 1)
                			System.out.print(two.text()+"       ");
                		else if(two.text().length() == 2) 
                			System.out.print(two.text()+"      ");
                		else
                			System.out.print(two.text()+"     ");
                	}
                }
                	System.out.println();
              }
                //System.out.println("title is: " + sampleDiv);  
                
    }
   } 
}
