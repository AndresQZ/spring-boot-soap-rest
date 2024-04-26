package io.github.andresqz.repository;

import io.github.andresqz.model.TraceRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceRequestRepository extends CrudRepository<TraceRequest, Long> {
    List<TraceRequest> findById(String lastName);
}
