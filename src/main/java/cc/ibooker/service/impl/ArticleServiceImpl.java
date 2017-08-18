package cc.ibooker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cc.ibooker.dao.ArticleDao;
import cc.ibooker.dto.Pager;
import cc.ibooker.dto.ResultData;
import cc.ibooker.entity.ArticleData;
import cc.ibooker.entity.ArticleEntity;
import cc.ibooker.entity.ArticleUserData;
import cc.ibooker.entity.UserEntity;
import cc.ibooker.enums.IdentifyStateEnum;
import cc.ibooker.service.ArticleService;
import cc.ibooker.utils.ConstanceUtil;
import cc.ibooker.utils.DateUtil;

/**
 * Article业务接口实现类
 * 
 * Spring事务，只有运行期异常采用执行事务。
 * 
 * @author 邹峰立
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Resource
	private ArticleDao articleDao;
	
	/**
	 * 查询文章列表
	 * 
	 * @param aIsdelete 是否删除，0未删除，1删除
	 * @param aIsallow 是否审核通过，0未审核，1已审核
	 * @param page 当前页
	 * @param pageSize 每页显示的数量
	 * @return
	 */
	@Override
	public Pager<ArticleData> getArticleDataListPager(String aIsdelete,
			String aIsallow, int page, int pageSize) {
		
		int totalRecord = 0;
		int totalPage = 0;
		String resultMsg = null;
		int resultCode = -1;
		List<ArticleData> data = null;
		if (page <= 0
				|| pageSize <= 0
				|| pageSize > 50) {
			resultMsg = ConstanceUtil.RESULT_INPUT_ERROR_MSG;
			resultCode = ConstanceUtil.RESULT_INPUT_ERROR_CODE;
		} else {
			int limitStart = (page -1) * pageSize;
			int limitCount = pageSize;
			// 查询文章列表数据
			data = articleDao.queryArticleDataList(aIsdelete, aIsallow, limitStart, limitCount);
			if (data == null) {
				resultMsg = ConstanceUtil.RESULT_QUERY_FAILED_MSG;
				resultCode = ConstanceUtil.RESULT_QUERY_FAILED_CODE;
			} else if (data.size() <= 0) {
				resultMsg = ConstanceUtil.RESULT_QUERY_EMPTY_MSG;
				resultCode = ConstanceUtil.RESULT_QUERY_EMPTY_CODE;
			} else {
				// 查询文章列表数据总数
				totalRecord = articleDao.queryArticleDataListCount(aIsdelete, aIsallow);
				// 总页数
				totalPage = totalRecord / pageSize;
				if (totalRecord % pageSize != 0) {
					totalPage++;
				}
				
				// 修改查询任务结果
				for (int i = 0; i < data.size(); i++) {
					ArticleData articleData = data.get(i);
					if (articleData != null) {
						ArticleEntity article = articleData.getArticle();
						if (article != null) {
							// 刷新数据
							article.setaFormatPubtime(DateUtil.getFormatTimeStampToDateTime(article.getaPubtime()));
							articleData.setArticle(article);
							data.set(i, articleData);
						}
					}
				}
				
				resultMsg = ConstanceUtil.RESULT_SUCCESS_MSG;
				resultCode = ConstanceUtil.RESULT_SUCCESS_CODE;
			}
		}
		return new Pager<>(pageSize, page, totalRecord, totalPage, data, resultMsg, resultCode);
	}

	/**
	 * 根据文章ID查询文章详情
	 * 
	 * @param aId 文章ID
	 * @return
	 */
	@Override
	public ResultData<ArticleUserData> getArticleUserDataById(long aId) {
		
		String resultMsg = null;
		int resultCode = -1;
		ArticleUserData data = null;
		if (aId <= 0) {
			resultMsg = ConstanceUtil.RESULT_INPUT_ERROR_MSG;
			resultCode = ConstanceUtil.RESULT_INPUT_ERROR_CODE;
		} else {
			// 查询文章数据
			data = articleDao.queryArticleUserDataById(aId);
			if (data == null) {
				resultMsg = ConstanceUtil.RESULT_QUERY_FAILED_MSG;
				resultCode = ConstanceUtil.RESULT_QUERY_FAILED_CODE;
			} else {
				// 修改查询任务结果
				ArticleEntity article = data.getArticle();
				if (article != null) {
					// 刷新数据
					article.setaFormatPubtime(DateUtil.getFormatTimeStampToDateTime(article.getaPubtime()));
					data.setArticle(article);
				}
				UserEntity user = data.getUser();
				if (user != null) {
					// 刷新数据
					user.setuFormatRealnameIdentifyState(IdentifyStateEnum.stateInfoOf(user.getuRealnameIdentifyState()));
					user.setuRegDays(DateUtil.getTimeStampDistanceDays(user.getuRegtime(), DateUtil.getTimeStamp()) + "天");
				}
				
				resultMsg = ConstanceUtil.RESULT_SUCCESS_MSG;
				resultCode = ConstanceUtil.RESULT_SUCCESS_CODE;
			}
		}
		return new ResultData<ArticleUserData>(resultCode, resultMsg, data);
	}

}
