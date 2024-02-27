package dev.dubhe.fantasyskinserver.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends AbstractSqlBase { // 用户
    private String email; // 邮箱
    private String password; // 密码
    private String slat; // 盐
    private String nickname; // 昵称
    private Long avatar; // 头像皮肤ID
    private Long player; // 主角色ID
    private String playerList; // 角色列表
    private String suitList; // 套装列表
    private Long permission; // 权限
}
