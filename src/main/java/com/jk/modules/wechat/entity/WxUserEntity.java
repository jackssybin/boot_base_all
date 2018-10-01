package com.jk.modules.wechat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
public class WxUserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号(唯一标识)
	 */
	private Long id;
	
	/**
	 * 账户
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 头像
	 */
	private String portrait;
	
	/**
	 * 微信Key
	 */
	private String wxkey;
	
	/**
	 * code码
	 */
	private String code;
	
	/**
	 * 昵称
	 */
	private String nick;
	
	/**
	 * 性别 0:男 1:女
	 */
	private Integer sex;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String area;
	
	/**
	 * 详细地址
	 */
	private String address;
	
	/**
	 * 邮编
	 */
	private String postcode;
	
	/**
	 * 生日
	 */
	private Date birthday;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 行业编号
	 */
	private String industryid;
	
	/**
	 * 子行业编号
	 */
	private String subIndustryId;
	
	/**
	 * 行业
	 */
	private Long ins;
	
	/**
	 * 会员等级
	 */
	private Integer grade;
	
	/**
	 * 在线方式 1:手机 2：电脑
	 */
	private Integer online;
	
	/**
	 * 注册时间
	 */
	private Date inTime;
	
	/**
	 * 经纬度
	 */
	private String jwd;
	
	/**
	 * 推荐人
	 */
	private String referee;
	
	/**
	 * 推荐人id
	 */
	private Long refereeId;
	
	/**
	 * 状态
	 */
	private Integer state;
	
	/**
	 * 推荐码
	 */
	private String referral;
	
	/**
	 * 账户余额
	 */
	private Float accountBalance;
	
	/**
	 * 累计交易额
	 */
	private Float turnover;
	
	/**
	 * 累计佣金
	 */
	private Float commission;
	
	/**
	 * 线下人数
	 */
	private Integer n;
	
	/**
	 * 电子券数
	 */
	private Integer m;
	
	/**
	 * 电子券金额
	 */
	private Float mBlance;

	/**
	 * 二维码
	 */
	private String qrCode;
	
	/**
	 * 备注
	 */
	private String els;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getWxkey() {
		return wxkey;
	}

	public void setWxkey(String wxkey) {
		this.wxkey = wxkey;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIndustryid() {
		return industryid;
	}

	public void setIndustryid(String industryid) {
		this.industryid = industryid;
	}

	public String getSubIndustryId() {
		return subIndustryId;
	}

	public void setSubIndustryId(String subIndustryId) {
		this.subIndustryId = subIndustryId;
	}

	public Long getIns() {
		return ins;
	}

	public void setIns(Long ins) {
		this.ins = ins;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getJwd() {
		return jwd;
	}

	public void setJwd(String jwd) {
		this.jwd = jwd;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public Float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Float getTurnover() {
		return turnover;
	}

	public void setTurnover(Float turnover) {
		this.turnover = turnover;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Integer getM() {
		return m;
	}

	public void setM(Integer m) {
		this.m = m;
	}

	public Float getmBlance() {
		return mBlance;
	}

	public void setmBlance(Float mBlance) {
		this.mBlance = mBlance;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getEls() {
		return els;
	}

	public void setEls(String els) {
		this.els = els;
	}
}
