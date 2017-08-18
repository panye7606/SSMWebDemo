package cc.ibooker.entity;

/**
 * 文章信息类
 * 
 * @author 邹峰立
 */
public class ArticleUserData {
	private ArticleEntity article;
	private ArticleStyleEntity articleStyle;
	private ArticleTypeEntity articleType;
	private UserEntity user;

	public ArticleUserData() {
		super();
	}

	public ArticleUserData(ArticleEntity article,
			ArticleStyleEntity articleStyle, ArticleTypeEntity articleType,
			UserEntity user) {
		super();
		this.article = article;
		this.articleStyle = articleStyle;
		this.articleType = articleType;
		this.user = user;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ArticleUserData [article=" + article + ", articleStyle="
				+ articleStyle + ", articleType=" + articleType + ", user="
				+ user + "]";
	}

}
