package org.jeecg.modules.wanz.edu.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: 测试学校
 * @Author: jeecg-boot
 * @Date:   2019-11-22
 * @Version: V1.0
 */
@Data
@TableName("test_edu")
public class TestEdu implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.ID_WORKER_STR)
    private java.lang.String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    private java.lang.String createBy;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
    private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    private java.lang.String sysOrgCode;
	/**学校代码*/
	@Excel(name = "学校代码", width = 15)
    private java.lang.String scCode;
	/**学校名称*/
	@Excel(name = "学校名称", width = 15)
    private java.lang.String scName;
	/**英文名称*/
	@Excel(name = "英文名称", width = 15)
    private java.lang.String scNameEn;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    private java.lang.String telphone;
	/**学校地址*/
	@Excel(name = "学校地址", width = 15)
    private java.lang.String addr;
	/**建立日期*/
	@Excel(name = "建立日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date bulidDate;
	/**主页地址*/
	@Excel(name = "主页地址", width = 15)
    private java.lang.String homePage;
}
