package com.epam.demo.api;

import com.epam.demo.repository.IdentityRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "identities")
@AllArgsConstructor
public class IdentityActuatorEndpoint {

    private final IdentityRepository identityRepository;

    @ReadOperation
    public Map<String, String> identityEndpoint() {
        Map<String, String> map = new HashMap<>();
        map.put("ALL", identityRepository.findAll().toString());
        return map;
    }
}
