package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.repository.SalesmanRepository;
import ku.cs.mu_odm_be.request.SalesmanRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Salesman createSalesman(SalesmanRequest req) {
        Salesman salesman = modelMapper.map(req, Salesman.class);
        salesmanRepository.save(salesman);
        return salesman;
    }

    public Salesman findSalesmanByID(UUID id) {
        return salesmanRepository.findById(id).get();
    }
}
