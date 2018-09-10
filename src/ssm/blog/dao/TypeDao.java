package ssm.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.blog.entity.Type;

@Repository   //ע��Ϊ�־ò��bean
public interface TypeDao {
	/**
	 * ͨ�����ͱ��е�����id�������
	 * @param id
	 * @return
	 */
	Type getTypeById(Integer id);
	/**
	 * ͨ��д�������ͻ������
	 * @param name
	 * @return
	 */
	Type getTypeByName(String name);
	/**
	 * ��ѯ�������
	 * @return
	 */
	List<Type> getAllType();
	/**
	 * ��ѯĳ�����������з���
	 * @param bloggerId
	 * @return
	 */
	List<Type> getTypeByBlogger(Integer bloggerId);
	/**
	 * �������
	 * @param type
	 * @return
	 */
	int addType(Type type);
	/**
	 * �޸����
	 * @param type
	 * @return
	 */
	int updateType(Type type);
	/**
	 * ɾ�����
	 * @param id
	 * @return
	 */
	int deleteType(Integer id);
}
