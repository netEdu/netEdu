package com.netEdu;


import com.netEdu.core.BaseMapper;
import com.netEdu.utils.netty.WsServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.netEdu.**.dao.*"}, markerInterface = BaseMapper.class)
public class netEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(netEduApplication.class, args);

        WsServer ws=new WsServer(7117);
        try {
            ws.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
