/*
 * JDBC--MetaData(Ԫ����)
 * ��Ϊ�����MetaData�����ݿ�MetaData
 */

package student3_resultset_text;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import student3_resultset_DButil.Dbutil;

public class MetadataText {
	public static void main(String[] args) {
		textDatabaseMetaData();
		textResultSetMetaData();
	}
	//�˷���ͨ��DatabaseMetaData��ȡ���ݿ�İ汾�����ݿ������
	static void textDatabaseMetaData() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			DatabaseMetaData metadata = conn.getMetaData();
			System.out.println("version"+": "+metadata.getDatabaseMajorVersion());//�˷���������ȡ���ݿ�����汾��
			System.out.println("name"+": "+metadata.getDatabaseProductName());//�˷������ڻ�����ݿ������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�˷���ͨ��ResultSetMetaData��ȡ���ݿ��е��е�����
	static void textResultSetMetaData() {
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		String sql = "select id,name,age from stutb1";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();//�˷�����ȡ���е�����
			//��ѭ�����Ի�ò��������е�������
			for(int i=1;i<=count;i++) {
				String name = md.getColumnName(i);//�˷������ڻ�ñ���е�����
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
