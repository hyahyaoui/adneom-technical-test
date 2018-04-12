package com.adneom.listpartitioner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author hyahyaoui
 */
public class ListPartionerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_throw_an_illegal_argument_exception_when_partition_size_is_zero() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Size of partition must be greater than zero");
        // WHEN
        ListPartioner.partition(Arrays.asList("one", "two"), 0);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_partition_size_is_negative() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Size of partition must be greater than zero");
        // WHEN
        ListPartioner.partition(Arrays.asList("one", "two"), -1);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_given_list_is_null() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The list to be partitioned must contain at least one element");
        // WHEN
        ListPartioner.partition(null, 5);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_given_list_is_empty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The list to be partitioned must contain at least one element");
        // WHEN
        ListPartioner.partition(new ArrayList<>(), 5);
    }

    @Test
    public void should_return_one_partition_when_partition_size_is_greater_or_equal_to_list_size() throws Exception {
        List<Integer> toBePartitioned = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> partitions = ListPartioner.partition(toBePartitioned, 4);
        assertNotNull(partitions);
        assertEquals(1, partitions.size());
        assertEquals(toBePartitioned.size(), partitions.get(0).size());
    }

    @Test
    public void should_partition_list_with_same_sub_list_size_expect_last() throws Exception {
        List<Integer> toBePartitioned = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> partitions = ListPartioner.partition(toBePartitioned, 3);
        assertNotNull(partitions);
        assertEquals(3, partitions.size());
        assertEquals(2, partitions.get(2).size());
    }


    @Test
    public void should_partition_list_with_same_sub_list_size() throws Exception {
        List<String> toBePartitioned = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<List<String>> partitions = ListPartioner.partition(toBePartitioned, 3);
        assertNotNull(partitions);
        assertEquals(3, partitions.size());
        assertEquals(3, partitions.get(2).size());
    }


}