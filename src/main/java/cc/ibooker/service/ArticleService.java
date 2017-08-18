package cc.ibooker.service;

import cc.ibooker.dto.Pager;
import cc.ibooker.dto.ResultData;
import cc.ibooker.entity.ArticleData;
import cc.ibooker.entity.ArticleUserData;

/**
 * Article业务接口
 * 
 * @author 邹峰立
 *
 */
public interface ArticleService {
	
	/**
	 * 查询文章列表
	 * 
	 * @param aIsdelete 是否删除，0未删除，1删除
	 * @param aIsallow 是否审核通过，0未审核，1已审核
	 * @param page 当前页
	 * @param pageSize 每页显示的数量
	 * @return
	 */
	Pager<ArticleData> getArticleDataListPager(String aIsdelete, String aIsallow,
			int page, int pageSize);
	
	/**
	 * 根据文章ID查询文章详情
	 * 
	 * @param aId 文章ID
	 * @return
	 */
	ResultData<ArticleUserData> getArticleUserDataById(long aId);
}
