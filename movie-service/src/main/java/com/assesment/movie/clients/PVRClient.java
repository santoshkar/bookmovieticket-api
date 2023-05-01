package com.assesment.movie.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "pvr", url = "http://localhost:9091/api/pvr")
public interface PVRClient extends IClient {
}
