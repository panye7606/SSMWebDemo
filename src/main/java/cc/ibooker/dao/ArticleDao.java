package cc.ibooker.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cc.ibooker.entity.ArticleData;
import cc.ibooker.entity.ArticleUserData;

/**
 * 文章表-接口类
 * 
 * @author 邹峰立
 */
public interface ArticleDao {
	
	/**
	 * 查询文章信息列表-总数
	 * 
	 * @param aIsdelete 是否删除，0未删除，1删除
	 * @param aIsallow 是否审核通过，0未审核，1已审核
	 * @return
	 */
	int queryArticleDataListCount(
			@Param("a_isdelete") String aIsdelete,
			@Param("a_isallow") String aIsallow);
	
	/**
	 * 查询文章信息列表
	 * 
	 * @param aIsdelete 是否删除，0未删除，1删除
	 * @param aIsallow 是否审核通过，0未审核，1已审核
	 * @param limitStart 起始行
	 * @param limitCount 每页显示的数量
	 * @return
	 */
	ArrayList<ArticleData> queryArticleDataList(
			@Param("a_isdelete") String aIsdelete,
			@Param("a_isallow") String aIsallow,
			@Param("limit_start") int limitStart,
			@Param("limit_count") int limitCount);

	/**
	 * 根据文章ID查询文章详情
	 * 
	 * @param aId 文章ID
	 * @return
	 */
	ArticleUserData queryArticleUserDataById(@Param("a_id") long aId);
}
