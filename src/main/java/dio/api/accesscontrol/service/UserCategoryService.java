package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.UserCategory;
import dio.api.accesscontrol.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    UserCategoryRepository userCategoryRepository;
    @Autowired
    public UserCategoryService(UserCategoryRepository userCategoryRepository){
        this.userCategoryRepository = userCategoryRepository;
    }

    public UserCategory saveUserCategory(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> getById(Long userCategoryId) {
        return userCategoryRepository.findById(userCategoryId);
    }

    public UserCategory updateUserCategory(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }

    public void deleteUserCategory(Long userCategoryId) {
        userCategoryRepository.deleteById(userCategoryId);
    }
}
