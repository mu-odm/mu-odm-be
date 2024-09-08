package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    public Salesman createSalesman(Salesman salesman) {
        return salesmanRepository.save(salesman);
    }

    public Salesman findById(UUID id) {
        return salesmanRepository.findById(id).get();
    }
}
