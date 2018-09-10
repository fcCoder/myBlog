package ssm.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ssm.blog.entity.Blogger;

@Repository //ע��Ϊ�־ò��bean
public interface BloggerDao {
	Blogger doRegister(String nickname);
	/**
	 * ��¼��֤
	 * @param username
	 * @param password
	 * @return
	 */
	Blogger doLogin(@Param("username")String username,@Param("password")String password);
    /**
     * ��ѯ������Ϣ
     * @param id
     * @return
     */
    Blogger getBloggerData(Integer id);
    /**
     * ����һ������
     * @param blogger
     * @return
     */
    int addBlogger(Blogger blogger);
    /**
     * �޸Ĳ�����Ϣ
     * @param blogger
     * @return
     */
    int updateBlogger(Blogger blogger);
    /**
     * ɾ��һ������
     * @param blogger
     * @return
     */
    int deleteBlogger(Integer id);
}
