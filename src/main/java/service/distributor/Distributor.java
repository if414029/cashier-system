package service.distributor;

import common.NotFoundException;
import service.entity.*;

public interface Distributor {
    DistributorListResponse findAll();

    DistributorResponse findDistributorById(int distributorId) throws NotFoundException;

    void createDistributor(DistributorRequest request);
}
