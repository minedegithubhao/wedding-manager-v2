package com.qh.venus.achilles.sms.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qh.venus.achilles.sms.system.domain.Donate;
import com.qh.venus.achilles.sms.system.mapper.DonateMapper;
import com.qh.venus.achilles.sms.system.service.IDonateService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class DonateServiceImpl implements IDonateService {
	@Autowired
	private DonateMapper donateMapper;

	@Override
	public List<Donate> selectDistrictsList(Donate donate) {
		Example example = new Example(Donate.class);
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(donate.getNick())) {
			criteria.andLike("nick", "%" + donate.getNick() + "%");
		}
		if (null != donate.getCanal()) {
			criteria.andEqualTo("canal", donate.getCanal());
		}
		if (StringUtils.isNotBlank(donate.getBeginTime())) {
			criteria.andGreaterThanOrEqualTo("createTime", donate.getBeginTime());
		}
		if (StringUtils.isNotBlank(donate.getEndTime())) {
			criteria.andLessThanOrEqualTo("createTime", donate.getEndTime());
		}
		return donateMapper.selectByExample(example);
	}
}
