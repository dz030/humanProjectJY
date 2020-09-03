package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.SignInDTO;


public class SigninDAO {
	
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id ="system";
	private String pwd = "oracle";
	
	private ResultSet rs = null;
	
	public Connection conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//------------------------------------------------------------------Connected
	//회원정보목록  
		public ArrayList<SignInDTO> selectAll() {
			String sql = "select * from memberInfo";  
			Statement st = null;    
			ArrayList<SignInDTO> tempList = new ArrayList<>();
			                                
			if(conn()!=null) {
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next()) {
						SignInDTO tempDTO = new SignInDTO();
						tempDTO.setNo(rs.getInt("no"));
						tempDTO.setUserid(rs.getString("userid"));
						tempDTO.setPw(rs.getString("pw"));
						
						tempList.add(tempDTO);
						
					}
				} catch (Exception e) {

				} finally {
					try {
						if(st != null) st.close(); 
						if(conn != null) conn.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
			return tempList;
		}
	
	
	
}
