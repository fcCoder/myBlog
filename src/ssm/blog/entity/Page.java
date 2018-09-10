package ssm.blog.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Page {
	private int currPage;  //��ǰҳ
	private int startRow;  //��һ����¼
	private int totalPage; //��ҳ��
	private int count;     //�ܼ�¼��
	private int pageSize;  //ÿҳ��ʾ����
	private List<Blog> list; //���ڴ洢ÿҳ��ʾ�Ĳ���
	private List<Comment> commentList;	//���ڴ洢ÿҳ��ʾ������
	
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
