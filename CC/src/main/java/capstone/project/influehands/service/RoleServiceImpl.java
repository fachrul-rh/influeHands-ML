package capstone.project.influehands.service;

import capstone.project.influehands.repository.RoleDb;
import capstone.project.influehands.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDb roleDb;

    @Override
    public RoleModel getRoleById(Long id) {
        Optional<RoleModel> role = roleDb.findById(id);
        if(role.isPresent()) {
            return role.get();
        } else {
            throw new NoSuchElementException();
        }
    }


}