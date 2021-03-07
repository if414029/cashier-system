package persistance.gateway.distributor;

import persistance.entity.Distributor;

import java.util.List;

public interface DistributorGateway {
    List<Distributor> findAll();

    Distributor findDistributorById(int distributorId);

    void createDistributor(Distributor distributor);
}
