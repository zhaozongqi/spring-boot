package com.zzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.zzq.**.mapper"})
public class ZzqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzqApplication.class, args);
	}

}
