package application.rest;

import application.model.Player;
import application.service.PlayerService;
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
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<Player> save(@Valid @RequestBody Player player) throws URISyntaxException {
        Player savedPlayer = service.save(player);
        return created(new URI(savedPlayer.getId().toString())).body(savedPlayer);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public void update(@PathVariable(value = "id") Long id, @Valid @RequestBody Player player) {
        service.update(id, player);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> find(@PathVariable(value = "id") Long id) {
        return ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return ok(service.findAll(PageRequest.of(page, size)));
    }
}
