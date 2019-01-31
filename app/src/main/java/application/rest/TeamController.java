package application.rest;

import application.model.Team;
import application.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @PostMapping
    public ResponseEntity<Team> save(@Valid @RequestBody Team team) throws URISyntaxException {
        Team savedTeam = service.save(team);
        return created(new URI(savedTeam.getId().toString()))
                .body(savedTeam);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(value = "id") Long id, @Valid @RequestBody Team team) {
        service.update(id, team);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Team> find(@PathVariable(value = "id") Long id) {
        return ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Team>> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                              @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return ok(service.findAll(PageRequest.of(page, size)));
    }
}
