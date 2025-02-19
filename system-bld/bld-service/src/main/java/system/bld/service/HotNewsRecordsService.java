package system.bld.service;

import com.github.pagehelper.Page;
import system.bld.model.HotNewsRecords;
import system.bld.request.news.HotNewsRecordsRequest;

/**
 * @author litao
 * @date 2025-02-18
 * @Desc 
 */

public interface HotNewsRecordsService {

    Page<HotNewsRecords> queryPageTodayList(HotNewsRecordsRequest hotNewsRecordsRequest);
}
