package cc.ibooker.utils;

/**
 * 常量管理类
 * 
 * @author 邹峰立
 */
public class ConstanceUtil {
	/**
	 * 数据操作状态
	 */
	// 成功
	public static final int RESULT_SUCCESS_CODE = 0;
	public static final String RESULT_SUCCESS_MSG = "成功";
	// 传入值错误
	public static final int RESULT_INPUT_ERROR_CODE = 1;
	public static final String RESULT_INPUT_ERROR_MSG = "传入值错误";
	// 未查询到任何数据
	public static final int RESULT_QUERY_EMPTY_CODE = 2;
	public static final String RESULT_QUERY_EMPTY_MSG = "未查询到任何数据";
	// 查询数据失败
	public static final int RESULT_QUERY_FAILED_CODE = 3;
	public static final String RESULT_QUERY_FAILED_MSG = "查询数据失败";

	/**
	 * 文章状态
	 */
	public static final String ARTICLE_ISDELETE_NO = "0";// 未删除
	public static final String ARTICLE_ISDELETE_YES = "1";// 已删除
	public static final String ARTICLE_ISALLOW_NO = "0";// 未审核
	public static final String ARTICLE_ISALLOW_YES = "1";// 已审核

	/**
	 * 数量
	 */
	public static final int PAGE_SIZE = 15;// 默认分页数量
}
