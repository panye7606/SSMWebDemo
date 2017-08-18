package cc.ibooker.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.ibooker.dto.Pager;
import cc.ibooker.dto.ResultData;
import cc.ibooker.entity.ArticleData;
import cc.ibooker.entity.ArticleUserData;
import cc.ibooker.service.ArticleService;
import cc.ibooker.utils.ConstanceUtil;

/**
 * Article文章Controller
 * 
 * @author 邹峰立
 */
@Controller
@RequestMapping("/web/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	/**
	 * 查询文章列表
	 * 
	 * @param page 当前页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{page}")
	public String getArticleDataListPager(
			@PathVariable(name = "page", required = true) int page,
			Model model) {
		// 查询数据
		Pager<ArticleData> articleDataPager = articleService.getArticleDataListPager(
				ConstanceUtil.ARTICLE_ISDELETE_NO, // 未删除
				ConstanceUtil.ARTICLE_ISALLOW_YES, // 已审核 
				page, // 当前页
				ConstanceUtil.PAGE_SIZE // 每页显示数量
			);
		model.addAttribute("articleDataPager", articleDataPager);
		return "web/index";
	}
	
	/**
	 * 根据文章ID查询文章详情
	 * 
	 * @param aId 文章ID
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{aId}/detail")
	public String getArticleUserDataById(
			@PathVariable(name = "aId", required = true) long aId,
			Model model) {
		// 查询数据
		ResultData<ArticleUserData> articleUserDataResult = articleService.getArticleUserDataById(aId);
		model.addAttribute("articleUserDataResult", articleUserDataResult);
		return "web/article_detail";
	}
}
