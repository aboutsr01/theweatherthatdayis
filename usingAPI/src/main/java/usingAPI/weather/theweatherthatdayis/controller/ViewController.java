package usingAPI.weather.theweatherthatdayis.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import usingAPI.weather.theweatherthatdayis.model.service.ViewService;

@Controller
public class ViewController {
	
	@Autowired
	private ViewService vService;
	
	@RequestMapping("homeView.do")
	public ModelAndView homeView(ModelAndView mv) {
		
		mv.setViewName("home");
		
		return mv;
	}
	
	/**
	 * @param year
	 * @param month
	 * @param day
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getDate.do")
	public void getDate(int year, int month, int day, HttpServletResponse response) throws IOException {
		
		// 데이터가 있는 URL 주소
		String a = "http://www.weather.go.kr/weather/climate/past_cal.jsp?";
		
		String url = a + "stn=108&x=17&y&5&yy=" + year + "&mm=" + month + "&obs=1";
		
		// url 주소로 연결
		URL urlConn = new URL(a);
		URLConnection connection = urlConn.openConnection();
		
		connection.setDoOutput(true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.openStream(),"euc-kr"));
		
		String inputLine;
		
		String buffer = "";
		
		while((inputLine = in.readLine()) != null){
			buffer += inputLine.trim();
		}
		
		in.close();
		
		
		CharBuffer cbuffer = CharBuffer.wrap((buffer).toCharArray());
		Charset utf8charset = Charset.forName("UTF-8");
		ByteBuffer bbuffer = utf8charset.encode(cbuffer);
		
		String tepDecode = new String (bbuffer.array());
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		gson.toJson(tepDecode, response.getWriter());
		
	}
		
}
