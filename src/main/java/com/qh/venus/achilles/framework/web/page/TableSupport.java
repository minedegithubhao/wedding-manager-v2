package com.qh.venus.achilles.framework.web.page;

import com.qh.venus.achilles.common.utils.ServletUtils;


/**
 * @Title:表格数据处理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class TableSupport
{
    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "sortField";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "sortOrder";

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        if(ServletUtils.getParameter(IS_ASC)!=null && !"".equals(ServletUtils.getParameter(IS_ASC))) {
            pageDomain.setOrderByColumn(ServletUtils.getParameter(ORDER_BY_COLUMN));
            pageDomain.setIsAsc(ServletUtils.getParameter(IS_ASC));
        }
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
