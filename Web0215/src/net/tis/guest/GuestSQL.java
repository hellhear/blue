package net.tis.guest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GuestSQL { // �����ڹٹ����� �ܵ��ϸ� �����߻�
	Connection CN; // db������������, ��ɾ�����Ҷ� ����
	Statement ST; // ��ɾ���� ST = CN.createStatement()
	PreparedStatement PST; // �ӵ������� PST = CN.prepareStatement("insert~/update~")
	CallableStatement CST; // �����ͺ��̽��� �Լ����ν��� ���
	ResultSet RS; // select��ȸ�Ѱ�� RS=ST.executeQuery("select~~")

	String Gtitle, Gcontent, Gwriter;
	java.util.Date Gwdate;
	int Ghit;

	int GGtotal, Gtotal;
	String msg; // msg="dml��������� insert~/select~/update~/delete~"
	String data; // data=request.getParameter("idx");

	// test���̺��� ���
	int Gpay, Gcode;
	String Ggender, Gimage;

	// guest���̺�
	int Gsabun;
	String Gemail;

	public GuestSQL() {
		try {
			// ����1 db�����ͺ��̽� ����̺꿬��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Web0215���� ����Ŭ����̺꼺�� ������ 4:45�� ");

			// ����2 db�����ͺ��̽� ���������ּҹ���Ʈ ����id/pwd
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			CN = DriverManager.getConnection(url, "system", "1234");
			System.out.println("Web0215���� ����Ŭ���������� id,pwd ������ 4:45��  ");

			ST = CN.createStatement(); // ����
		} catch (Exception ex) {
			System.out.println("db ���� " + ex.toString());
		}
	}// end

	public void dbInsert(GuestDTO gdto) { // �Ű�����5�� ����ϼ���
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
			System.out.println("���忡�� " + ex);
		}
	}// end

	public ArrayList<GuestDTO> dbSelectAll() { // �Ű�����5�� ����ϼ���
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
			System.out.println("���忡�� " + ex);
		}
		return arr;
	}// end
	

	public GuestDTO dbSelectAll(String sa) { // �Ű�����5�� ����ϼ���
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
			System.out.println("���忡�� " + ex);
		}
		return gdto;
	}// end
	

	public GuestDTO dbDelete(String sa) { // �Ű�����5�� ����ϼ���
		GuestDTO gdto = new GuestDTO();
		try {
			msg = "delete from guest where sabun ="+sa;
			ST.executeQuery(msg);
		} catch (Exception ex) {
			System.out.println("���忡�� " + ex);
		}
		return gdto;
	}// end

	 public int getTotal(){
     try { //��ü���ڵ尹��
      msg="select count(*) as cnt from guest ";
      ST=CN.createStatement();
      RS=ST.executeQuery(msg);
      if(RS.next()==true) {
        Gtotal=RS.getInt("cnt");
      }
     }catch(Exception ex){System.out.println("��ü��¿��� " + ex);}
     return Gtotal;
  }//end
}// GuestSQL class END