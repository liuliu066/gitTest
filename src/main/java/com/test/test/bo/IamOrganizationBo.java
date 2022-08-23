package com.test.test.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author lwh
 * @description:
 * @date 2022/8/22 13:45
 */
@Data
public class IamOrganizationBo {

    /**
     * 组织树
     */
    private String treeId;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构类型
     */
    private String type;
    /**
     * 父机构
     */
    private String parentId;
    /**
     * 机构编码
     */
    private String code;
    /**
     * 描述
     */
    private String description;
    /**
     * 序号
     */
    private Integer sequence;
    /**
     *  禁用
     */
    private Integer isDisabled;
    /**
     * 创建日期
     */
    private Date createAt;
    /**
     * 更新日期
     */
    private Date updateAt;
    /**
     *  经理
     */
    private String managerId;
    /**
     * 全名
     */
    private String fullname;
    /**
     * 组织类型
     */
    private String orgclassification;
    /**
     * 所属单位
     */
    private String company;
    /**
     *  父级机构编码
     */
    private String pcode;
    /**
     * 部门负责人
     */
    private String headOfDepartment;
    /**
     * 分管领导
     */
    private String leadersInCharge;
    /**
     * ex编码
     */
    private String exCode;
    /**
     * 是否撤销
     */
    private Boolean isRevocation;
    /**
     * 是否执行
     */
    private Boolean isExecute;
    /**
     * hr机构id
     */
    private String hrOrgId;
    /**
     *
     */
    private String deputyLeader;
    /**
     *
     */
    private String _AID;
    /**
     *
     */
    private String _BID;
    /**
     *
     */
    private String _ID;


}
