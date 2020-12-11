package com.qh.venus.achilles.pts.sys.service;

import com.qh.venus.achilles.pts.sys.domain.CheckUnique;
import com.qh.venus.achilles.pts.sys.domain.TSysFile;

import java.util.List;

/**
 * 公共附件Service接口
 * 
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public interface IUtilService
{
    boolean checkUnique(CheckUnique checkUnique);
}
