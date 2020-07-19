package com.yanle.mybatis.plus.demo1.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanle.mybatis.plus.demo1.system.entity.SysLog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao extends BaseMapper<SysLog> {
    @Select("select * from sys_log order by create_date desc")
    IPage<SysLog> findSysLogPage(Page page);
}
