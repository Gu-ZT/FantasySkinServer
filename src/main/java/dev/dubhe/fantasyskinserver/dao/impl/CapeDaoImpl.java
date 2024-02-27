package dev.dubhe.fantasyskinserver.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.dubhe.fantasyskinserver.dao.ICapeDao;
import dev.dubhe.fantasyskinserver.mapper.CapeMapper;
import dev.dubhe.fantasyskinserver.pojo.Cape;
import org.springframework.stereotype.Service;

@Service
public class CapeDaoImpl extends ServiceImpl<CapeMapper, Cape> implements ICapeDao {
}
