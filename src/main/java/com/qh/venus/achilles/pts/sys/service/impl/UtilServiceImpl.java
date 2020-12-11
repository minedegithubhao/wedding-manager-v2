package com.qh.venus.achilles.pts.sys.service.impl;

import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import com.qh.venus.achilles.pts.sys.domain.CheckUnique;
import com.qh.venus.achilles.pts.sys.domain.TSysFile;
import com.qh.venus.achilles.pts.sys.mapper.CheckUniqueMapper;
import com.qh.venus.achilles.pts.sys.mapper.TSysFileMapper;
import com.qh.venus.achilles.pts.sys.service.ITSysFileService;
import com.qh.venus.achilles.pts.sys.service.IUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公共附件Service业务层处理
 * 
 * @author qh_venus_zf
 * @date 2020-04-23
 */
@Service
public class UtilServiceImpl implements IUtilService
{
    @Autowired
    private CheckUniqueMapper checkUniqueMapper;

    @Override
    public boolean checkUnique(CheckUnique checkUnique) {

        int count=checkUniqueMapper.selectByCheckUnique(checkUnique);

        return (count > 0) ? false : true;
    }
}
