package cc.ibooker.dao;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.ibooker.entity.ArticleData;
import cc.ibooker.utils.DateUtil;

/**
 * TaskDao进行单元测试
 * 
 * @author 邹峰立
 */
// 配置spring和junit整合，junit启动时加载spring IOC容器 包依赖spring-test,junit
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class ArticleDaoTest {

	// 注入Dao实现类依赖
	@Autowired
	private ArticleDao articleDao;

	@Test
	public void testQueryArticleList() throws Exception {
		ArrayList<ArticleData> list = articleDao.queryArticleDataList("0", "1", 1, 15);
		System.out.println(list);
		System.out.println(DateUtil.getTimeStamp());
	}
}
