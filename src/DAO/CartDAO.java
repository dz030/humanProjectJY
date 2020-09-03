package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CartDTO;

public class CartDAO {
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
	
	//카트 담김목록 
	public void insert(int no, String name,int cnt, int price) {
		String sql = "insert into cart values(?,?,?,?*?)";
		PreparedStatement ppst = null;
		if(conn()!=null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.setString(2, name);
				ppst.setInt(3, cnt);
				ppst.setInt(4, price);
				ppst.setInt(5, cnt);
				ppst.executeQuery();
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if(ppst != null) {
						ppst.close(); 
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	//카트 담아논 목록 
	public ArrayList<CartDTO> selectAll(){
		String sql="select * from cart";
		Statement st = null;    
		ArrayList<CartDTO> tempList = new ArrayList<>();
		                                
		if(conn()!=null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					CartDTO tempDTO = new CartDTO();
					tempDTO.setNo(rs.getInt("no"));
					tempDTO.setName(rs.getString("name"));
					tempDTO.setCnt(rs.getInt("cnt"));
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
