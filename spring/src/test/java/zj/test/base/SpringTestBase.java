package zj.test.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lzj
 * @date 2017/12/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ctx-test.xml"})
//@RunWith(MockitoJUnitRunner.class) == MockitoAnnotations.initMocks(this);
public abstract class SpringTestBase extends TestBaseRoot {

    @Before
    public void initMockito() {
        MockitoAnnotations.initMocks(this);
    }




}
