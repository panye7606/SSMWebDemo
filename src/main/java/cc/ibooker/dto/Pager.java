package cc.ibooker.dto;

import java.util.List;

/**
 * 分页数据信息
 * 
 * @author 邹峰立
 * 
 * @param <T>
 */
public class Pager<T> {
	private int pageSize;// 每页显示多少条记录
	private int currentPage;// 当前第几页数据
	private int totalRecord;// 一共多少条记录
	private int totalPage;// 一共多少页
	private List<T> dataList;// 要显示的数据
	private String resultMsg;// 结果信息
	private int resultCode;// 结果状态码

	public Pager() {
		super();
	}

	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<T> dataList, String resultMsg, int resultCode) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
		this.resultMsg = resultMsg;
		this.resultCode = resultCode;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
				+ ", dataList=" + dataList + ", resultMsg=" + resultMsg
				+ ", resultCode=" + resultCode + "]";
	}

}
