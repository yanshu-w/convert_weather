package com.wy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wy.domain.dto.ApiConfigDto;
import com.wy.domain.entity.ApiConfig;
import com.wy.domain.vo.ApiConfigVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiConfigMapper extends BaseMapper<ApiConfig> {
    int minusTimeByToken(@Param("token") String token);

    Integer checkToken(@Param("token") String token);

    List<ApiConfigVo> getPageList(@Param("DTO") ApiConfigDto apiConfigDto);
}
