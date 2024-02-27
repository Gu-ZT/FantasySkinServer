package dev.dubhe.fantasyskinserver.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DataBaseInitDto {
    @NotBlank(message = "数据库服务器地址不能为空！")
    public String host;
    @NotNull(message = "数据库服务器端口号不能为空！")
    @Min(value = 0, message = "服务器端口号取值范围为0~65535！")
    @Max(value = 65535, message = "服务器端口号取值范围为0~65535！")
    public Integer port;
    @NotBlank(message = "数据库用户名不能为空！")
    public String username;
    @NotBlank(message = "数据库密码不能为空！")
    public String password;
    @NotBlank(message = "数据库名称不能为空！")
    public String basename;
}
