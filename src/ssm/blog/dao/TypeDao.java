package ssm.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.blog.entity.Type;

@Repository   //注册为持久层的bean
public interface TypeDao {
	/**
	 * 通过博客表中的类型id获得类型
	 * @param id
	 * @return
	 */
	Type getTypeById(Integer id);
	/**
	 * 通过写博客类型获得类型
	 * @param name
	 * @return
	 */
	Type getTypeByName(String name);
	/**
	 * 查询所有类别
	 * @return
	 */
	List<Type> getAllType();
	/**
	 * 查询某个博主的所有分类
	 * @param bloggerId
	 * @return
	 */
	List<Type> getTypeByBlogger(Integer bloggerId);
	/**
	 * 增加类别
	 * @param type
	 * @return
	 */
	int addType(Type type);
	/**
	 * 修改类别
	 * @param type
	 * @return
	 */
	int updateType(Type type);
	/**
	 * 删除类别
	 * @param id
	 * @return
	 */
	int deleteType(Integer id);
}
