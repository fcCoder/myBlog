package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ssm.blog.entity.Blog;

@Repository
public interface BlogDao {
	/**
	 * 获得最新插入的博客id
	 * 必须在执行完插入操作后执行，否则返回0
	 * 相对于max(id)函数，LAST_INSERT_ID()函数是线程安全的
	 * @return
	 */
	int selectLastBlogId();
	/**
	 * 查询博客总数
	 * @return
	 */
	int selectBlogCount();
	/**
	 * 分页查询所有博客
	 * @param startRow	第一条记录
	 * @param pageSize	每页记录数量
	 * @return
	 */
	List<Blog> selectBlogByPage(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize);
	/**
	 * 分页查询我的所有博客
	 * @param startRow	第一条记录
	 * @param pageSize	每页记录数量
	 * @return
	 */
	List<Blog> selectMyBlogByPage(@Param("startRow")Integer startRow,@Param("pageSize")Integer pageSize,@Param("bloggerId")Integer bloggerId);
	/**
	 * 查询阅读数前十的博客
	 * @return
	 */
	List<Blog> selectBlogByReadCount();
	/**
	 * 查询某个博主的所有博客
	 * @param bloggerId
	 * @return
	 */
	List<Blog> selectBlogByBlogger(Integer bloggerId);
	/**
	 * 根据类别查询博客
	 * @param typeId
	 * @return
	 */
	List<Blog> selectBlogByType(Integer typeId);
	/**
	 * 根据标签查询博客
	 * @param tagId
	 * @return
	 */
	List<Blog> selectBlogByTag(Integer tagId);
	/**
	 * 查看博客
	 * @param id
	 * @return
	 */
	Blog selectBlogById(Integer id);
	/**
	 * 新增博客
	 * @param blog
	 * @return
	 */
	int addBlog(Blog blog);
	/**
	 * 删除博客
	 * @param id
	 * @return
	 */
	int deleteBlog(Integer id);
	/**
	 * 修改博客(名字，内容，类型)，其他字段不能随意修改
	 * @param blog
	 * @return
	 */
	int updateBlog(Blog blog);
	/**
	 * 修改评论数
	 * @param clickHit
	 * @param id
	 * @return
	 */
	int updateClickHit(@Param("clickHit")Integer clickHit,@Param("id")Integer id);
	/**
	 * 修改阅读次数
	 * @param readCount
	 * @param id
	 * @return
	 */
	int updateReadCount(@Param("readCount")Integer readCount,@Param("id")Integer id);
	/**
	 * 修改点赞数
	 * @param zanCount
	 * @param id
	 * @return
	 */
	int updateZanCount(@Param("zanCount")Integer zanCount,@Param("id")Integer id);

}
