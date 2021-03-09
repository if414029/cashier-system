package com.amos.chasiersystem.persistance.gateway.distributor;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.persistance.entity.Distributor;
import com.amos.chasiersystem.persistance.repository.DistributorRepository;
import com.amos.chasiersystem.service.entity.DistributorListResponse;
import com.amos.chasiersystem.service.entity.DistributorRequest;
import com.amos.chasiersystem.service.entity.DistributorResponse;

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
