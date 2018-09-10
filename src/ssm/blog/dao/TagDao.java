package ssm.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.blog.entity.Tag;

@Repository
public interface TagDao {
	/**
	 * 查询所有标签
	 * @return
	 */
	List<Tag> getAllTag();
	/**
	 * 查询某个博主的所有标签
	 * @param bloggerId
	 * @return
	 */
	List<Tag> getTagByBlogger(Integer bloggerId);
	/**
	 * 查询某个博客的所有标签
	 * @param BlogId
	 * @return
	 */
	List<Tag> getTagByBlog(Integer blogId);
	/**
	 * 根据标签名查找标签
	 * @param tagName
	 * @return
	 */
	Tag getTagByName(String tagName);
	/**
	 * 增加新的标签
	 * @param tag
	 * @return
	 */
	int addTag(String tagName);
	/**
	 * 修改标签
	 * @param tag
	 * @return
	 */
	int updateTag(Tag tag);
	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	int deleteTag(Integer id);
}
