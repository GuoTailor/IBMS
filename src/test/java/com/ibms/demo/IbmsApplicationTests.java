package com.ibms.demo;

import com.aliyun.iot20180120.Client;
import com.aliyun.iot20180120.models.*;
import com.aliyun.teaopenapi.models.Config;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibms.demo.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class IbmsApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException, ParseException {
        String time = "2021-01-11T08:58:25.000Z";
        Date data = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(time);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(data.getTime()));
    }

    @Test
    void testAli() throws Exception {
        String accessKeyId = "LTAI4G8Z3wBMDjd2vpNZW5fW";
        String accessKeySecret = "KgbT14iZ3EjwPzHYC2Eh15g8JYRzzj";
        Config config = new Config();
        // 您的AccessKey ID
        config.accessKeyId = accessKeyId;
        // 您的AccessKey Secret
        config.accessKeySecret = accessKeySecret;
        // 访问的域名
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        Client client = new Client(config);
        QueryProductListRequest queryProductRequest = new QueryProductListRequest()
                .setPageSize(30)
                .setCurrentPage(1);
        QueryProductListResponse response = client.queryProductList(queryProductRequest);
        List<QueryProductListResponseBody.QueryProductListResponseBodyDataListProductInfo> data = response.body.data.list.productInfo;
        for (QueryProductListResponseBody.QueryProductListResponseBodyDataListProductInfo info : data) {
            System.out.println(info.toMap());
        }
        QueryDeviceRequest queryDeviceRequest = new QueryDeviceRequest()
                .setPageSize(30)
                .setProductKey("a11fef3ti51")
                .setCurrentPage(1);
        QueryDeviceResponse response1 = client.queryDevice(queryDeviceRequest);
        List<QueryDeviceResponseBody.QueryDeviceResponseBodyDataDeviceInfo> deviceInfo = response1.body.data.deviceInfo;
        for (QueryDeviceResponseBody.QueryDeviceResponseBodyDataDeviceInfo info : deviceInfo) {
            System.out.println(info.toMap());
        }
    }

    @Autowired
    DeviceService deviceService;


}
