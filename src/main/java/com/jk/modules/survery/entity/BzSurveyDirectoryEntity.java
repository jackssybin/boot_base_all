package com.jk.modules.survery.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
public class BzSurveyDirectoryEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	private Integer anItemLeastNum;
	
	/**
	 * 
	 */
	private Integer answerNum;
	
	/**
	 * 
	 */
	private Date createDate;
	
	/**
	 * 
	 */
	private Integer dirType;
	
	/**
	 * 
	 */
	private Integer excerptNum;
	
	/**
	 * 
	 */
	private String htmlPath;
	
	/**
	 * 
	 */
	private Integer isShare;
	
	/**
	 * 
	 */
	private String parentId;
	
	/**
	 * 
	 */
	private String sid;
	
	/**
	 * 
	 */
	private String surveyDetailId;
	
	/**
	 * 
	 */
	private Integer surveyModel;
	
	/**
	 * 
	 */
	private String surveyName;
	
	/**
	 * 
	 */
	private Integer surveyQuNum;
	
	/**
	 * 
	 */
	private Integer surveyState;
	
	/**
	 * 
	 */
	private Integer surveyTag;
	
	/**
	 * 
	 */
	private String userId;
	
	/**
	 * 
	 */
	private Integer viewAnswer;
	
	/**
	 * 
	 */
	private Integer visibility;
	

	public BzSurveyDirectoryEntity() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setAnItemLeastNum(Integer anItemLeastNum) {
		this.anItemLeastNum = anItemLeastNum;
	}
	
	public Integer getAnItemLeastNum() {
		return anItemLeastNum;
	}
	
	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}
	
	public Integer getAnswerNum() {
		return answerNum;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setDirType(Integer dirType) {
		this.dirType = dirType;
	}
	
	public Integer getDirType() {
		return dirType;
	}
	
	public void setExcerptNum(Integer excerptNum) {
		this.excerptNum = excerptNum;
	}
	
	public Integer getExcerptNum() {
		return excerptNum;
	}
	
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	
	public String getHtmlPath() {
		return htmlPath;
	}
	
	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}
	
	public Integer getIsShare() {
		return isShare;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getSid() {
		return sid;
	}
	
	public void setSurveyDetailId(String surveyDetailId) {
		this.surveyDetailId = surveyDetailId;
	}
	
	public String getSurveyDetailId() {
		return surveyDetailId;
	}
	
	public void setSurveyModel(Integer surveyModel) {
		this.surveyModel = surveyModel;
	}
	
	public Integer getSurveyModel() {
		return surveyModel;
	}
	
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	
	public String getSurveyName() {
		return surveyName;
	}
	
	public void setSurveyQuNum(Integer surveyQuNum) {
		this.surveyQuNum = surveyQuNum;
	}
	
	public Integer getSurveyQuNum() {
		return surveyQuNum;
	}
	
	public void setSurveyState(Integer surveyState) {
		this.surveyState = surveyState;
	}
	
	public Integer getSurveyState() {
		return surveyState;
	}
	
	public void setSurveyTag(Integer surveyTag) {
		this.surveyTag = surveyTag;
	}
	
	public Integer getSurveyTag() {
		return surveyTag;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setViewAnswer(Integer viewAnswer) {
		this.viewAnswer = viewAnswer;
	}
	
	public Integer getViewAnswer() {
		return viewAnswer;
	}
	
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	
	public Integer getVisibility() {
		return visibility;
	}
	
}
