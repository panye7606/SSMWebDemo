package cc.ibooker.entity;

/**
 * 用户表-实体类
 * 
 * @author 邹峰立
 */
public class UserEntity {
	private long uId;// 编号
	private long uPhone;// 账号-手机号
	private String uPasswd;// 密码，4-20字符，MD5加密
	private String uPic;// 头像，格式：账号+时间戳+后缀（.png/.jpg等）
	private long uRegtime;// 注册时间，时间戳
	private String uRealname;// 真实姓名，最多15个汉字
	private String uSex;// 性别
	private float uHeight;// 身高，单位CM
	private float uWeight;// 体重，单位KG
	private String uBirthday;// 出生日期，格式：yyyy-MM-dd
	private String uDomicile;// 现居住地
	private double uPointx;// 现居住地-经度
	private double uPointy;// 现居住地-维度
	private String uEmail;// 绑定邮箱账号
	private String uWeixin;// 绑定微信账号
	private String uWeibo;// 绑定微博账号
	private String uQq;// 绑定QQ账号
	private String uIntroduce;// 自我简介，最多500个汉字
	private String uInviterPhone;// 邀请人账号
	private String uIsboard;// 基本信息是否对外公开，0不公开，1公开
	private String uRealnameIdentifyState;// 实名认证状态，0未认证，1待认证，2已认证，3过期
	private String uTxToken;// 即时通讯token
	private String uType;// 用户类型，0普通用户，11,12,13,14,15分别为爱书客一到五级用户，2普通管理员，3系统管理员，4高级管理员
	private long uCheckUid;// 用户类型审核人员ID
	/**
	 * 业务需求额外添加数据
	 */
	private String uToken;// Token数据JSON
	private String uIsvip;// 是否为会员，0不是会员，1是会员
	private String uIsfrozen;// 当前账号是否被冻结，0未冻结，1冻结
	private String uFormatRegtime;// 格式化注册时间
	private String uRegDays;// 注册天数
	private String uFormatEmail;// 格式化邮箱
	private String uFormatHeight;// 格式化身高
	private String uFormatWeight;// 格式化体重
	private String uForamtType;// 格式化用户类型
	private String uFormatRealnameIdentifyState;// 格式化实名认证状态

	public UserEntity() {
		super();
	}

	public UserEntity(long uId, long uPhone, String uPasswd, String uPic,
			long uRegtime, String uRealname, String uSex, float uHeight,
			float uWeight, String uBirthday, String uDomicile, double uPointx,
			double uPointy, String uEmail, String uWeixin, String uWeibo,
			String uQq, String uIntroduce, String uInviterPhone,
			String uIsboard, String uRealnameIdentifyState, String uTxToken,
			String uType, long uCheckUid) {
		super();
		this.uId = uId;
		this.uPhone = uPhone;
		this.uPasswd = uPasswd;
		this.uPic = uPic;
		this.uRegtime = uRegtime;
		this.uRealname = uRealname;
		this.uSex = uSex;
		this.uHeight = uHeight;
		this.uWeight = uWeight;
		this.uBirthday = uBirthday;
		this.uDomicile = uDomicile;
		this.uPointx = uPointx;
		this.uPointy = uPointy;
		this.uEmail = uEmail;
		this.uWeixin = uWeixin;
		this.uWeibo = uWeibo;
		this.uQq = uQq;
		this.uIntroduce = uIntroduce;
		this.uInviterPhone = uInviterPhone;
		this.uIsboard = uIsboard;
		this.uRealnameIdentifyState = uRealnameIdentifyState;
		this.uTxToken = uTxToken;
		this.uType = uType;
		this.uCheckUid = uCheckUid;
	}

	public UserEntity(long uId, long uPhone, String uPasswd, String uPic,
			long uRegtime, String uRealname, String uSex, float uHeight,
			float uWeight, String uBirthday, String uDomicile, double uPointx,
			double uPointy, String uEmail, String uWeixin, String uWeibo,
			String uQq, String uIntroduce, String uInviterPhone,
			String uIsboard, String uRealnameIdentifyState, String uTxToken,
			String uType, long uCheckUid, String uToken, String uIsvip,
			String uIsfrozen, String uFormatRegtime, String uRegDays,
			String uFormatEmail, String uFormatHeight, String uFormatWeight,
			String uForamtType, String uFormatRealnameIdentifyState) {
		super();
		this.uId = uId;
		this.uPhone = uPhone;
		this.uPasswd = uPasswd;
		this.uPic = uPic;
		this.uRegtime = uRegtime;
		this.uRealname = uRealname;
		this.uSex = uSex;
		this.uHeight = uHeight;
		this.uWeight = uWeight;
		this.uBirthday = uBirthday;
		this.uDomicile = uDomicile;
		this.uPointx = uPointx;
		this.uPointy = uPointy;
		this.uEmail = uEmail;
		this.uWeixin = uWeixin;
		this.uWeibo = uWeibo;
		this.uQq = uQq;
		this.uIntroduce = uIntroduce;
		this.uInviterPhone = uInviterPhone;
		this.uIsboard = uIsboard;
		this.uRealnameIdentifyState = uRealnameIdentifyState;
		this.uTxToken = uTxToken;
		this.uType = uType;
		this.uCheckUid = uCheckUid;
		this.uToken = uToken;
		this.uIsvip = uIsvip;
		this.uIsfrozen = uIsfrozen;
		this.uFormatRegtime = uFormatRegtime;
		this.uRegDays = uRegDays;
		this.uFormatEmail = uFormatEmail;
		this.uFormatHeight = uFormatHeight;
		this.uFormatWeight = uFormatWeight;
		this.uForamtType = uForamtType;
		this.uFormatRealnameIdentifyState = uFormatRealnameIdentifyState;
	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public long getuPhone() {
		return uPhone;
	}

	public void setuPhone(long uPhone) {
		this.uPhone = uPhone;
	}

	public String getuPasswd() {
		return uPasswd;
	}

	public void setuPasswd(String uPasswd) {
		this.uPasswd = uPasswd;
	}

	public String getuPic() {
		return uPic;
	}

	public void setuPic(String uPic) {
		this.uPic = uPic;
	}

	public long getuRegtime() {
		return uRegtime;
	}

	public void setuRegtime(long uRegtime) {
		this.uRegtime = uRegtime;
	}

	public String getuRealname() {
		return uRealname;
	}

	public void setuRealname(String uRealname) {
		this.uRealname = uRealname;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public float getuHeight() {
		return uHeight;
	}

	public void setuHeight(float uHeight) {
		this.uHeight = uHeight;
	}

	public float getuWeight() {
		return uWeight;
	}

	public void setuWeight(float uWeight) {
		this.uWeight = uWeight;
	}

	public String getuBirthday() {
		return uBirthday;
	}

	public void setuBirthday(String uBirthday) {
		this.uBirthday = uBirthday;
	}

	public String getuDomicile() {
		return uDomicile;
	}

	public void setuDomicile(String uDomicile) {
		this.uDomicile = uDomicile;
	}

	public double getuPointx() {
		return uPointx;
	}

	public void setuPointx(double uPointx) {
		this.uPointx = uPointx;
	}

	public double getuPointy() {
		return uPointy;
	}

	public void setuPointy(double uPointy) {
		this.uPointy = uPointy;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuWeixin() {
		return uWeixin;
	}

	public void setuWeixin(String uWeixin) {
		this.uWeixin = uWeixin;
	}

	public String getuWeibo() {
		return uWeibo;
	}

	public void setuWeibo(String uWeibo) {
		this.uWeibo = uWeibo;
	}

	public String getuQq() {
		return uQq;
	}

	public void setuQq(String uQq) {
		this.uQq = uQq;
	}

	public String getuIntroduce() {
		return uIntroduce;
	}

	public void setuIntroduce(String uIntroduce) {
		this.uIntroduce = uIntroduce;
	}

	public String getuInviterPhone() {
		return uInviterPhone;
	}

	public void setuInviterPhone(String uInviterPhone) {
		this.uInviterPhone = uInviterPhone;
	}

	public String getuIsboard() {
		return uIsboard;
	}

	public void setuIsboard(String uIsboard) {
		this.uIsboard = uIsboard;
	}

	public String getuRealnameIdentifyState() {
		return uRealnameIdentifyState;
	}

	public void setuRealnameIdentifyState(String uRealnameIdentifyState) {
		this.uRealnameIdentifyState = uRealnameIdentifyState;
	}

	public String getuTxToken() {
		return uTxToken;
	}

	public void setuTxToken(String uTxToken) {
		this.uTxToken = uTxToken;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public long getuCheckUid() {
		return uCheckUid;
	}

	public void setuCheckUid(long uCheckUid) {
		this.uCheckUid = uCheckUid;
	}

	public String getuToken() {
		return uToken;
	}

	public void setuToken(String uToken) {
		this.uToken = uToken;
	}

	public String getuIsvip() {
		return uIsvip;
	}

	public void setuIsvip(String uIsvip) {
		this.uIsvip = uIsvip;
	}

	public String getuIsfrozen() {
		return uIsfrozen;
	}

	public void setuIsfrozen(String uIsfrozen) {
		this.uIsfrozen = uIsfrozen;
	}

	public String getuFormatRegtime() {
		return uFormatRegtime;
	}

	public void setuFormatRegtime(String uFormatRegtime) {
		this.uFormatRegtime = uFormatRegtime;
	}

	public String getuRegDays() {
		return uRegDays;
	}

	public void setuRegDays(String uRegDays) {
		this.uRegDays = uRegDays;
	}

	public String getuFormatEmail() {
		return uFormatEmail;
	}

	public void setuFormatEmail(String uFormatEmail) {
		this.uFormatEmail = uFormatEmail;
	}

	public String getuFormatHeight() {
		return uFormatHeight;
	}

	public void setuFormatHeight(String uFormatHeight) {
		this.uFormatHeight = uFormatHeight;
	}

	public String getuFormatWeight() {
		return uFormatWeight;
	}

	public void setuFormatWeight(String uFormatWeight) {
		this.uFormatWeight = uFormatWeight;
	}

	public String getuForamtType() {
		return uForamtType;
	}

	public void setuForamtType(String uForamtType) {
		this.uForamtType = uForamtType;
	}

	public String getuFormatRealnameIdentifyState() {
		return uFormatRealnameIdentifyState;
	}

	public void setuFormatRealnameIdentifyState(
			String uFormatRealnameIdentifyState) {
		this.uFormatRealnameIdentifyState = uFormatRealnameIdentifyState;
	}

	@Override
	public String toString() {
		return "UserEntity [uId=" + uId + ", uPhone=" + uPhone + ", uPasswd="
				+ uPasswd + ", uPic=" + uPic + ", uRegtime=" + uRegtime
				+ ", uRealname=" + uRealname + ", uSex=" + uSex + ", uHeight="
				+ uHeight + ", uWeight=" + uWeight + ", uBirthday=" + uBirthday
				+ ", uDomicile=" + uDomicile + ", uPointx=" + uPointx
				+ ", uPointy=" + uPointy + ", uEmail=" + uEmail + ", uWeixin="
				+ uWeixin + ", uWeibo=" + uWeibo + ", uQq=" + uQq
				+ ", uIntroduce=" + uIntroduce + ", uInviterPhone="
				+ uInviterPhone + ", uIsboard=" + uIsboard
				+ ", uRealnameIdentifyState=" + uRealnameIdentifyState
				+ ", uTxToken=" + uTxToken + ", uType=" + uType
				+ ", uCheckUid=" + uCheckUid + ", uToken=" + uToken
				+ ", uIsvip=" + uIsvip + ", uIsfrozen=" + uIsfrozen
				+ ", uFormatRegtime=" + uFormatRegtime + ", uRegDays="
				+ uRegDays + ", uFormatEmail=" + uFormatEmail
				+ ", uFormatHeight=" + uFormatHeight + ", uFormatWeight="
				+ uFormatWeight + ", uForamtType=" + uForamtType
				+ ", uFormatRealnameIdentifyState="
				+ uFormatRealnameIdentifyState + "]";
	}

}
