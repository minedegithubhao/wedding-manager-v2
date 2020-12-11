package com.qh.venus.achilles.framework.log.enums;

/**
 * @Title: 业务操作类型
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public enum BusinessType
{
    /**
     * 其它
     */
    OTHER,
    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空数据
     */
    CLEAN,

    /**
     * 查询
     */
    QUERY,
    /**
     * 执行脚本
     */
    EXECUTE,

    /**
     * 查看
     */
    DETAIL
}
