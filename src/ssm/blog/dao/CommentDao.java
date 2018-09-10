package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.Comment;

public interface CommentDao {
	/**
	 * 查看全部评论
	 * @return
	 */
	List<Comment> getAllComment(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize);
	/**
	 * 查看全部评论数量
	 * @return
	 */
	int getAllCommentCount();
	/**
	 * 查看评论
	 * @param blogId
	 * @return
	 */
	List<Comment> getCommentByBlogId(Integer blogId);
	/**
	 * 发表评论
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	int deleteComment(Integer id);
}
