package com.assesment.movie.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "miraj", url = "http://localhost:9093/api/miraj")
public interface MirajClient extends IClient {
	
}
