package dev.dubhe.fantasyskinserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.dubhe.fantasyskinserver.pojo.Player;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayerMapper extends BaseMapper<Player> {
}
