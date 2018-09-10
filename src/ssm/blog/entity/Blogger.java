package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component  //注册bean 为spring容器管理
public class Blogger{

    private Integer id;
    private String userName;    //用户名
    private String password;    //密码
    private String sex;    		//性别
    private Integer age;		//年龄
    private String nickName;    //昵称
    private String sign;        //博主签名
    private String imageName;   //图片路径

    public Blogger(String userName, String password, String sex, int age, String nickName, String sign, String imageName) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age=age;
        this.nickName = nickName;
        this.sign = sign;
        this.imageName = imageName;
    }

    public Blogger() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Blogger{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ",age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sign='" + sign + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
