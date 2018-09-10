package ssm.blog.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Page {
	private int currPage;  //当前页
	private int startRow;  //第一条记录
	private int totalPage; //总页数
	private int count;     //总记录数
	private int pageSize;  //每页显示数量
	private List<Blog> list; //用于存储每页显示的博客
	private List<Comment> commentList;	//用于存储每页显示的评论
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Blog> getList() {
		return list;
	}
	public void setList(List<Blog> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [currPage=" + currPage + ", totalPage=" + totalPage + ", count=" + count + ", pageSize=" + pageSize
				+ ", list=" + list + "]";
	}
	
}
