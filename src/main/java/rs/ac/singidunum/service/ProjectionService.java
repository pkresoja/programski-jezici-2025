package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.repo.ProjectionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectionService {

    private final ProjectionRepository repository;

    public List<Projection> getProjections() {
        return repository.findAllByDeletedAtIsNull();
    }

    public List<Projection> getFutureProjectionsByMovieId(Integer id) {
        return repository.findAllByMovieIdAndTimeAfterAndDeletedAtIsNull(id, LocalDateTime.now());
    }

    public Optional<Projection> getProjectionById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Projection createProjection(Projection model) {
        Projection projection = new Projection();
        projection.setMovieId(model.getMovieId());
        projection.setTime(model.getTime());
        projection.setCreatedAt(LocalDateTime.now());
        return repository.save(projection);
    }

    public Projection updateProjection(Integer id, Projection model) {
        Projection projection = getProjectionById(id).orElseThrow();
        projection.setMovieId(model.getMovieId());
        projection.setTime(model.getTime());
        projection.setUpdatedAt(LocalDateTime.now());
        return repository.save(projection);
    }

    public void deleteProjection(Integer id) {
        Projection projection = getProjectionById(id).orElseThrow();
        projection.setDeletedAt(LocalDateTime.now());
        repository.save(projection);
    }
}
