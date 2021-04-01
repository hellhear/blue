package net.tis.guest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GuestSQL { // 순수자바문서를 단독하면 에러발생
	Connection CN; // db서버연결정보, 명령어생성할때 참조
	Statement ST; // 명령어생성 ST = CN.createStatement()
	PreparedStatement PST; // 속도가빠름 PST = CN.prepareStatement("insert~/update~")
	CallableStatement CST; // 데이터베이스의 함수프로시저 사용
	ResultSet RS; // select조회한결과 RS=ST.executeQuery("select~~")

	String Gtitle, Gcontent, Gwriter;
	java.util.Date Gwdate;
	int Ghit;

	int GGtotal, Gtotal;
	String msg; // msg="dml쿼리문기술 insert~/select~/update~/delete~"
	String data; // data=request.getParameter("idx");

	// test테이블에서 사용
	int Gpay, Gcode;
	String Ggender, Gimage;

	// guest테이블
	int Gsabun;
	String Gemail;

	public GuestSQL() {
		try {
			// 순서1 db데이터베이스 드라이브연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Web0215플젝 오라클드라이브성공 수요일 4:45분 ");

			// 순서2 db데이터베이스 서버정보주소및포트 계정id/pwd
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			CN = DriverManager.getConnection(url, "system", "1234");
			System.out.println("Web0215플젝 오라클서버정보및 id,pwd 수요일 4:45분  ");

			ST = CN.createStatement(); // 권장
		} catch (Exception ex) {
			System.out.println("db 에러 " + ex.toString());
		}
	}// end

	public void dbInsert(GuestDTO gdto) { // 매개인자5개 기술하세요
		try {

			msg = "insert into guest values(?, ?,?,sysdate,?,0,?) ";
			PST = CN.prepareStatement(msg);
			PST.setInt(1, gdto.getSabun());
			PST.setString(2, gdto.getName());
			PST.setString(3, gdto.getTitle());
			PST.setInt(4, gdto.getPay());
			PST.setString(5, gdto.getEmail());
			PST.executeUpdate();
		} catch (Exception ex) {
			System.out.println("저장에러 " + ex);
		}
	}// end

	public ArrayList<GuestDTO> dbSelectAll() { // 매개인자5개 기술하세요
		ArrayList<GuestDTO> arr = new ArrayList<GuestDTO>();
		try {
			msg = "Select rownum rn, g.* from guest g";
			RS = ST.executeQuery(msg);
		
		  while(RS.next()==true) {
				GuestDTO gdto = new GuestDTO();
				gdto.setRn(RS.getInt("rn"));
				gdto.setName(RS.getString("name"));
				gdto.setSabun(RS.getInt("sabun"));
				gdto.setEmail(RS.getString("email"));
				gdto.setPay(RS.getInt("pay"));
				gdto.setTitle(RS.getString("title"));
				gdto.setWdate(RS.getDate("wdate"));
				gdto.setHit(RS.getInt("hit"));
				
				arr.add(gdto);
			}

		} catch (Exception ex) {
			System.out.println("저장에러 " + ex);
		}
		return arr;
	}// end
	

	public GuestDTO dbSelectAll(String sa) { // 매개인자5개 기술하세요
		GuestDTO gdto = new GuestDTO();
		try {
			msg = "Select * from guest where sabun ="+sa;
			RS = ST.executeQuery(msg);
		
			RS.next();
			gdto.setName(RS.getString("name"));
			gdto.setSabun(RS.getInt("sabun"));
			gdto.setEmail(RS.getString("email"));
			gdto.setPay(RS.getInt("pay"));
			gdto.setTitle(RS.getString("title"));
			gdto.setWdate(RS.getDate("wdate"));
			gdto.setHit(RS.getInt("hit"));

		} catch (Exception ex) {
			System.out.println("저장에러 " + ex);
		}
		return gdto;
	}// end
	

	public GuestDTO dbDelete(String sa) { // 매개인자5개 기술하세요
		GuestDTO gdto = new GuestDTO();
		try {
			msg = "delete from guest where sabun ="+sa;
			ST.executeQuery(msg);
		} catch (Exception ex) {
			System.out.println("저장에러 " + ex);
		}
		return gdto;
	}// end

	 public int getTotal(){
     try { //전체레코드갯수
      msg="select count(*) as cnt from guest ";
      ST=CN.createStatement();
      RS=ST.executeQuery(msg);
      if(RS.next()==true) {
        Gtotal=RS.getInt("cnt");
      }
     }catch(Exception ex){System.out.println("전체출력에러 " + ex);}
     return Gtotal;
  }//end
}// GuestSQL class END