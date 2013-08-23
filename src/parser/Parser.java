package parser;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public static void main(String args[])
	{
		Document doc;
		
		try{
			
			doc = Jsoup.connect("http://www.transitbc.com/regions/cfv/schedules/schedule.cfm?rmnu=dvSchedule&line=1&").get();
			String title = doc.title();
			Elements links = doc.select("td");
			System.out.println("Title" +title);
			
			for(Element table:links)
			{
				System.out.println(table);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
