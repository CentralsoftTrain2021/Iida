package bean;

import java.util.List;

import dao.EmployeesVo;

public class ShainListBean
{
	private String loginShainName;
	private String msg;
	private List<EmployeesVo> shainList;

	public ShainListBean()
	{}

	public String getLoginShainName() {
		return loginShainName;
	}

	public void setLoginShainName(String loginShainName) {
		this.loginShainName = loginShainName;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<EmployeesVo> getShainList() {
		return shainList;
	}
	public void setShainList(List<EmployeesVo> shainList) {
		this.shainList = shainList;
	}



}
