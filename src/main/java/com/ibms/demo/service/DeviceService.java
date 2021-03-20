package com.ibms.demo.service;

import com.aliyun.iot20180120.Client;
import com.aliyun.iot20180120.models.*;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by gyh on 2021/3/2
 */
@Service
public class DeviceService {
    private final Client client;

    public DeviceService() throws Exception {
        Config config = new Config();
        // 您的AccessKey ID
        config.accessKeyId = "LTAI4G8Z3wBMDjd2vpNZW5fW";
        // 您的AccessKey Secret
        config.accessKeySecret = "KgbT14iZ3EjwPzHYC2Eh15g8JYRzzj";
        // 访问的域名
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        client = new Client(config);
    }

    public QueryProductListResponseBody getProductList(int page, int size) throws Exception {
        QueryProductListRequest queryProductRequest = new QueryProductListRequest()
                .setPageSize(size)
                .setCurrentPage(page);
        QueryProductListResponse response = client.queryProductList(queryProductRequest);
        return response.body;
    }

    public QueryDeviceResponseBody queryDevice(int page, int size, String productKey) throws Exception {
        QueryDeviceRequest queryDeviceRequest = new QueryDeviceRequest()
                .setPageSize(size)
                .setProductKey(productKey)
                .setCurrentPage(page);
        QueryDeviceResponse response = client.queryDevice(queryDeviceRequest);
        if (response.body.data.deviceInfo == null) {
            response.body.data.deviceInfo = Collections.emptyList();
        }
        return response.body;
    }
}
