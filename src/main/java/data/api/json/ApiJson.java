package data.api.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiJson {
	public static void main(String[] args) {
		//BufferReader
		BufferedReader br = null;
		try {
			//공공API 인증키 및 전체 풀 주소
			//변수에 여러 값을 넣어서 주소 체계를 만들어야 한다면 StringBuilder를 사용
			//String : 불변성을 가지므로 문자열을 더할 때 매번 새로운 객체를 생성해서 참조하는 방식
			//StringBuilder :  문자열을 더해 나갈 때 새로운 객체를 매번 생성하는 것이 아니라 기존 데이터 값에 추가해가는 방식, 속도가 빠름
			//mutable속성이고, append(), insert(), delete()등을 사용해서 값을 변경
			//공공 API방식은 StringBuilder를 사용
			String urlStr = "http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=f5eef3421c602c6cb7ea224104795888";
			
			//URL클래스로 객체 생성 : 절대경로, 상대경로 2가지 방식이 있음
			URL url = new URL(urlStr);
			
			//openConnection()매서드를 이용한 연결
			//URL주소의 원격 객체에 접속한 뒤 통신할 수 있는 URLConnection객체 리턴
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setRequestProperty("Content-type", "application/json");
			System.out.println("ResponseCode : " + urlConn.getResponseCode()); //200이 출력되면 성공
			
			//InputStreamReader클래스로 읽기
			//BufferedReader는 InputStreamReader의 객체를 입력값으로 사용
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			
			//결과 변수
			/*
			String rst = "";
			String line;
			while((line = br.readLine()) != null) {
				rst += line + "\n";
			}
			System.out.println(rst);	
			*/
			
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			
			//연결 해제
			br.close();
			urlConn.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}