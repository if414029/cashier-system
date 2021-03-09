package service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistributorListResponse extends ServiceResponse{
    private List<DistributorResponse> listDistributor;
}
