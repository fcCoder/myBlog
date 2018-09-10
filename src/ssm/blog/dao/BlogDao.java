package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ssm.blog.entity.Blog;

@Repository
public interface BlogDao {
	/**
	 * ������²���Ĳ���id
	 * ������ִ������������ִ�У����򷵻�0
	 * �����max(id)������LAST_INSERT_ID()�������̰߳�ȫ��
	 * @return
	 */
	int selectLastBlogId();
	/**
	 * ��ѯ��������
	 * @return
	 */
	int selectBlogCount();
	/**
	 * ��ҳ��ѯ���в���
	 * @param startRow	��һ����¼
	 * @param pageSize	ÿҳ��¼����
	 * @return
	 */
	List<Blog> selectBlogByPage(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize);
	/**
	 * ��ҳ��ѯ�ҵ����в���
	 * @param startRow	��һ����¼
	 * @param pageSize	ÿҳ��¼����
	 * @return
	 */
	List<Blog> selectMyBlogByPage(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize,@Param("bloggerId")Integer bloggerId);
	/**
	 * ��ѯ�Ķ���ǰʮ�Ĳ���
	 * @return
	 */
	List<Blog> selectBlogByReadCount();
	/**
	 * ��ѯĳ�����������в���
	 * @param bloggerId
	 * @return
	 */
	List<Blog> selectBlogByBlogger(Integer bloggerId);
	/**
	 * ��������ѯ����
	 * @param typeId
	 * @return
	 */
	List<Blog> selectBlogByType(Integer typeId);
	/**
	 * ���ݱ�ǩ��ѯ����
	 * @param tagId
	 * @return
	 */
	List<Blog> selectBlogByTag(Integer tagId);
	/**
	 * �鿴����
	 * @param id
	 * @return
	 */
	Blog selectBlogById(Integer id);
	/**
	 * ��������
	 * @param blog
	 * @return
	 */
	int addBlog(Blog blog);
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	int deleteBlog(Integer id);
	/**
	 * �޸Ĳ���(���֣����ݣ�����)�������ֶβ��������޸�
	 * @param blog
	 * @return
	 */
	int updateBlog(Blog blog);
	/**
	 * �޸�������
	 * @param clickHit
	 * @param id
	 * @return
	 */
	int updateClickHit(@Param("clickHit")Integer clickHit,@Param("id")Integer id);
	/**
	 * �޸��Ķ�����
	 * @param readCount
	 * @param id
	 * @return
	 */
	int updateReadCount(@Param("readCount")Integer readCount,@Param("id")Integer id);
	/**
	 * �޸ĵ�����
	 * @param zanCount
	 * @param id
	 * @return
	 */
	int updateZanCount(@Param("zanCount")Integer zanCount,@Param("id")Integer id);

}
