package com.lv.basui.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `sequence` (
  `seqId` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` int(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`seqId`),
  KEY `Index_2` (`name`),
  KEY `ix_inserttime` (`inserttime`),
  KEY `ix_updatetime` (`updatetime`),
  KEY `ix_isactive` (`isactive`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 *
 */
@Table(name="sequence",database="zxxzking")
public class Sequence implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="seqId")
	private Long seqid;
	
	/**  */
	@Column(name="id")
	private Integer id;
	
	/**  */
	@Column(name="name")
	private String name;
	
	/** 插入时间 */
	@Column(name="inserttime")
	private java.util.Date inserttime;
	
	/** 更新时间 */
	@Column(name="updatetime")
	private java.util.Date updatetime;
	
	/** 逻辑删除 */
	@Column(name="isactive")
	private Boolean isactive;
	

	public Long getSeqid(){
		return seqid;
	}

	public void setSeqid(Long seqid){
		this.seqid = seqid;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
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
		StringBuffer str = new StringBuffer("Sequence [");
		str.append("seqid=\"");
		str.append(seqid);
		str.append("\"");
		str.append(",");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("name=\"");
		str.append(name);
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