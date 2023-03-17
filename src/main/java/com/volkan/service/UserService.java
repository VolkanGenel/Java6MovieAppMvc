package com.volkan.service;

import com.volkan.dto.request.UserLoginRequestDto;
import com.volkan.dto.request.UserRegisterRequestDto;
import com.volkan.dto.response.LoginResponseDto;
import com.volkan.mapper.IUserMapper;
import com.volkan.repository.IUserRepository;
import com.volkan.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IServiceCrud<User>{
    @Autowired
    private IUserRepository repository;

    public User save(String name, String surname, String password, String email) {
        User user = User.builder()
                .name(name)
                .surName(surname)
                .password(password)
                .email(email)
                .build();
       return repository.save(user);
    }

    public User register(UserRegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .email(dto.getEmail())
                .build();
        return repository.save(user);
    }

    public User register2(UserRegisterRequestDto dto) {
        if(repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Kullanici adi zaten kayitli");
        }
        if (!dto.getPassword().equals(dto.getRePassword())) {
            throw new RuntimeException("Girdiğiniz şifreler uyuşmuyor");
        }
        User user=IUserMapper.INSTANCE.toUser(dto);
        return repository.save(user);
    }

    public List<User> findAllByOrderByName() {
        List<User> userlist = repository.findAllByOrderByName();
        return userlist;
    }
    public List<User> findByNameContainingIgnoreCase(String ifade) {
        List<User> userlist = repository.findByNameContainingIgnoreCase(ifade);
        return userlist;
    }
    public List<User> findByEmailContainingIgnoreCase(String ifade) {
        List<User> userlist = repository.findByEmailContainingIgnoreCase(ifade);
        return userlist;
    }
    public List<User> findByEmailEndingWithIgnoreCase(String ifade) {
        List<User> userlist = repository.findByEmailEndingWithIgnoreCase(ifade);
        return userlist;
    }

    public LoginResponseDto doLogin(UserLoginRequestDto userLoginRequestDto) {
        Optional<User> user = repository.findOptionalByEmailAndPassword(userLoginRequestDto.getEmail(),userLoginRequestDto.getPassword());
        if (user.isEmpty())
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı");
        return IUserMapper.INSTANCE.toLoginResponseDto(user.get());
    }
    public List<User> passwordLongerThan(int value) {
        return repository.passwordLongerThan(value);
    }
    public List<User> passwordLongerThan2(int value) {
        return repository.passwordLongerThan2(value);
    }
    public List<User> passwordLongerThan3(int value) {
        return repository.passwordLongerThan3(value);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return repository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return repository.findById(id);
    }
}
