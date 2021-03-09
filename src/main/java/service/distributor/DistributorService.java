package service.distributor;

import common.NotFoundException;
import persistance.gateway.distributor.DistributorGateway;
import service.entity.DistributorListResponse;
import service.entity.DistributorRequest;
import service.entity.DistributorResponse;

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
