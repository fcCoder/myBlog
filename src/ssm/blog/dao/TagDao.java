package ssm.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.blog.entity.Tag;

@Repository
public interface TagDao {
	/**
	 * ��ѯ���б�ǩ
	 * @return
	 */
	List<Tag> getAllTag();
	/**
	 * ��ѯĳ�����������б�ǩ
	 * @param bloggerId
	 * @return
	 */
	List<Tag> getTagByBlogger(Integer bloggerId);
	/**
	 * ��ѯĳ�����͵����б�ǩ
	 * @param BlogId
	 * @return
	 */
	List<Tag> getTagByBlog(Integer blogId);
	/**
	 * ���ݱ�ǩ�����ұ�ǩ
	 * @param tagName
	 * @return
	 */
	Tag getTagByName(String tagName);
	/**
	 * �����µı�ǩ
	 * @param tag
	 * @return
	 */
	int addTag(String tagName);
	/**
	 * �޸ı�ǩ
	 * @param tag
	 * @return
	 */
	int updateTag(Tag tag);
	/**
	 * ɾ����ǩ
	 * @param id
	 * @return
	 */
	int deleteTag(Integer id);
}
