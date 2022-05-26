package cn.whu.wy;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.mapper.IWeatherMapper;
import cn.whu.wy.service.WeatherService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 11:41
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WeatherServiceTest {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private IWeatherMapper weatherMapper;


    private final String[] cities = {"北京", "深圳", "长沙", "重庆", "武汉", "成都"};
    private final String[] weathers = {"晴", "雨", "雪", "多云"};
    private final int[] temperature = {-1, 5, 22, 24, 30, 28};

    private final Random rand = new Random();

    @Order(1)
    @Test
    public void clear() {
        for (Weather weather : weatherMapper.selectAll()) {
            weatherMapper.delete(weather);
        }
        Assertions.assertEquals(0, weatherMapper.selectAll().size());
    }

    @Order(2)
    @Test
    public void add() {
        LocalDate from = LocalDate.of(2020, 1, 1);
        Weather weather = new Weather();
        for (int i = 0; i < 120; i++) {
            weather.setCity(cities[rand.nextInt(6)]);
            weather.setDate(from.plusDays(i));
            weather.setWeather(weathers[rand.nextInt(4)]);
            weather.setTemperature(temperature[rand.nextInt(6)]);
            weather.setId(null);
            weatherService.add(weather);
        }


        Assertions.assertEquals(120,weatherMapper.selectAll().

    size());
}

    @Order(3)
    @Test
    public void testExample() {
        List<Weather> weathers = weatherMapper.select(null, null, null);
        Assertions.assertEquals(120, weathers.size());
    }
}