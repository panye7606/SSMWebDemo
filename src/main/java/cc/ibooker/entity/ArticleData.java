package cc.ibooker.entity;

/**
 * 文章信息类
 * 
 * @author 邹峰立
 */
public class ArticleData {
	private ArticleEntity article;
	private ArticleStyleEntity articleStyle;
	private ArticleTypeEntity articleType;

	public ArticleData() {
		super();
	}

	public ArticleData(ArticleEntity article, ArticleStyleEntity articleStyle,
			ArticleTypeEntity articleType) {
		super();
		this.article = article;
		this.articleStyle = articleStyle;
		this.articleType = articleType;
	}

	public ArticleEntity getArticle() {
		return article;
	}

	public void setArticle(ArticleEntity article) {
		this.article = article;
	}

	public ArticleStyleEntity getArticleStyle() {
		return articleStyle;
	}

	public void setArticleStyle(ArticleStyleEntity articleStyle) {
		this.articleStyle = articleStyle;
	}

	public ArticleTypeEntity getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleTypeEntity articleType) {
		this.articleType = articleType;
	}

	@Override
	public String toString() {
		return "ArticleData [article=" + article + ", articleStyle="
				+ articleStyle + ", articleType=" + articleType + "]";
	}

}
