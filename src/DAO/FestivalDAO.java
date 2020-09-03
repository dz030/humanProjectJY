package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.FestivalDTO;

public class FestivalDAO {
	
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
	//페스티벌 목록  
		public ArrayList<FestivalDTO> selectAll() {
			String sql = "select * from festival";  
			Statement st = null;    
			ArrayList<FestivalDTO> tempList = new ArrayList<>();
			                                
			if(conn()!=null) {
				try {
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next()) {
						FestivalDTO tempDTO = new FestivalDTO();
						tempDTO.setNo(rs.getInt("no"));
						tempDTO.setName(rs.getString("name"));
						tempDTO.setLocation(rs.getString("location"));
						tempDTO.setDay(rs.getString("day"));
						tempDTO.setPrice(rs.getInt("price"));
						
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
