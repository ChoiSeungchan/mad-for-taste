package org.kosta.madfortaste.common.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.kosta.madfortaste.common.domain.NaverMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxProxyController {
	
	@ResponseBody
	@RequestMapping(value = "naverGeoCording.json")
	public List<NaverMap> testProxy(String key, String query) {
		List<NaverMap> mapList = new ArrayList<NaverMap>();
		query = query.replaceAll(" ", "");
		String url = "http://openapi.naver.com/search?key="+key+"&query="+query+
				"&target=local&start=1&display=10";
		try {
			URL u = new URL(url);
			URLConnection connection = u.openConnection();
			connection.setDoOutput(true);
			SAXBuilder builder = new SAXBuilder();
			Document doc =  builder.build(u.openStream());
			Element rss = doc.getRootElement();
			Element channel = rss.getChild("channel");
			List<Element> itemList = channel.getChildren("item");
			for (Element item : itemList) {
				String title = item.getChildText("title");
				String category = item.getChildText("category");
				String telephone = item.getChildText("telephone");
				String address = item.getChildText("address");
				String roadAddress =  item.getChildText("roadAddress");
				String mapx = item.getChildText("mapx");
				String mapy = item.getChildText("mapy");
				NaverMap naverMap = new NaverMap(title, category, telephone, address, roadAddress, mapx, mapy);
				mapList.add(naverMap);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return mapList;
	}

}
