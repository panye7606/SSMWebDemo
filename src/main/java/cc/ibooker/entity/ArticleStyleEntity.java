package cc.ibooker.entity;

/**
 * 文章分类表-实体类
 * 
 * @author 邹峰立
 */
public class ArticleStyleEntity {
	private long asId;// 编号
	private String asName;// 分类名
	private String asPinyin;// 分类名拼音

	public ArticleStyleEntity() {
		super();
	}

	public ArticleStyleEntity(long asId, String asName, String asPinyin) {
		super();
		this.asId = asId;
		this.asName = asName;
		this.asPinyin = asPinyin;
	}

	public long getAsId() {
		return asId;
	}

	public void setAsId(long asId) {
		this.asId = asId;
	}

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public String getAsPinyin() {
		return asPinyin;
	}

	public void setAsPinyin(String asPinyin) {
		this.asPinyin = asPinyin;
	}

	@Override
	public String toString() {
		return "ArticleStyleEntity [asId=" + asId + ", asName=" + asName
				+ ", asPinyin=" + asPinyin + "]";
	}

}
