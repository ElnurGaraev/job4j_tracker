package ru.job4j.tracker.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item2);
        List<Item> expected = List.of(item2);
        assertThat(tracker.findByName("item2")).isEqualTo(expected);
    }

    @Test
    public void whenSaveItemsAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = List.of(item, item2, item3);
        assertThat(tracker.findAll()).isEqualTo(items);
    }

    @Test
    public void whenSaveItemsAndDeleteThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.delete(item.getId())).isTrue();
    }

    @Test
    public void whenSaveItemsAndReplaceThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.replace(item.getId(), item2);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(item2.getName());
    }
}
