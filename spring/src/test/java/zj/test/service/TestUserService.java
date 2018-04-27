package zj.test.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import zj.entity.UserEntity;
import zj.service.IHelloService;
import zj.service.IUserService;
import zj.test.base.SpringTestBase;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author lzj
 * @date 2018/4/27
 */
public class TestUserService extends SpringTestBase {

    @InjectMocks
    @Autowired
    private IUserService userService;

    @Mock
    private IHelloService helloService;


    @Test
    public void testListAll() throws Exception {
        when(helloService.queryDb()).thenReturn(helloList);
        List<UserEntity> userList = userService.listAll();
        assertNull(userList);
        verify(helloService, times(1)).queryDb();

    }


    private List<String> helloList;

    @Before
    public void setUp() {
        helloList = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            helloList.add(i + "");
        }
    }

}
