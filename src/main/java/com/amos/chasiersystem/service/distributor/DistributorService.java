package com.amos.chasiersystem.service.distributor;

import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.stereotype.Service;
import com.amos.chasiersystem.persistance.gateway.distributor.DistributorGateway;
import com.amos.chasiersystem.service.entity.DistributorListResponse;
import com.amos.chasiersystem.service.entity.DistributorRequest;
import com.amos.chasiersystem.service.entity.DistributorResponse;

@Service
public class DistributorService implements Distributor{

    private final DistributorGateway gateway;

    public DistributorService(DistributorGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public DistributorListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public DistributorResponse findDistributorById(int distributorId) throws NotFoundException {
        return gateway.findDistributorById(distributorId);
    }

    @Override
    public void createDistributor(DistributorRequest request) {
        gateway.createDistributor(request);
    }
}
