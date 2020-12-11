package com.qh.venus.achilles.pts.sys.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import com.qh.venus.achilles.common.utils.IdUtils;
import com.qh.venus.achilles.framework.idgen.BuildIdFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.sys.mapper.TSysSerialNumberMapper;
import com.qh.venus.achilles.pts.sys.domain.TSysSerialNumber;
import com.qh.venus.achilles.pts.sys.service.ITSysSerialNumberService;

import javax.annotation.Resource;

/**
 * 公共流水号Service业务层处理
 *
 * @author qh_venus_zf
 * @date 2020-04-22
 */
@Service
@Configuration
public class TSysSerialNumberServiceImpl implements ITSysSerialNumberService {
    @Resource
    private TSysSerialNumberMapper tSysSerialNumberMapper;
    /**
     * 格式
     */
    private String pattern = "yyyyMMdd";

    /**
     * 生成器锁
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 流水号格式化器
     */
    private DecimalFormat format = null;

    /**
     * 预生成锁
     */
    private final ReentrantLock prepareLock = new ReentrantLock();

    /**
     * 最小值
     */
    private int min = 0;

    /**
     * 最大值
     */
    private long max = 0;

    /**
     * 已生成流水号（种子）
     */
    private long seed = min;

    /**
     * 预生成数量
     */
    private int prepare = 0;

    /**
     * 数据库存储的当前最大序列号
     **/
    long maxSerialInt = 0;

    /**
     * 当前序列号是否为个位数自增的模式
     **/
    private String autoIncrementFlag = "0";

    TSysSerialNumber tSysSerialNumber = new TSysSerialNumber();

    /**
     * 预生成流水号
     */
    HashMap<String, List<String>> prepareSerialNumberMap = new HashMap<>();

    private String DATE_SYMBOL = "%{DATE}";
    private String CODE_SYMBOL = "CODE";

    @Value("${serialnumber.type}")
    private String type;

    /**
     * 查询公共流水号
     *
     * @param id 公共流水号ID
     * @return 公共流水号
     */
    @Override
    public TSysSerialNumber selectTSysSerialNumberById(String id) {
        return tSysSerialNumberMapper.selectTSysSerialNumberById(id);
    }

    /**
     * 查询公共流水号列表
     *
     * @param tSysSerialNumber 公共流水号
     * @return 公共流水号
     */
    @Override
    public List<TSysSerialNumber> selectTSysSerialNumberList(TSysSerialNumber tSysSerialNumber) {
        return tSysSerialNumberMapper.selectTSysSerialNumberList(tSysSerialNumber);
    }

    /**
     * 新增公共流水号
     *
     * @param tSysSerialNumber 公共流水号
     * @return 结果
     */
    @Override
    public int insertTSysSerialNumber(TSysSerialNumber tSysSerialNumber) {
        tSysSerialNumber.setCreateTime(DateUtils.getNowDate());
        return tSysSerialNumberMapper.insertTSysSerialNumber(tSysSerialNumber);
    }

    /**
     * 修改公共流水号
     *
     * @param tSysSerialNumber 公共流水号
     * @return 结果
     */
    @Override
    public int updateTSysSerialNumber(TSysSerialNumber tSysSerialNumber) {
        tSysSerialNumber.setUpdateTime(DateUtils.getNowDate());
        return tSysSerialNumberMapper.updateTSysSerialNumber(tSysSerialNumber);
    }

    /**
     * 删除公共流水号对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSysSerialNumberByIds(String ids) {
        return tSysSerialNumberMapper.deleteTSysSerialNumberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公共流水号信息
     *
     * @param id 公共流水号ID
     * @return 结果
     */
    public int deleteTSysSerialNumberById(String id) {
        return tSysSerialNumberMapper.deleteTSysSerialNumberById(id);
    }

    /*************************** 流水号生成Begin *********************************************/
    public String generateSerialNumber(String modelCode) {
        // TODO Auto-generated method stub

        if (type.equals("db")) {
            // 预序列号加锁
            prepareLock.lock();
            try {
                // 判断内存中是否还有序列号
                if (null != prepareSerialNumberMap.get(modelCode) && prepareSerialNumberMap.get(modelCode).size() > 0) {
                    // 若有，返回第一个，并删除
                    return prepareSerialNumberMap.get(modelCode).remove(0);
                }
            } finally {
                // 预序列号解锁
                prepareLock.unlock();
            }
            prepareLock.lock();
            tSysSerialNumber = new TSysSerialNumber();
            tSysSerialNumber = find(modelCode);

            prepare = Integer.parseInt(tSysSerialNumber.getPreMaxNum().trim());// 预生成流水号数量

            pattern = tSysSerialNumber.getConfigTemplet().trim();// 配置模板

            String maxSerial = tSysSerialNumber.getMaxSerial().trim(); // 存储当前最大值
            autoIncrementFlag = tSysSerialNumber.getAutoIncrementFlag().trim();
            maxSerialInt = Long.parseLong(maxSerial.trim());// 数据库存储的最大序列号
            max = this.counter(pattern, '0') + 1;// 根据模板判断当前序列号数字的最大值
            if (autoIncrementFlag.equals("0")) {
                pattern = pattern.replace("#", "0");
            }
            format = new DecimalFormat(pattern);
            // 生成预序列号，存到缓存中
            List<String> resultList = generatePreSerialNumber(modelCode);

            try {
                prepareSerialNumberMap.put(modelCode, resultList);
                return prepareSerialNumberMap.get(modelCode).remove(0);
            } finally {
                prepareLock.unlock();
            }
        } else if (type.equals("redis")) {
            Long id = BuildIdFactory.getInstance().buildFactoryId(modelCode);
            return modelCode + id;
        } else {
            Long id = BuildIdFactory.getInstance().buildFactoryId(modelCode);
            return id + "";
        }
    }


    /**
     * 根据模块code生成预数量的序列号存放到Map中
     *
     * @param modelCode 模块code
     * @return
     */
    @CachePut(value = "serialNumber", key = "#modelCode")
    public List<String> generatePreSerialNumber(String modelCode) {
        // 临时List变量
        List<String> resultList = new ArrayList<String>(prepare);
        lock.lock();
        try {
            for (int i = 0; i < prepare; i++) {
                maxSerialInt = maxSerialInt + 1;
                if (maxSerialInt > min && (maxSerialInt + "").length() < max) {
                    seed = maxSerialInt;
                } else {
                    // 如果动态数字长度大于模板中的长度 例：模板CF000 maxSerialInt 1000
                    seed = maxSerialInt = 0;
                    // 更新数据，重置maxSerialInt为0
                    tSysSerialNumber = find(modelCode);
                    tSysSerialNumber.setMaxSerial("0");
                    tSysSerialNumberMapper.updateTSysSerialNumber(tSysSerialNumber);
                }
                // 动态数字生成
                String formatSerialNum = format.format(seed);
                // 动态日期的生成
                if (pattern.contains(DATE_SYMBOL)) {
                    String currentDate = DateUtils.dateToString("yyyyMMdd", new Date());
                    formatSerialNum = formatSerialNum.replace(DATE_SYMBOL, currentDate);
                }
                //动态编号前缀
                if (pattern.contains(CODE_SYMBOL)) {
                    String[] codeAryy =modelCode.split("_");
                    String code=codeAryy[codeAryy.length-1];
                    formatSerialNum = formatSerialNum.replace(CODE_SYMBOL, code);
                }
                resultList.add(formatSerialNum);
            }
            // 更新数据
            tSysSerialNumber = find(modelCode);
            tSysSerialNumber.setMaxSerial(maxSerialInt + "");
            tSysSerialNumberMapper.updateTSysSerialNumber(tSysSerialNumber);
        } finally {
            lock.unlock();
        }
        return resultList;
    }

    /**
     * 查询单条序列号配置信息
     *
     * @param modelCode
     * @return
     */
    public TSysSerialNumber find(String modelCode) {
        TSysSerialNumber cond = new TSysSerialNumber();
        cond.setModelCode(modelCode);
        List<TSysSerialNumber> list = tSysSerialNumberMapper.selectTSysSerialNumberList(cond);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 设置最小值
     *
     * @param value 最小值，要求：大于等于零
     * @return 流水号生成器实例
     */
    public TSysSerialNumberServiceImpl setMin(int value) {
        lock.lock();
        try {
            this.min = value;
        } finally {
            lock.unlock();
        }
        return this;
    }

    /**
     * 最大值
     *
     * @param value 最大值，要求：小于等于Long.MAX_VALUE ( 9223372036854775807 )
     * @return 流水号生成器实例
     */
    public TSysSerialNumberServiceImpl setMax(long value) {
        lock.lock();
        try {
            this.max = value;
        } finally {
            lock.unlock();
        }
        return this;
    }

    /**
     * 设置预生成流水号数量
     *
     * @param count 预生成数量
     * @return 流水号生成器实例
     */
    public TSysSerialNumberServiceImpl setPrepare(int count) {
        lock.lock();
        try {
            this.prepare = count;
        } finally {
            lock.unlock();
        }
        return this;
    }

    /**
     * 统计某一个字符出现的次数
     *
     * @param str 查找的字符
     * @param c
     * @return
     */
    private int counter(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
    /*************************** 流水号生成End *********************************************/

}
