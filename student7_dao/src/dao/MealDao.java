/*
 * Dao����
 * -Dao���ģʽ
 * Dao��ȫ���ǣ�Data Access Object�����ݷ��ʶ���
 * ʹ��Dao���ģʽ������װ���ݿ�־ò������ ������crud��
 * ��ʹ�ͼ��������߼��͸߼���ҵ���߼����룬�ﵽ��ϵ�Ŀ��
 * -һ�����͵�Daoʵ�������������
 * *һ��Dao�ӿ�
 * *һ��ʵ����Dao�ӿڵľ�����
 * *һ��Dao������
 * *���ݴ��������ʱ��Ϊֵ����
 * -��ά��һ���ͻ�����ϢΪ�����������������ʾ��
 * CostomerDao�ӿ�
 * Customerֵ����(VO)
 * CustomerDaoImp1(�ӿڵľ���ʵ����)
 * CustomerFactory�������࣬ʵ�����ã�
 */
package dao;

import java.util.List;

import student7_daobean.Meal;

public interface MealDao {
	
	public void add(Meal m);
	
	public List list();
}
