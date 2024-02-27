package dev.dubhe.fantasyskinserver.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.dubhe.fantasyskinserver.dao.ISuitDao;
import dev.dubhe.fantasyskinserver.mapper.SuitMapper;
import dev.dubhe.fantasyskinserver.pojo.Suit;
import org.springframework.stereotype.Service;

@Service
public class SuitDaoImpl extends ServiceImpl<SuitMapper, Suit> implements ISuitDao {
}
