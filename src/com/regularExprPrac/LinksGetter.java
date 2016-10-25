package com.regularExprPrac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.util.Util;

/**
 * The following example allows you to extract all valid links from a webpage. 
 * It does not consider links which start with "javascript:" or "mailto:".
 * 
 * example: <a target="_self" class="cc_more_info" href="http://www.vogella.com/legal.html">See details</a>
 *
 */
public class LinksGetter {

	
	public List<String> getLinks(String url) {
		List<String> links = new ArrayList<String>();
		
		//step1: get <a ...></a>
		String a_regex = "<a\\b[^>]*href=\"[^>]*>(.*?)</a>";
		Pattern a_tag = Pattern.compile(a_regex);
		String html_content = this.getHtmlContent(url);
		Matcher a_matcher = a_tag.matcher(html_content);
		
		//step2: get content of href
		String href_regex = "href=\"[\\S+]*\"";
		Pattern href_attr = Pattern.compile(href_regex);
		while(a_matcher.find()) {
			Matcher href_matcher = href_attr.matcher(a_matcher.group());
			href_matcher.find();
			String href_content = href_matcher.group()
					.replaceFirst("href=\"", "")
					.replaceFirst("\"", ""); 
			//step3: valid that not start with javascript or mailto
			if(this.validLink(href_content))
				links.add(this.makeAbsolute(url, href_content));
		}
		
		return links;
	}
	
	public String getHtmlContent(String url) {
		StringBuilder html_sb = new StringBuilder();
		try {
			BufferedReader buff = new BufferedReader(
					new InputStreamReader(
							new URL(url).openStream()
							)
					);
			String s;
			while ((s = buff.readLine()) != null)
				html_sb.append(s);
			
		} catch (MalformedURLException e) {
            e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
		}
		return html_sb.toString();
	}
	
	public boolean validLink(String link) {
		if(link.matches("(javascript:.*|mailto:.*)"))
				return false;
		return true;
	}
	
	public String makeAbsolute(String url, String link) {
        if (link.matches("http://.*")) {
                return link;
        }
        if (link.matches("/.*") && url.matches(".*$[^/]")) {
                return url + "/" + link;
        }
        if (link.matches("[^/].*") && url.matches(".*[^/]")) {
                return url + "/" + link;
        }
        if (link.matches("/.*") && url.matches(".*[/]")) {
                return url + link;
        }
        if (link.matches("/.*") && url.matches(".*[^/]")) {
                return url + link;
        }
        throw new RuntimeException("Cannot make the link absolute. Url: " + url
                        + " Link " + link);
}
	
	public static void main(String[] args) {

		LinksGetter lg = new LinksGetter();
		String url = "http://localhost:80";
		List<String> links = lg.getLinks(url);
		Util.print(links);
	}

}
