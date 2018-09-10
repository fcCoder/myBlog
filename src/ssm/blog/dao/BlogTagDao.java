package ssm.blog.dao;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTag;

/**
 * 前后台对标签操作对关联表的影响
 * 前台对标签只能增加或删除
 * @author Administrator
 *
 */
public interface BlogTagDao {
	/**
	 * 查tagId
	 * @param tagName
	 * @return
	 */
	int getTagId(String tagName);
	/**
	 * 博客增加标签，关联表改变
	 * @param blogTag
	 * @return
	 */
	int addTag(BlogTag blogTag);
	/**
	 * 博客删除标签，关联表改变
	 * @param blogId
	 * @param tagId
	 * @return
	 */
	int deleteTag(@Param("blogId")Integer blogId,@Param("tagId")Integer tagId);
	/**
	 * 博客被删除，关联表改变
	 * @param blogId
	 * @return
	 */
	int deleteTagByBlogId(Integer blogId);
	/**
	 * 后台删除标签，关联表改变
	 * @param tagId
	 * @return
	 */
	int deleteTagByTagId(Integer tagId);
}
