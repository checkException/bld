package system.bld.service.impl.news;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.HotNewsRecordsDao;
import system.bld.model.HotNewsRecords;
import system.bld.request.news.HotNewsRecordsRequest;
import system.bld.service.HotNewsRecordsService;

import java.util.Map;

/**
 * @author litao
 * @date 2025-02-18
 * @Desc
 */
@Service
public class HotNewsRecordsServiceImpl implements HotNewsRecordsService {
    private static final Logger logger = LoggerFactory.getLogger(HotNewsRecordsServiceImpl.class);

    @Autowired
    HotNewsRecordsDao hotNewsRecordsDao;

    @Override
    public Page<HotNewsRecords> queryPageTodayList(HotNewsRecordsRequest hotNewsRecordsRequest) {

        Map<String,Object> map = BeanUtil.beanToMap(hotNewsRecordsRequest);

        PageHelper.startPage(hotNewsRecordsRequest.getPageNum(),hotNewsRecordsRequest.getPageSize());

        Page<HotNewsRecords> page = (Page<HotNewsRecords>)hotNewsRecordsDao.selectToDayPageList(map);

        return page;
    }
}
