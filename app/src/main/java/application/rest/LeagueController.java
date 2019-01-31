package application.rest;

import application.model.League;
import application.service.LeagueService;
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
@RequestMapping(value = "/leagues")
public class LeagueController {

    @Autowired
    private LeagueService service;

    @PostMapping
    public ResponseEntity<League> save(@Valid @RequestBody League league) throws URISyntaxException {
        League savedLeague = service.save(league);
        return created(new URI(savedLeague.getId().toString())).body(savedLeague);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public void update(@PathVariable(value = "id") Long id, @Valid @RequestBody League league) {
        service.update(id, league);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<League> find(@PathVariable(value = "id") Long id) {
        return ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<League>> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return ok(service.findAll(PageRequest.of(page, size)));
    }
}
