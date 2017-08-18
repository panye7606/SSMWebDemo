package cc.ibooker.enums;

/**
 * 认证状态-枚举
 * 
 * @author 邹峰立
 */
public enum IdentifyStateEnum {
	NoIdentify("0", "未认证"), 
	WaitIdentify("1", "待认证"), 
	YesIdentify("2", "已认证"), 
	OverDueIdentify("3", "已过期");

	private String state;
	private String stateInfo;

	private IdentifyStateEnum(String state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public String getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static IdentifyStateEnum stateOf(String state) {
		for (IdentifyStateEnum enumIdentifyState : values()) {
			if (enumIdentifyState.getState().equals(state)) {
				return enumIdentifyState;
			}
		}
		return null;
	}
	
	public static String stateInfoOf(String state){
		for (IdentifyStateEnum enumIdentifyState : values()) {
			if (enumIdentifyState.getState().equals(state)) {
				return enumIdentifyState.getStateInfo();
			}
		}
		return null;
	}

}
