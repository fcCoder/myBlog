package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component  //ע��bean Ϊspring��������
public class Blogger{

    private Integer id;
    private String userName;    //�û���
    private String password;    //����
    private String sex;    		//�Ա�
    private Integer age;		//����
    private String nickName;    //�ǳ�
    private String sign;        //����ǩ��
    private String imageName;   //ͼƬ·��

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
