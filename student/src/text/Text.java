package text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.Dbutil;
/*��������һ�������࣬���ڲ�������Ľ������ʹ�ù�����һ��Ҫע�������Ķ�Ӧ
 * 
 */
public class Text {
	public static void main(String[] args) {
		Text text=new Text();
		text.list();
		
	}
public void list() {
	Dbutil util=new Dbutil();
	Connection conn=util.getConnection();
	String sql="select s_name,s_sex,s_age,s_subject from s_manager";
	try {
		Statement stmt=conn.createStatement();//һ��������sql�������
		ResultSet rs=stmt.executeQuery(sql);//��һ��ָ��ָ��������Ҳ�����Ѿ������ݿ�������õ��˽��������
		/*rs.next()�������ж��Ƿ�����һ����¼
		 * ѭ�����ڶ�ȡ��
		 * ���������
		 */
		while(rs.next()) {
			String name=rs.getString("s_name");
			String sex=rs.getString("s_sex");
			int age=rs.getInt("s_age");
			String subject=rs.getString("s_subject");
			System.out.println(name+" "+sex+" "+age+" "+subject);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		util.closeConnection(conn);
	}
}
}
