package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import static org.junit.Assert.*;

public class JobByNameTest {

    @Test
    public void whenCompareByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        jobs.sort(new JobByName());
        assertThat(jobs).isEqualTo(expected);
    }
}