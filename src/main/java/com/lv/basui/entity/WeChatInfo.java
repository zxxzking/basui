package com.lv.basui.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `weChat_info` (
  `id` bigint(20) NOT NULL,
  `openId` varchar(50) DEFAULT NULL COMMENT 'openId',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `avatarUrl` varchar(20) DEFAULT NULL COMMENT '头像url',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(4) DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 *
 */
@Table(name="weChat_info",database="zxxzking")
public class WeChatInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Long id;
	
	/** openId */
	@Column(name="openId")
	private String openid;
	
	/** 昵称 */
	@Column(name="nick_name")
	private String nickName;
	
	/** 头像url */
	@Column(name="avatarUrl")
	private String avatarurl;
	
	/** 插入时间 */
	@Column(name="inserttime")
	private java.util.Date inserttime;
	
	/** 更新时间 */
	@Column(name="updatetime")
	private java.util.Date updatetime;
	
	/** 逻辑删除 */
	@Column(name="isactive")
	private Boolean isactive;
	

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getOpenid(){
		return openid;
	}

	public void setOpenid(String openid){
		this.openid = openid;
	}

	public String getNickName(){
		return nickName;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getAvatarurl(){
		return avatarurl;
	}

	public void setAvatarurl(String avatarurl){
		this.avatarurl = avatarurl;
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
		StringBuffer str = new StringBuffer("WeChatInfo [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("openid=\"");
		str.append(openid);
		str.append("\"");
		str.append(",");
		str.append("nickName=\"");
		str.append(nickName);
		str.append("\"");
		str.append(",");
		str.append("avatarurl=\"");
		str.append(avatarurl);
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