package ssm.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ssm.blog.entity.Blogger;

@Repository //注册为持久层的bean
public interface BloggerDao {
	Blogger doRegister(String nickname);
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	Blogger doLogin(@Param("username")String username,@Param("password")String password);
    /**
     * 查询博主信息
     * @param id
     * @return
     */
    Blogger getBloggerData(Integer id);
    /**
     * 增加一个博主
     * @param blogger
     * @return
     */
    int addBlogger(Blogger blogger);
    /**
     * 修改博主信息
     * @param blogger
     * @return
     */
    int updateBlogger(Blogger blogger);
    /**
     * 删除一个博主
     * @param blogger
     * @return
     */
    int deleteBlogger(Integer id);
}
