package cn.whu.wy;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 10:10
 */
@Configuration
@MapperScan("cn.whu.wy.mapper")
public class JavaConfig {
}
