package system.bld.controller.news;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import system.bld.controller.base.BaseController;
import system.bld.model.HotNewsRecords;
import system.bld.model.UserBase;
import system.bld.request.news.HotNewsRecordsRequest;
import system.bld.service.HotNewsRecordsService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author litao
 * @date 2025-02-18
 * @Desc
 */
@Controller
@RequestMapping("/news")
public class HotNewsRecordsController extends BaseController {

    @Autowired
    HotNewsRecordsService hotNewsRecordsService;

    @RequestMapping("/list")
    public String queryListPage(HttpServletRequest request, Model model){

        HotNewsRecordsRequest hotNewsRecordsRequest = new HotNewsRecordsRequest();
        hotNewsRecordsRequest.setPageSize(100);
        Page<HotNewsRecords> page = hotNewsRecordsService.queryPageTodayList(hotNewsRecordsRequest);

        model.addAttribute("newsList",page.getResult());
        model.addAttribute("cur_page",page.getPages());
        model.addAttribute("totalCount",page.getTotal());

        return "news/news-list";
    }
}
