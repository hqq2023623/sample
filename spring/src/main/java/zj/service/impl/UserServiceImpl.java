package zj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zj.entity.UserEntity;
import zj.mapper.MapperBase;
import zj.mapper.UserMapper;
import zj.service.IHelloService;
import zj.service.IUserService;

import java.util.List;

/**
 * @author lzj
 * @date 2018/4/27
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements IUserService {

    @Autowired
    private IHelloService helloService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> listAll() {
        List<String> helloList = helloService.queryDb();
        if (!helloList.isEmpty()) {
            helloList.forEach(System.err::print);
        }
        super.selectAll();
        return null;
    }

    @Override
    public MapperBase<UserEntity> getBaseMapper() {
        return userMapper;
    }
}
