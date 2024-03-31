package org.yoon;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yoon.domain.City;
import org.yoon.mapper.CityMapper;

@SpringBootApplication
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    private final CityMapper cityMapper;

    public Main(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findAll());
        System.out.println(this.cityMapper.findByCountry("한국"));
        System.out.println(this.cityMapper.findById(1));
        System.out.println(this.cityMapper.addCity(new City("아테네", "그리스")));
        System.out.println(this.cityMapper.updateCity(new City(2, "워싱턴", "미국")));
    }
}