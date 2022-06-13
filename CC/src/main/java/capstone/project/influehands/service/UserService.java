package capstone.project.influehands.service;

import capstone.project.influehands.model.UserModel;

public interface UserService {
    UserModel addUserInternal(UserModel userModel);
    UserModel getUserByUsername(String username);
    String encrypt(String password);
}
