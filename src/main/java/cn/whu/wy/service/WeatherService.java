package cn.whu.wy.service;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.mapper.IWeatherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 10:26
 */
@Service
@Slf4j
public class WeatherService {

    @Autowired
    private IWeatherMapper weatherMapper;

    public List<Weather> query(String city) {
        return weatherMapper.selectByCity(city);
    }

    public void add(Weather weather) {
        weatherMapper.insert(weather);
        log.info("insert a record, autoId={}", weather.getId());
    }

    public void edit(Weather weather) {
        if (weather.getId() == null) {
            log.error("id is null!");
        }
        weatherMapper.updateByPrimaryKey(weather);
    }

    public List<Weather> showAll() {
        return weatherMapper.selectAll();
    }


}
