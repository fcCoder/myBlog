package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.Comment;

public interface CommentDao {
	/**
	 * �鿴ȫ������
	 * @return
	 */
	List<Comment> getAllComment(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize);
	/**
	 * �鿴ȫ����������
	 * @return
	 */
	int getAllCommentCount();
	/**
	 * �鿴����
	 * @param blogId
	 * @return
	 */
	List<Comment> getCommentByBlogId(Integer blogId);
	/**
	 * ��������
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	int deleteComment(Integer id);
}
