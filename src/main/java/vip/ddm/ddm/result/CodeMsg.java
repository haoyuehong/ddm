package vip.ddm.ddm.result;

public class CodeMsg {

	private int code;
	private String msg;
	
	//通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
	public static CodeMsg CODE_ERROR = new CodeMsg(500102, "代码错误：%s");

	//登录模块 5002XX
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210,"session不存在或已失效");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号错误");
	public static CodeMsg MOBILE_NOT_EXIT = new CodeMsg(500214,"手机号不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"密码错误");
	//商品模块 5003XX
	public static CodeMsg GOODSOVER = new CodeMsg(500300,"商品已售罄");
	public static CodeMsg GOOD_ID_NULL = new CodeMsg(500301,"商品id为空");
	public static CodeMsg GOOD_NULL = new CodeMsg(500302,"找不到商品");

	//订单模块 5004XX
	public static CodeMsg ORDER_NULL = new CodeMsg(500400,"订单为空");


	//分组模块 5005XX
	public static CodeMsg GROUP_ID_NULL = new CodeMsg(500500,"分组id为空");
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg,args);
		return  new CodeMsg(code,message);
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
