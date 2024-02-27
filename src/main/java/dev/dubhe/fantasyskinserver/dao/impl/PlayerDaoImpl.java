package dev.dubhe.fantasyskinserver.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.dubhe.fantasyskinserver.dao.IPlayerDao;
import dev.dubhe.fantasyskinserver.mapper.PlayerMapper;
import dev.dubhe.fantasyskinserver.pojo.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerDaoImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerDao {
}
