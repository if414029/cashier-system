package persistance.gateway.distributor;

import common.NotFoundException;
import persistance.entity.Distributor;
import persistance.repository.DistributorRepository;
import service.entity.DistributorListResponse;
import service.entity.DistributorRequest;
import service.entity.DistributorResponse;

import java.util.ArrayList;
import java.util.List;

public class DistributorJPAGateway implements DistributorGateway{

    private final DistributorRepository repository;

    public DistributorJPAGateway(DistributorRepository repository) {
        this.repository = repository;
    }

    @Override
    public DistributorListResponse findAll() {
        List<Distributor> distributorList = repository.findAll();
        return constructDistributorListResponse(distributorList);
    }

    @Override
    public DistributorResponse findDistributorById(int distributorId) throws NotFoundException {
        return repository.findById(distributorId)
                .map(this::constructDistributorResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + distributorId));
    }

    @Override
    public void createDistributor(DistributorRequest request) {
        Distributor entity = getDistributorEntity(request);
        repository.save(entity);
    }

    private Distributor getDistributorEntity(DistributorRequest request) {
        Distributor entity = new Distributor();
        entity.setDistributorName(request.getDistributorName());
        entity.setAddress(request.getAddress());
        entity.setNoPhone(request.getNoPhone());

        return entity;
    }

    private DistributorListResponse constructDistributorListResponse(List<Distributor> distributorList) {
        DistributorListResponse distributorListResponse = new DistributorListResponse();

        List<DistributorResponse> distributorResponses = new ArrayList<>();
        for (Distributor distributor : distributorList){
            distributorResponses.add(constructDistributorResponse(distributor));
        }

        distributorListResponse.setListDistributor(distributorResponses);

        return  distributorListResponse;
    }


    private DistributorResponse constructDistributorResponse(Distributor distributor) {
        DistributorResponse response = new DistributorResponse();
        response.setDistributorId(distributor.getDistributorId());
        response.setDistributorName(distributor.getDistributorName());
        response.setAddress(distributor.getAddress());
        response.setNoPhone(distributor.getNoPhone());

        return response;
    }
}
