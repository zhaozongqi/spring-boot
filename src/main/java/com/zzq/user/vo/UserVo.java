package com.zzq.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * author:zhaozongqi
 * date:2021/11/2
 * describe:无
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -474909241719093479L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 1是 0 否")
    private Boolean deleted;
}
