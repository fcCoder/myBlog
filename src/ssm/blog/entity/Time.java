package ssm.blog.entity;

import org.springframework.stereotype.Component;

/**
 * 对应时间轴
 * @author Administrator
 *
 */
@Component
public class Time {
	private String year;
	private String day;
	private String title;
	private Integer id;
	public Time() {}
	public Time(String day,String title){
		this.day=day;
		this.title=title;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Time [year=" + year + ", day=" + day + ", title=" + title + "]";
	}
	
}
