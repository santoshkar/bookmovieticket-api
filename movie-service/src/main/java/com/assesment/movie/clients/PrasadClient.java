package com.assesment.movie.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "prasad", url = "http://localhost:9092/api/prasad")
public interface PrasadClient extends IClient {
}
