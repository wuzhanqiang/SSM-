package com.demo.mapper;

import java.util.List;

import com.demo.po.AreaPO;
import com.demo.po.AuthorPO;
import com.demo.po.BigAuthorPO;

public interface TestMapper {
	public List<AuthorPO> getAuthorList() throws Exception;
	
	public List<BigAuthorPO> getAuthorList2() throws Exception;
	
	public AreaPO getAreaById(int areaid) throws Exception; 
}
