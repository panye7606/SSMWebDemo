CREATE USER ibooker@localhost IDENTIFIED BY 'ibooker006008.';

CREATE DATABASE ibookerdata;

GRANT ALL ON ibookerdata.* TO ibooker@localhost;

#用户表
CREATE TABLE IF NOT EXISTS t_user(
u_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '编号',
u_phone BIGINT NOT NULL COMMENT '账号-手机号',
u_passwd VARCHAR(100) NOT NULL COMMENT '密码，4-20字符，MD5加密',
u_pic VARCHAR(100) DEFAULT 'http://localhost:8080/ibooker/images/pics/init_pic.png' COMMENT '头像，格式：账号+时间戳+后缀（.png/.jpg等）',
u_regtime BIGINT UNSIGNED NOT NULL COMMENT '注册时间，时间戳',
u_realname VARCHAR(15) DEFAULT '未填写' COMMENT '真实姓名，最多15个汉字',
u_sex ENUM('男','女','保密') DEFAULT '保密' COMMENT '性别',
u_height FLOAT(5,2) UNSIGNED DEFAULT 0 COMMENT '身高，单位CM',
u_weight FLOAT(6,2) UNSIGNED DEFAULT 0 COMMENT '体重，单位KG',
u_birthday VARCHAR(10) DEFAULT '未填写' COMMENT '出生日期，格式：yyyy-MM-dd',
u_domicile VARCHAR(50) DEFAULT '未填写' COMMENT '现居住地',
u_pointx DOUBLE UNSIGNED DEFAULT 0 COMMENT '现居住地-经度',
u_pointy DOUBLE UNSIGNED DEFAULT 0 COMMENT '现居住地-维度',
u_email VARCHAR(40) DEFAULT '未绑定' COMMENT '绑定邮箱账号',
u_weixin VARCHAR(40) DEFAULT '未绑定' COMMENT '绑定微信账号',
u_weibo VARCHAR(40) DEFAULT '未绑定' COMMENT '绑定微博账号',
u_qq VARCHAR(40) DEFAULT '未绑定' COMMENT '绑定QQ账号',
u_introduce VARCHAR(500) DEFAULT '未填写' COMMENT '自我简介，最多500个汉字',
u_inviter_phone VARCHAR(11) COMMENT '邀请人账号',
u_isboard ENUM('0','1') DEFAULT '0' COMMENT '基本信息是否对外公开，0不公开，1公开',
u_realname_identify_state ENUM('0','1','2','3') DEFAULT '0' COMMENT '实名认证状态，0未认证，1待认证，2已认证，3过期',
u_tx_token VARCHAR(200) COMMENT '即时通讯token',
u_type ENUM('0','11','12','13','14','15','2','3','4') NOT NULL DEFAULT '0' COMMENT '用户类型，0普通用户，11,12,13,14,15分别为爱书客一到五级用户，2普通管理员，3系统管理员，4高级管理员',
u_check_uid BIGINT UNSIGNED COMMENT '用户类型审核人员ID',
PRIMARY KEY(u_id) COMMENT '主键',
UNIQUE KEY(u_phone) COMMENT '唯一键',
FOREIGN KEY(u_check_uid) REFERENCES t_user(u_id) ON DELETE CASCADE,
KEY index_regtime(u_regtime) COMMENT '注册时间-索引',
KEY index_pointx(u_pointx) COMMENT '经度-索引',
KEY index_pointy(u_pointy) COMMENT '维度-索引',
KEY index_inviter_phone(u_inviter_phone) COMMENT '邀请人账号-索引',
KEY index_student_identify_state(u_student_identify_state) COMMENT '学生认证状态-索引',
KEY index_health_identify_state(u_health_identify_state) COMMENT '健康认证状态-索引',
KEY index_realname_identify_state(u_realname_identify_state) COMMENT '实名认证状态-索引'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户表';

#文章分类表
CREATE TABLE IF NOT EXISTS t_article_style(
as_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '编号',
as_name VARCHAR(20) NOT NULL COMMENT '分类名',
as_pinyin VARCHAR(20) NOT NULL COMMENT '分类名拼音',
PRIMARY KEY(as_id) COMMENT '主键',
UNIQUE KEY(as_name) COMMENT '唯一键',
KEY index_as_name(as_name) COMMENT '分类名-索引'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '文章分类表';

#文章类别表
CREATE TABLE IF NOT EXISTS t_article_type(
at_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '编号',
at_name VARCHAR(20) NOT NULL COMMENT '类别名',
at_name_desc VARCHAR(200) NOT NULL DEFAULT '未填写' COMMENT '类别描述信息',
at_pinyin VARCHAR(20) NOT NULL COMMENT '类别名拼音',
at_asid BIGINT UNSIGNED NOT NULL COMMENT '文章分类ID',
PRIMARY KEY(at_id) COMMENT '主键',
FOREIGN KEY(at_asid) REFERENCES t_article_style(as_id) ON DELETE CASCADE,
UNIQUE KEY(at_name) COMMENT '唯一键',
KEY index_at_name(at_name) COMMENT '类别名-索引'
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '文章类别表';

#文章表
CREATE TABLE IF NOT EXISTS t_article(
a_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '编号',
a_title VARCHAR(30) NOT NULL COMMENT '文章标题',
a_abstract VARCHAR(100) NOT NULL COMMENT '文章摘要',
a_pubtime BIGINT NOT NULL COMMENT '发布时间，时间戳',
a_cover_path VARCHAR(100) DEFAULT 'http://localhost:8080/ibooker/images/covers/init_cover.png' NOT NULL COMMENT '文章封面图地址，格式：账号+时间戳+后缀（.png/.jpg等）',
a_browsenum INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览量',
a_isdelete ENUM('0','1') DEFAULT '0' NOT NULL COMMENT '是否删除，0未删除，1删除',
a_isallow ENUM('0','1') DEFAULT '0' NOT NULL COMMENT '是否审核通过，0未审核，1已审核',
a_uid BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
a_atid BIGINT UNSIGNED NOT NULL COMMENT '文章类别ID',
PRIMARY KEY(a_id) COMMENT '主键',
FOREIGN KEY(a_atid) REFERENCES t_article_type(at_id) ON DELETE CASCADE,
FOREIGN KEY(a_uid) REFERENCES t_user(u_id) ON DELETE CASCADE
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '文章表';

#插入数据
INSERT INTO t_article(a_title, a_abstract, a_pubtime, a_cover_path, a_isallow, a_uid, a_atid)
VALUES
('测试主题1','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701401.jpg','1',1,1),
('测试主题2','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701402.jpg','1',1,1),
('测试主题3','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701403.jpg','1',1,1),
('测试主题4','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701404.jpg','1',1,1),
('测试主题5','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701405.jpg','1',1,1),
('测试主题6','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701406.jpg','1',1,1),
('测试主题7','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701407.jpg','1',1,1),
('测试主题8','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701408.jpg','1',1,1),
('测试主题9','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701409.jpg','1',1,1),
('测试主题10','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701410.jpg','1',1,1),
('测试主题11','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701411.jpg','1',1,1),
('测试主题12','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701412.jpg','1',1,1),
('测试主题13','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701413.jpg','1',1,1),
('测试主题14','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701414.jpg','1',1,1),
('测试主题15','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701415.jpg','1',1,1),
('测试主题16','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701416.jpg','1',1,1),
('测试主题17','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701417.jpg','1',1,1),
('测试主题18','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701418.jpg','1',1,1),
('测试主题19','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701419.jpg','1',1,1),
('测试主题20','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701420.jpg','1',1,1),
('测试主题21','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701421.jpg','1',1,1),
('测试主题22','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701422.jpg','1',1,1),
('测试主题23','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701423.jpg','1',1,1),
('测试主题24','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701424.jpg','1',1,1),
('测试主题25','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701425.jpg','1',1,1),
('测试主题26','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701426.jpg','1',1,1),
('测试主题27','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701427.jpg','1',1,1),
('测试主题28','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701428.jpg','1',1,1),
('测试主题29','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701429.jpg','1',1,1),
('测试主题30','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701430.jpg','1',1,1),
('测试主题31','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701431.jpg','1',1,1),
('测试主题32','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701432.jpg','1',1,1),
('测试主题33','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701433.jpg','1',1,1),
('测试主题34','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701434.jpg','1',1,1),
('测试主题35','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701435.jpg','1',1,1),
('测试主题36','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701436.jpg','1',1,1),
('测试主题37','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701437.jpg','1',1,1),
('测试主题38','测试描述',1234,'http://localhost:8080/ibooker/images/covers/153087390131502694701438.jpg','1',1,1);

#文章原文地址表
CREATE TABLE IF NOT EXISTS t_article_addr(
aa_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '编号',
aa_organization VARCHAR(50) NOT NULL COMMENT '所属机构',
aa_path VARCHAR(100) NOT NULL COMMENT '文章原文地址',
aa_isdefault ENUM('0','1') DEFAULT '0' NOT NULL COMMENT '是否为默认文章地址，0不是，1是',
aa_aid BIGINT UNSIGNED NOT NULL COMMENT '文章ID',
PRIMARY KEY(aa_id) COMMENT '主键',
FOREIGN KEY(aa_aid) REFERENCES t_article(a_id) ON DELETE CASCADE
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '文章原文地址表';


