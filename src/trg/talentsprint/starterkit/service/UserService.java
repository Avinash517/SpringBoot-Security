package trg.talentsprint.starterkit.service;

import java.util.List;
import java.util.Optional;

import trg.talentsprint.starterkit.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<Optional> findByid(long id);
}
