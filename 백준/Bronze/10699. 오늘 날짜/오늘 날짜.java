import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append("-0");
        sb.append(monthValue);
        sb.append("-");

        sb.append(dayOfMonth);
        System.out.println(sb);
    }
}
