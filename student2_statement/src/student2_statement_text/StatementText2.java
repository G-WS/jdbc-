/*Statement���
 * Statement�ṩ��һ���������ݿ��SQL���Ĺ��ܣ���ͨ�����������������¼���޸ļ�¼��ɾ����¼�Ȳ���
 * Statement��������˼���Ǹ�������ִ��SQL����һ���ӿ�
 * ���������ӽӿ���CallableStatement��PreparedStatement
 * �����ֶ���insert,update,delete
 * ��ѯ�ֶ���select
 * createStatement()������Connection�������ڴ���һ��Statement��������SQL��䷢�͵����ݿ�
 * �������ĸ�����
 * execute(String SQL)ִ�и�����SQL��䣬�������ܷ��ض�����
 * executeQuery(String SQL)ִ�и�����SQL��䣬����䷵�ص�����ResultSet����
 * executeUpdate(String SQL)ִ�и�����SQL��䣬����������INSERT,DELETE,UPDATE��䣬���߲������κ����ݵ�SQL��䣨��SQL,DDL��䣩
 *close()�����ͷŴ�statement��������ݿ��JDBC��Դ�������ǵȴ��ö����Զ��ر�ʱ�����˲���
 */

package student2_statement_text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import student2_statement_DButil.Dbutil;

public class StatementText2 {
	public static void main(String[] args) {
		getStatement();//�������������Statement
		//createTable();//���ô˷��������ݿ��д������
		//add();//���ô˷����ڱ������������
		//del();//���ô˷����ڱ����ɾ������
		//update();//���ô˷����ڱ�����޸�����
		//query();//���ô˷�����ѯ���
	}
	//�˷��������������������
	static void add() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into stuTb1(id,name,age) values(1,'tom',18)";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//�˷��������ڱ����ɾ������
	static void del() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="delete from stutb1 where id=1";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//�˷��������ڱ�����޸�����
	static void update() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="update stutb1 set name='bigtom' where id=1";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//�˷������ڲ�ѯ����е�����
	static void query() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select id,name,age from stutb1";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");//Ҳ����ʹ�����������87��
				String name=rs.getString(2);
				int age=rs.getInt("age");
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}
	//�˷������������ݿ��д������
	static void createTable() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="create table stuTb1(id int,name varchar(15),age int)";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeConnection(conn);
		}
	}

	//�÷��������ڴ���statement������
	static void getStatement() {
		Dbutil util=new Dbutil();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
