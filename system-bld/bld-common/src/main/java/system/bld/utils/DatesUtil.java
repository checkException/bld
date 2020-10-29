package system.bld.utils;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/10/23
 * @Time: 13:05
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DatesUtil {

	public static void main(String[] args) {
/*

		Long res=weekend("2019-12-1 13:11:00","2020-01-20 13:11:06",1);
		System.out.println(res);
*/

		System.out.println(Math.abs(DateUtil.parse("2020-10-28 16:30:14").getTime() - new Date().getTime()));

		System.out.println(DateUtil.parse("2020-10-28 18:22:14").compareTo(DateUtil.offsetMinute(new Date(),30))>0);
		//System.out.println(DateUtil.date(new Date()));
		//
		//List<Date> list= startMonthList(DateUtil.parse("2019-12-1 13:11:00"),DateUtil.parse("2020-01-20 13:11:06"),"14:10:11");
		/*System.out.println("-------------------------------");
		//List<Date> endMonthList= endMonthList(DateUtil.parse("2019-12-1 13:11:00"),DateUtil.parse("2020-10-31 13:11:06"),"13:10:11");
		System.out.println("-------------------------------");
		getDayOfWeekWithinDateInterval(DateUtil.parse("2019-12-1 13:11:00"),DateUtil.parse("2020-10-31 13:11:06"),5);
*/
	}

	/**
	 * 给定时间段和星期几，计算该时间段内共有多少个给定的星期几
	 * @param start 开始时间,格式yyyy-MM-dd
	 * @param end 结束时间，格式yyyy-MM-dd
	 * @param a 星期几，从星期一到星期天，分别用数字1-7表示
	 * @return 星期几统计数
	 */
	public static long weekend(String start,String end,int a){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//计数
		long sunDay = 0;
		try{
			//开始时间
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(format.parse(start));
			//结束时间
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(format.parse(end));
			//开始日期是星期几
			int SW = startDate.get(Calendar.DAY_OF_WEEK)-1;
			//结束日期是星期几
			int EW = endDate.get(Calendar.DAY_OF_WEEK)-1;

			long diff = endDate.getTimeInMillis()-startDate.getTimeInMillis();
			//给定时间段内一共有多少天
			long days = diff / (1000 * 60 * 60 * 24);
			//给定时间内，共有多少个星期
			long w = Math.round(Math.ceil(((days+SW+(7-EW))/7.0)));
			//总的星期几统计数
			sunDay = w;
			//给定的星期几小于起始日期的星期几，需要减少一天
			if(a<SW){
				sunDay--;
			}
			//给定的星期几大于结束日期的星期几，需要减少一天
			if(a>EW){
				sunDay--;
			}
		}catch(Exception se){
			se.printStackTrace();
		}
		return sunDay;
	}


	/**
	 * 获取某段时间内的周一（二等等）的日期
	 * @param dataBegin 开始日期
	 * @param dataEnd 结束日期
	 * @param weekDays 获取周几，1－6代表周一到周六。0代表周日
	 * @return 返回日期List
	 */
	public static List<String> getDayOfWeekWithinDateInterval(Date dataBegin, Date dataEnd, int weekDays) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dateResult = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		Date[] dateInterval = {dataBegin, dataEnd};
		Date[] dates = new Date[dateInterval.length];
		for (int i = 0; i < dateInterval.length; i++) {
			cal.setTime(dateInterval[i]);
			dates[i] = cal.getTime();
		}
		for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
				String format = sdf.format(date);
				System.out.println(format);
				dateResult.add(format);
			}
			cal.add(Calendar.DATE, 1);
			date = cal.getTime();
		}
		return dateResult;
	}


	public static List<Date> startMonthList(Date start, Date end, String timeStr){

		List<Date> dateList=new ArrayList<>();
		//月初
		while (true){
			String startTimeStr=DateUtil.format(DateUtil.beginOfMonth(start),"yyyy-MM-dd").concat(" ").concat(timeStr);

			Date startTime= DateUtil.parse(startTimeStr);

			if(startTime.compareTo(start)==1){
				startTime= DateUtil.beginOfMonth(DateUtil.offsetMonth(start,1));
			}

			start=DateUtil.offsetMonth(start,1);
			if(startTime.compareTo(end)>=1){
				break;
			}
			dateList.add(startTime);
			System.out.println(startTime);
		}

		return dateList;

	}

	public static List<Date> endMonthList(Date start, Date end, String timeStr){
		List<Date> dateList=new ArrayList<>();
		//月初
		while (true){
			String endTimeStr=DateUtil.format(DateUtil.endOfMonth(start),"yyyy-MM-dd").concat(" ").concat(timeStr);
			Date endTime= DateUtil.parse(endTimeStr);

			if(endTime.compareTo(start)<1){
				endTime= DateUtil.beginOfMonth(DateUtil.offsetMonth(start,1));
			}

			start=DateUtil.offsetMonth(start,1);

			if(endTime.compareTo(end)>=1){
				break;
			}
			dateList.add(endTime);
			System.out.println(endTime);
		}

		return dateList;
	}
}
