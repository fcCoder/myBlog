package ssm.blog.dao;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTag;

/**
 * ǰ��̨�Ա�ǩ�����Թ������Ӱ��
 * ǰ̨�Ա�ǩֻ�����ӻ�ɾ��
 * @author Administrator
 *
 */
public interface BlogTagDao {
	/**
	 * ��tagId
	 * @param tagName
	 * @return
	 */
	int getTagId(String tagName);
	/**
	 * �������ӱ�ǩ��������ı�
	 * @param blogTag
	 * @return
	 */
	int addTag(BlogTag blogTag);
	/**
	 * ����ɾ����ǩ��������ı�
	 * @param blogId
	 * @param tagId
	 * @return
	 */
	int deleteTag(@Param("blogId")Integer blogId,@Param("tagId")Integer tagId);
	/**
	 * ���ͱ�ɾ����������ı�
	 * @param blogId
	 * @return
	 */
	int deleteTagByBlogId(Integer blogId);
	/**
	 * ��̨ɾ����ǩ��������ı�
	 * @param tagId
	 * @return
	 */
	int deleteTagByTagId(Integer tagId);
}
