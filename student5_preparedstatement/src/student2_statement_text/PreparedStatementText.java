/*
 * һ�ֶ�̬�������ķ��������˵Statementʱ��̬�ģ���ôPreparedStatement���Ƕ�̬�ķ���
 */
package student2_statement_text;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student2_statement_DButil.Dbutil;

public class PreparedStatementText {
	public static void main(String[] args) {
		/*
		 * ���������ַ������Բ�ѯ
		 */
		//PreparedStatement();
		//PreparedStatement(2);
		/*
		 * ���������ַ�����������
		 */
		//add();
		//add("kite",30);
		/*
		 * stu s=new stu();
		 * s.setName("kite");
		 * s.setAge(30);
		 * add(stu s);
		 */
		//���������ַ�������ɾ��
		//del();
		//del(3);
		//���������ַ�����������
		//update();
		//update("kite",2);
		//���ô˷������в�ѯ
		//query()
		/*
		 * ��ʵ���з��������Խ����޲� �в� ��ʹ�ö����еķ�������������������
		 */
	}
	
	 
	//һ���޲ι�����ʽ���̶��Ļ�ȡ
	static void PreparedStatement() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//���εĹ�����ʽ���Զ�̬��ȡ
	static void PreparedStatement(int id) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void query() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql="select id,name,age from stutb1 where age > ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 20);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * ��������PreparedStatement����ɾ�Ĳ��е�Ӧ��
	 */
	//�ڱ��ж�̬����������
	static void add() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kite");
			pstmt.setInt(2, 30);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	static void add(String name,int age) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	static void add(stu s) {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" insert into stutb1(name,age) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getAge());
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		
	}
	//���������ڱ�̬����ɾ������
	static void del() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql=" delete from stutb1 where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();
			//System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
		static void del(int s) {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" delete from stutb1 where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, s);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		//���������ڱ��и�������
		static void update() {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" update stutb1 set name=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "kite");
				pstmt.setInt(2, 2);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		static void update(String name,int s) {
			Dbutil util = new Dbutil();
			Connection conn = util.getConnection();
			String sql=" update stutb1 set name=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, s);
				pstmt.executeUpdate();
				//System.out.println(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.closeConnection(conn);
			}
		}
		
}
class stu{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
	
