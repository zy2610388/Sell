package com.zy.dao;

import com.zy.entities.Master;
import com.zy.entities.MasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MasterMapper {
    int countByExample(MasterExample example);

    int deleteByExample(MasterExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Master record);

    int insertSelective(Master record);

    List<Master> selectByExample(MasterExample example);

    Master selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Master record, @Param("example") MasterExample example);

    int updateByExample(@Param("record") Master record, @Param("example") MasterExample example);

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);
}