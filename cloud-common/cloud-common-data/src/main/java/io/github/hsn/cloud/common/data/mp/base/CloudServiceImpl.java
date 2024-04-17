package io.github.hsn.cloud.common.data.mp.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class CloudServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
}
