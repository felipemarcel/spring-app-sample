package application.service;

import application.model.League;
import application.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService implements BaseService<League> {

    @Autowired
    private LeagueRepository repository;

    @Override
    public League save(League league) {
        return repository.save(league);
    }

    @Override
    public List<League> findAll(PageRequest request) {
        return repository.findAll(request).getContent();
    }

    @Override
    public League findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public League update(Long id, League league) {
        return null;
    }
}
