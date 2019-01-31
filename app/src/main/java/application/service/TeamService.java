package application.service;

import application.model.Team;
import application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements BaseService<Team> {

    @Autowired
    private TeamRepository repository;


    @Override
    public Team save(Team team) {
        return repository.save(team);
    }

    @Override
    public List<Team> findAll(PageRequest request) {
        return repository.findAll(request).getContent();
    }

    @Override
    public Team findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Team update(Long id, Team team) {
        Team t = findById(id);
        return null;
    }
}
