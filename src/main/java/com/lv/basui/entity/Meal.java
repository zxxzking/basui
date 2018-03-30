package com.lv.basui.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `meal` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `breakfast` varchar(200) DEFAULT NULL COMMENT '早餐',
  `lunch` varchar(200) DEFAULT NULL COMMENT '午餐',
  `dinner` varchar(200) DEFAULT NULL COMMENT '晚餐',
  `other` varchar(200) DEFAULT NULL COMMENT '其他',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(4) DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 *
 */
@Table(name="meal",database="zxxzking")
public class Meal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Integer id;
	
	/**  */
	@Column(name="userId")
	private Long userid;
	
	/** 早餐 */
	@Column(name="breakfast")
	private String breakfast;
	
	/** 午餐 */
	@Column(name="lunch")
	private String lunch;
	
	/** 晚餐 */
	@Column(name="dinner")
	private String dinner;
	
	/** 其他 */
	@Column(name="other")
	private String other;
	
	/** 插入时间 */
	@Column(name="inserttime")
	private java.util.Date inserttime;
	
	/** 更新时间 */
	@Column(name="updatetime")
	private java.util.Date updatetime;
	
	/** 逻辑删除 */
	@Column(name="isactive")
	private Boolean isactive;
	

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Long getUserid(){
		return userid;
	}

	public void setUserid(Long userid){
		this.userid = userid;
	}

	public String getBreakfast(){
		return breakfast;
	}

	public void setBreakfast(String breakfast){
		this.breakfast = breakfast;
	}

	public String getLunch(){
		return lunch;
	}

	public void setLunch(String lunch){
		this.lunch = lunch;
	}

	public String getDinner(){
		return dinner;
	}

	public void setDinner(String dinner){
		this.dinner = dinner;
	}

	public String getOther(){
		return other;
	}

	public void setOther(String other){
		this.other = other;
	}

	public java.util.Date getInserttime(){
		return inserttime;
	}

	public void setInserttime(java.util.Date inserttime){
		this.inserttime = inserttime;
	}

	public java.util.Date getUpdatetime(){
		return updatetime;
	}

	public void setUpdatetime(java.util.Date updatetime){
		this.updatetime = updatetime;
	}

	public Boolean getIsactive(){
		return isactive;
	}

	public void setIsactive(Boolean isactive){
		this.isactive = isactive;
	}

	@Override
	public String toString(){
		StringBuffer str = new StringBuffer("Meal [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("userid=\"");
		str.append(userid);
		str.append("\"");
		str.append(",");
		str.append("breakfast=\"");
		str.append(breakfast);
		str.append("\"");
		str.append(",");
		str.append("lunch=\"");
		str.append(lunch);
		str.append("\"");
		str.append(",");
		str.append("dinner=\"");
		str.append(dinner);
		str.append("\"");
		str.append(",");
		str.append("other=\"");
		str.append(other);
		str.append("\"");
		str.append(",");
		str.append("inserttime=\"");
		str.append(inserttime);
		str.append("\"");
		str.append(",");
		str.append("updatetime=\"");
		str.append(updatetime);
		str.append("\"");
		str.append(",");
		str.append("isactive=\"");
		str.append(isactive);
		str.append("\"");
		
		str.append("]");
	
		return str.toString();
	}
}