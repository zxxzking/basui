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
		
		str.append("]");
	
		return str.toString();
	}
}