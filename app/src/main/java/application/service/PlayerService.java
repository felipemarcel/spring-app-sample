package application.service;

import application.model.Player;
import application.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements BaseService<Player> {

    @Autowired
    private PlayerRepository repository;

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public List<Player> findAll(PageRequest request) {
        return repository.findAll(request).getContent();
    }

    @Override
    public Player findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Player update(Long id, Player player) {
        return null;
    }
}
