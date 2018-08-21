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
	public static CodeMsg GOOD_DOWN = new CodeMsg(500303,"商品已下架或被删除");
	public static CodeMsg GOOD_HAD_DISCOUNT = new CodeMsg(500304,"商品存在打折信息");

	//订单模块 5004XX
	public static CodeMsg ORDER_NULL = new CodeMsg(500400,"订单为空");


	//分组模块 5005XX
	public static CodeMsg GROUP_ID_NULL = new CodeMsg(500500,"分组id为空");
	public static CodeMsg GROUP_GOOD_NOT_NULL = new CodeMsg(500501,"分组下商品不为空,请先处理");
	public static CodeMsg GROUP_NOT_FIND = new CodeMsg(500502,"未找到该分组");

	//地址模块  5006XX
	public static CodeMsg ADDRESS_ID_NULL = new CodeMsg(500600,"地址id为空");
	public static CodeMsg ADDRESS_NULL = new CodeMsg(500601,"未找到这个地址");

	//地址模块  5007XX
	public static CodeMsg DISCOUNT_ID_NULL = new CodeMsg(500700,"折扣id为空");
	public static CodeMsg DISCOUNT_NULL = new CodeMsg(500701,"找不到该折扣信息");

	//优惠卷模块  5008XX
	public static CodeMsg COUPON_ID_NULL = new CodeMsg(500800,"优惠卷id为空");
	public static CodeMsg COUPON_NULL = new CodeMsg(500801,"找不到该信息折扣");

	//人员模块 	5009XX
	public static CodeMsg USER_SAVED = new CodeMsg(500900,"%s");
	public static CodeMsg USER_NUSAVE = new CodeMsg(500901,"用户未保存");
	public static CodeMsg USER_OPENID_FAIL = new CodeMsg(500902,"获取用户openid失败");
	public static CodeMsg USER_INFO_FAIL = new CodeMsg(500903,"获取用户信息失败");
	public static CodeMsg USER_NULL = new CodeMsg(500904,"用户不存在");
	public static CodeMsg USER_ID_NULL = new CodeMsg(500905,"用户id为空");




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
