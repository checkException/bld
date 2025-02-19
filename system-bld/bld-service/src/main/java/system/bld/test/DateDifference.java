package system.bld.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author litao
 * @date 2025-02-06
 * @Desc 用Java写一个获取两个日期相差天数的方法
 */
public class DateDifference {
    public static void main(String[] args) {
        // 定义两个日期
        LocalDate date1 = LocalDate.of(2024, 10, 1);
        LocalDate date2 = LocalDate.of(2024, 10, 15);

        // 计算两个日期之间的天数差
        long daysBetween = getDaysBetween(date1, date2);

        // 输出结果
        System.out.println("两个日期相差的天数: " + daysBetween);
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期之间的天数差
     */
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        // 使用 ChronoUnit.DAYS.between 计算天数差
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
