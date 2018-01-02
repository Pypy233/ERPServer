package test.datatest;

import objects.DateHelper;
import objects.ResultMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateHelperTest {
    DateHelper dateHelper = new DateHelper();
    String s1 = "2017-12-12";
    String s2 = "2017-12-12";
    String s3 = "2016-12-12";
    String s4 = "2017-12-13";
    String s5 = "2017-12-12";
    String s6 = "2017-12-13";
    String s7 = "2017-01-01";
    String s8 = "2017-06-06";

    @Test
    public void getDate() throws Exception {
        System.out.println(dateHelper.getDate());
    }

    @Test
    public void isSameDay() throws Exception {
        System.out.println(dateHelper.getDate());

        boolean result1 = dateHelper.isSameDay(s1, s2);
        boolean result2 = dateHelper.isSameDay(s1, s3);
        boolean result3 = dateHelper.isSameDay(s1, s4);
        assertEquals(true, result1);
        assertEquals(false, result2);
        assertEquals(false, result3);
    }

    @Test
    public void isInRange() throws Exception {
        assertEquals(true, dateHelper.isInRange(s3, s2, s7));
        assertEquals(true, dateHelper.isInRange(s3, s2, s5));
        assertEquals(false, dateHelper.isInRange(s3, s2, s6));
        assertEquals(true, dateHelper.isInRange(s7, s6, s8));
    }

}