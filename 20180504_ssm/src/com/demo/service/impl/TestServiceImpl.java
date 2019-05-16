package com.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.TestMapper;
import com.demo.po.AreaPO;
import com.demo.po.AuthorPO;
import com.demo.po.BigAuthorPO;
import com.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper mapper;
	
	
	public List<AuthorPO> getAuthorList() throws Exception {
		return mapper.getAuthorList();
	}

	public List<BigAuthorPO> getAuthorList2() throws Exception {
		return mapper.getAuthorList2();
	}

	public AreaPO getAreaById(int areaid) throws Exception {
		return mapper.getAreaById(areaid);
	}

}
