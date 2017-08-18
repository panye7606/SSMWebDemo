package cc.ibooker.entity;

import java.util.List;

/**
 * 文章表-实体类
 * 
 * @author 邹峰立
 */
public class ArticleEntity {
	private long aId;// 编号
	private String aTitle;// 文章标题
	private String aAbstract;// 文章摘要
	private long aPubtime;// 发布时间，时间戳',
	private String aCoverPath;// 文章封面图地址，格式：账号+时间戳+后缀（.png/.jpg等）
	private int aBrowsenum;// 浏览量
	private String aIsdelete;// 是否删除，0未删除，1删除
	private String aIsallow;// 是否审核通过，0未审核，1已审核
	private long aUid;// 用户ID
	private long aAtid;// 文章类别ID
	private List<ArticleAddrEntity> articleAddrs;// 原文地址
	/**
	 * 根据业务需要额外添加
	 */
	private String aFormatPubtime;// 格式化发布时间

	public ArticleEntity() {
		super();
	}

	public ArticleEntity(long aId, String aTitle, String aAbstract,
			long aPubtime, String aCoverPath, int aBrowsenum, String aIsdelete,
			String aIsallow, long aUid, long aAtid,
			List<ArticleAddrEntity> articleAddrs, String aFormatPubtime) {
		super();
		this.aId = aId;
		this.aTitle = aTitle;
		this.aAbstract = aAbstract;
		this.aPubtime = aPubtime;
		this.aCoverPath = aCoverPath;
		this.aBrowsenum = aBrowsenum;
		this.aIsdelete = aIsdelete;
		this.aIsallow = aIsallow;
		this.aUid = aUid;
		this.aAtid = aAtid;
		this.articleAddrs = articleAddrs;
		this.aFormatPubtime = aFormatPubtime;
	}

	public long getaId() {
		return aId;
	}

	public void setaId(long aId) {
		this.aId = aId;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaAbstract() {
		return aAbstract;
	}

	public void setaAbstract(String aAbstract) {
		this.aAbstract = aAbstract;
	}

	public long getaPubtime() {
		return aPubtime;
	}

	public void setaPubtime(long aPubtime) {
		this.aPubtime = aPubtime;
	}

	public String getaCoverPath() {
		return aCoverPath;
	}

	public void setaCoverPath(String aCoverPath) {
		this.aCoverPath = aCoverPath;
	}

	public int getaBrowsenum() {
		return aBrowsenum;
	}

	public void setaBrowsenum(int aBrowsenum) {
		this.aBrowsenum = aBrowsenum;
	}

	public String getaIsdelete() {
		return aIsdelete;
	}

	public void setaIsdelete(String aIsdelete) {
		this.aIsdelete = aIsdelete;
	}

	public String getaIsallow() {
		return aIsallow;
	}

	public void setaIsallow(String aIsallow) {
		this.aIsallow = aIsallow;
	}

	public long getaUid() {
		return aUid;
	}

	public void setaUid(long aUid) {
		this.aUid = aUid;
	}

	public long getaAtid() {
		return aAtid;
	}

	public void setaAtid(long aAtid) {
		this.aAtid = aAtid;
	}

	public List<ArticleAddrEntity> getArticleAddrs() {
		return articleAddrs;
	}

	public void setArticleAddrs(List<ArticleAddrEntity> articleAddrs) {
		this.articleAddrs = articleAddrs;
	}

	public String getaFormatPubtime() {
		return aFormatPubtime;
	}

	public void setaFormatPubtime(String aFormatPubtime) {
		this.aFormatPubtime = aFormatPubtime;
	}

	@Override
	public String toString() {
		return "ArticleEntity [aId=" + aId + ", aTitle=" + aTitle
				+ ", aAbstract=" + aAbstract + ", aPubtime=" + aPubtime
				+ ", aCoverPath=" + aCoverPath + ", aBrowsenum=" + aBrowsenum
				+ ", aIsdelete=" + aIsdelete + ", aIsallow=" + aIsallow
				+ ", aUid=" + aUid + ", aAtid=" + aAtid + ", articleAddrs="
				+ articleAddrs + ", aFormatPubtime=" + aFormatPubtime + "]";
	}

}
