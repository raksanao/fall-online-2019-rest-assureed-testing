package com.automation.office_hour.marufjon.day2;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class HamcrastDemo {
    @Test
    public void test1(){
        String one="text";
        String two="text";
        String three="text";
        assertThat(one ,is(two));
        assertThat(12,greaterThan(11));
assertThat(13,lessThan(14));
List<Integer> num= Arrays.asList(1,2,3,4);

assertThat(num,contains(1,2,3,4));
assertThat(num,hasSize(4));

    }
}
