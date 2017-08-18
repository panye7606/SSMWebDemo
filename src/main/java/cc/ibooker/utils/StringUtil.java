package cc.ibooker.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串管理类
 * 
 * @author 邹峰立
 */
public class StringUtil {

	// 判断字符串为空
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "null".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 去掉指定字符串的开头和结尾的指定字符
	 * 
	 * @param stream
	 *            要处理的字符串
	 * @param trimstr
	 *            要去掉的字符串
	 * @return 处理后的字符串
	 */
	public static String sideTrim(String stream, String trimstr) {
		// null或者空字符串的时候不处理
		if (StringUtil.isEmpty(stream) || StringUtil.isEmpty(trimstr)) {
			return stream;
		}
		// 结束位置
		int epos = 0;
		// 正规表达式
		String regpattern = "[" + trimstr + "]*+";
		Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);
		// 去掉结尾的指定字符
		StringBuffer buffer = new StringBuffer(stream).reverse();
		Matcher matcher = pattern.matcher(buffer);
		if (matcher.lookingAt()) {
			epos = matcher.end();
			stream = new StringBuffer(buffer.substring(epos)).reverse()
					.toString();
		}
		// 去掉开头的指定字符
		matcher = pattern.matcher(stream);
		if (matcher.lookingAt()) {
			epos = matcher.end();
			stream = stream.substring(epos);
		}
		// 返回处理后的字符串
		return stream;
	}

	/**
	 * 和谐数据
	 * 
	 * @param str
	 *            需要和谐的数据
	 * @return
	 */
	public static String harmonyString(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		String harmonyStr = null;
		harmonyStr = str.replace("法轮功", "*").replace("操你", "*")
				.replace("鸡吧", "*").replace("妈逼的", "*").replace("反对中国共产党", "*");
		return harmonyStr;
	}

	/**
	 * 格式化邮箱，如182333333@qq.com格式化后1****3@qq.com
	 * 
	 * @param email 要格式的邮箱
	 */
	public static String formatEmail(String email) {
		if (StringUtil.isEmpty(email)
				|| !RegularExpressionUtil.isEmail(email)) {
			return email;
		}
		return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
//		if (email == null || "".equals(email))
//			return "";
//		// 判断是有为邮箱
//		if (RegularExpressionUtil.isEmail(email)) {
//			int num = 0;
//			for (int i = 0; i < email.length(); i++) {
//				char s = email.charAt(i);
//				if ('@' == s) {
//					num = i - 3;
//					break;
//				}
//			}
//			if (num > 0)
//				return email.replace(email.substring(0, num), "***");
//			else
//				return email.replace(email.substring(0, num + 1), "***");
//		} else {
//			return email;
//		}
	}

	/**
	 * 格式化手机号，如18060600906格式化后180***0906
	 * 
	 * @param email 要格式的手机号
	 */
	public static String formatPhone(String phone) {
		if (StringUtil.isEmpty(phone)
				|| !RegularExpressionUtil.isPhone(phone)) {
			return phone;
		}
		return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
	}

	/**
	 * 格式化身份证号，如411522200310232816格式化后4115*****2816
	 * 
	 * @param idCard 要格式的身份证号
	 */
	public static String formatIdCard(String idCard) {
		if (StringUtil.isEmpty(idCard)
				|| !StringUtil.isEmpty(ValidIDCard.iDCardValidate(idCard))) {
			return idCard;
		}
		return idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
	}
}
