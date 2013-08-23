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
			//uses Jsoup.connect to retrieve the url from where the elements to be extracted
			doc = Jsoup.connect("http://www.transitbc.com/regions/cfv/schedules/schedule.cfm?rmnu=dvSchedule&line=1&").get();
			String title = doc.title(); //gets title of the url (webpage)
			Elements links = doc.select("td"); //selects all the td elements in the page
			System.out.println("Title" +title);
			
			for(Element table:links)
			{
				//if the class of td is css-sched-times then it prints the text within those td's
				if(table.attr("class").equals("css-sched-times")) 
				{
					System.out.print(table.text() + "\n");
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
