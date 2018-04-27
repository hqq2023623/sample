package zj.service;

import zj.entity.UserEntity;

import java.util.List;

/**
 * @author lzj
 * @date 2018/4/27
 */
public interface IUserService extends IBaseService<UserEntity> {

    List<UserEntity> listAll();


}
