package com.qh.venus.achilles.pts.sys.mapper;

import com.qh.venus.achilles.pts.sys.domain.CheckUnique;
import com.qh.venus.achilles.pts.sys.domain.TSysFile;

import java.util.List;

/**
 * 唯一性性校验接口
 * 
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public interface CheckUniqueMapper
{
    /**
     * 查询公共附件
     * 
     * @param id 公共附件ID
     * @return 公共附件
     */
    public int selectByCheckUnique(CheckUnique checkUnique);


}
