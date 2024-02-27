package dev.dubhe.fantasyskinserver.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.dubhe.fantasyskinserver.dao.ISkinDao;
import dev.dubhe.fantasyskinserver.mapper.SkinMapper;
import dev.dubhe.fantasyskinserver.pojo.Skin;
import org.springframework.stereotype.Service;

@Service
public class SkinDaoImpl extends ServiceImpl<SkinMapper, Skin> implements ISkinDao {
}
