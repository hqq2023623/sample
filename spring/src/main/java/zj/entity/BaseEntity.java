package zj.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author lzj
 * @date 2018/4/27
 */
public abstract class BaseEntity {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
