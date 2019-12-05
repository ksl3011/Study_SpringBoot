package com.edu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.edu.cmn.testVO;

@Mapper
public interface MapperTest {
	@Select("SELECT COUNT(*) as testCnt, COUNT(*) as testCnt2 FROM PF_BOARD WHERE 1=#{testKey}")
	public String test(@Param("testKey") String key) throws Exception;
	
	public testVO testXml(String insert1);
}
