package cn.whu.wy.mapper;

import cn.whu.wy.entity.Weather;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 10:23
 */
public interface IWeatherMapper extends BaseMapper<Weather>, ExampleMapper<Weather> {

    default List<Weather> selectByCity(String city){
        Example example = new Example(Weather.class);
        example.createCriteria().andEqualTo("city",city);
        return selectByExample(example);
    }
}
