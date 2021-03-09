package com.amos.chasiersystem.service.distributor;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.*;

public interface Distributor {
    DistributorListResponse findAll();

    DistributorResponse findDistributorById(int distributorId) throws NotFoundException;

    void createDistributor(DistributorRequest request);
}
