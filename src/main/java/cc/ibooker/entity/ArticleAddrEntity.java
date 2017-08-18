package cc.ibooker.entity;

/**
 * 文章原文地址表-实体类
 * 
 * @author 邹峰立
 */
public class ArticleAddrEntity {
	private long aaId;// 编号
	private String aaOrganization;// 所属机构
	private String aaPath;// 文章原文地址
	private String aaIsdefault;// 是否为默认文章地址，0不是，1是
	private long aaAid;// 文章ID

	public ArticleAddrEntity() {
		super();
	}

	public ArticleAddrEntity(long aaId, String aaOrganization, String aaPath,
			String aaIsdefault, long aaAid) {
		super();
		this.aaId = aaId;
		this.aaOrganization = aaOrganization;
		this.aaPath = aaPath;
		this.aaIsdefault = aaIsdefault;
		this.aaAid = aaAid;
	}

	public long getAaId() {
		return aaId;
	}

	public void setAaId(long aaId) {
		this.aaId = aaId;
	}

	public String getAaOrganization() {
		return aaOrganization;
	}

	public void setAaOrganization(String aaOrganization) {
		this.aaOrganization = aaOrganization;
	}

	public String getAaPath() {
		return aaPath;
	}

	public void setAaPath(String aaPath) {
		this.aaPath = aaPath;
	}

	public String getAaIsdefault() {
		return aaIsdefault;
	}

	public void setAaIsdefault(String aaIsdefault) {
		this.aaIsdefault = aaIsdefault;
	}

	public long getAaAid() {
		return aaAid;
	}

	public void setAaAid(long aaAid) {
		this.aaAid = aaAid;
	}

	@Override
	public String toString() {
		return "ArticleAddrEntity [aaId=" + aaId + ", aaOrganization="
				+ aaOrganization + ", aaPath=" + aaPath + ", aaIsdefault="
				+ aaIsdefault + ", aaAid=" + aaAid + "]";
	}

}
