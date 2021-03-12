/*
 *����һ����Ԫ����
 *��junit��ѡ��case ����text���У�Ȼ��ѡ��setup��teardown
 *��next��ѡ�ӿ��е����г�����finish����
 */

package text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.Userdao;
import dao.impl.UserdaoImpl;
import student7_daobean.Userbean;

class UserdaoImplTest {

	Userdao dao;
	@BeforeEach//�Զ����ò�����
	protected void setUp() throws Exception {
		dao=new UserdaoImpl();
	}

	@AfterEach//���н���ִ��
	protected void tearDown() throws Exception {
	}
	@Test
	public void testRegister() {
		Userbean u=new Userbean();
		u.setId(1);
		u.setName("tom");
		u.setPassword("213");
		dao.register(u);
	}
	@Test
	public void testCheck() {
		boolean b = dao.check("tom");
		System.out.println(b);
	}

	@Test
	public void testLogin() {
		Userbean u = dao.login("tom", "213");
		System.out.println(u.getName());
	}

	

	
}
