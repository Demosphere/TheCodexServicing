package persistence;
import entity.Level1;
import entity.Level2;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 4/24/16.
 */
public class AbstractDAOTest {
    AbstractDAO dao;
    Level1 levelTest;

    @Before
    public void setUp() {
        dao = new AbstractDAO<>(Level1.class);
        levelTest = new Level1();
        levelTest.setLevelOneID(1);
        levelTest.setListingName("Test");
        levelTest.setListingDescription("");
        levelTest.setVersionID(0);
        levelTest.setBookName("Test");
        levelTest.setPageNumber(0);
        Set<Level2> levelTwoTest = null;
        levelTest.setLevelTwo(levelTwoTest);
    }

    @Test
    public void testCreate() throws Exception {
        int createdId = dao.create(levelTest);
        Level1 difficultyCreated = (Level1) dao.get(createdId);
        assertTrue(levelTest.getLevelOneID() == difficultyCreated.getLevelOneID());
    }

    @Test
    public void testGet() throws Exception {
        int createdId = dao.create(levelTest);
        Level1 actualLevel = (Level1) dao.get(createdId);
        assertNotNull(actualLevel);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Level1> levelList = dao.getAll();
        assertTrue(levelList.size() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        int createdLevel = dao.create(levelTest);
        levelTest.setLevelOneID(createdLevel);
        levelTest.setListingName("Test - Update");
        dao.update(levelTest);
        Level1 updatedLevel = (Level1) dao.get(createdLevel);
        assertTrue(updatedLevel.getListingName().equals("Test - Update"));

    }

    @Test
    public void testDelete() throws Exception {
        int createdLevel = dao.create(levelTest);
        levelTest.setLevelOneID(createdLevel);
        dao.delete(levelTest);
        Level1 updatedLevel = (Level1) dao.get(createdLevel);
        assertNull(updatedLevel);
    }
}
