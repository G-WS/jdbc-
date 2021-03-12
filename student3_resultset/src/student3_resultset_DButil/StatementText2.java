package student3_resultset_DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import student3_resultset_text.Dbutil;


public class StatementText2 {
	public static void main(String[] args) {
		textResultset();
		List list=liststu();
		System.out.println(list);
		updatableResultset();
	}
	/*�˷������ڲ�ѯ��ǰ��������ڵ������Լ��Ƿ��ڵ�һ��
	 * �������Ĭ�ϲ��ɹ������ɸ��µģ������Ǵӵ�һ�е����һ�е�˳��
	 */
	static void textResultset() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			//rs.absolute(3);//��������˼�Ǿ��Զ�λ����n�У���ǰ�����Ǿ��Զ�λ�������С�
			//rs.next();//�˷������Ըı䵱ǰ��������������ı䷽��Ϊ�����ƶ�һ�� ���������ԭ��row=0����һ��֮��row�ͻ��Ϊ1
			
			int row=rs.getRow();
			System.out.println(row);//�����������ѯ��ǰ���ڵĽ����������
			
			boolean b=rs.isBeforeFirst();
			System.out.println(b);//����������жϵ�ǰ��������ڵ������Ƿ��ڵ�һ��
			
			/*while(rs.next()) {
				int id=rs.getInt("id");//Ҳ����ʹ�����������87��
				String name=rs.getString(2);
				int age=rs.getInt("age");
				System.out.println(id+" "+name+" "+age);
				}*///��������������ֽ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	/*������ResultSet.TYPE_SCROLL_INSENSITIVE��ResultSet.CONCUR_UPDATABLE����������֮�󣬽����һ���ɹ����ɸ��µĽ����
	*������д���������Ϊ�ڽ���ʱû������������
	*/
	
	static void updatableResultset() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		String sql="select id,name,age from stutb1";
		Statement stmt;
		try {
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery(sql);
			//���һ��
			/*rs.moveToInsertRow();
			rs.updateString("name", "bigton");
			rs.updateInt(3, 21);
			rs.insertRow();
			*/
			//����һ��
			/*rs.absolute(2);
			rs.updateString("name", "tom");
			rs.updateRow();
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//�˷����ǽ����ݴ����һ����������������������վ�п���ֱ�ӱ�����
	static List liststu() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			List list=new ArrayList();
			while(rs.next()) {
				//getXXX(),XXX��������
				int id=rs.getInt("id");//Ҳ����ʹ�����������87��
				String name=rs.getString(2);
				int age=rs.getInt("age");
				
				stu s=new stu();
				s.setAge(age);
				s.setId(id);
				s.setName(name);
				list.add(s);
				System.out.println(id+" "+name+" "+age);
			}//��������������ֽ����
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
		return null;
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