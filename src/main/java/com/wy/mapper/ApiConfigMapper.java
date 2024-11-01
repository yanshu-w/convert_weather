package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.entity.ApiConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiConfigMapper extends BaseMapper<ApiConfig> {
    int minusTimeByToken(@Param("token") String token);

    Integer checkToken(@Param("token") String token);
}
