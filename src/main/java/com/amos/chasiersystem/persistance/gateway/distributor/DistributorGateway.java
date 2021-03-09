package com.amos.chasiersystem.persistance.gateway.distributor;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.DistributorListResponse;
import com.amos.chasiersystem.service.entity.DistributorRequest;
import com.amos.chasiersystem.service.entity.DistributorResponse;

public interface DistributorGateway {
    DistributorListResponse findAll();

    DistributorResponse findDistributorById(int distributorId) throws NotFoundException;

    void createDistributor(DistributorRequest request);
}
