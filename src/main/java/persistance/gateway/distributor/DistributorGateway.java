package persistance.gateway.distributor;

import common.NotFoundException;
import persistance.entity.Distributor;
import service.entity.DistributorListResponse;
import service.entity.DistributorRequest;
import service.entity.DistributorResponse;

import java.util.List;

public interface DistributorGateway {
    DistributorListResponse findAll();

    DistributorResponse findDistributorById(int distributorId) throws NotFoundException;

    void createDistributor(DistributorRequest request);
}
