package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.service.ProjectionService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/projection")
public class ProjectionController {

    private final ProjectionService service;

    @GetMapping
    public List<Projection> getProjections() {
        return service.getProjections();
    }

    @GetMapping(path = "/movie/{id}")
    public List<Projection> getFuture(@PathVariable Integer id) {
        return service.getFutureProjectionsByMovieId(id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Projection> getById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getProjectionById(id));
    }

    @PostMapping
    public Projection create(@RequestBody Projection model) {
        return service.createProjection(model);
    }

    @PutMapping(path = "/{id}")
    public Projection update(@PathVariable Integer id ,@RequestBody Projection model) {
        return service.updateProjection(id, model);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteProjection(id);
    }

}
