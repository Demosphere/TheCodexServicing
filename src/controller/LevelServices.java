package controller;

import entity.Level1;
import entity.Level2;
import entity.Level3;
import entity.Level4;
import org.apache.log4j.Logger;
import persistence.AbstractDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This class is the basis for the Level REST client. It will handle all of the CRUD calls for the application.
 * Created by michaeld on 3/31/2016.
 */
@Path("/html/Level")
public class LevelServices {
    private final Logger log = Logger.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();
    private AbstractDAO<Level1> levelOneDAO = new AbstractDAO<>(Level1.class);
    private AbstractDAO<Level2> levelTwoDAO = new AbstractDAO<>(Level2.class);
    private AbstractDAO<Level3> levelThreeDAO = new AbstractDAO<>(Level3.class);
    private AbstractDAO<Level4> levelFourDAO = new AbstractDAO<>(Level4.class);


    /**
     * This method will return a JSON object of the entire table structure. Any @GET attempts should result in this
     * scructure being returned.
     * @return JSON Level1
     */
    @GET
    @Path("/One")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneGetAll() throws Exception {
        List<Level1> levels = levelOneDAO.getAll();
        log.info(levels);
        return mapper.writeValueAsString(levels);
    }

    /**
     * This method will take in a Level1 Entity object and insert it into the database.
     * @param levelOne - Entity
     * @return JSON Level1
     */
    @PUT
    @Path("/One/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneInsert(Level1 levelOne) throws Exception {
        levelOneDAO.create(levelOne);
        log.info("\n\n" + mapper.writeValueAsString(levelOne) + "\n\n");
        return mapper.writeValueAsString(levelOne);
    }

    /**
     * This method will take in a Level1 Entity object and update that object corresponding database row.
     * @param levelOne - Entity
     * @return JSON Level1
     */
    @POST
    @Path("/One/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneUpdate(Level1 levelOne) throws Exception {
        levelOneDAO.update(levelOne);
        log.info("\n\n" + mapper.writeValueAsString(levelOne) + "\n\n");
        return mapper.writeValueAsString(levelOne);
    }

    /**
     * This method will take in a Level1 Entity object and delete that objects corresponding database row.
     * @param levelOne - Entity
     * @return JSON Level1
     */
    @PUT
    @Path("/One/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneDelete(Level1 levelOne) throws Exception {
        log.info("\n\n" + mapper.writeValueAsString(levelOne) + "\n\n");
        if (levelOne.getLevelTwo().size() == 0) {
            levelOneDAO.delete(levelOne);
            return mapper.writeValueAsString(levelOne);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    /**
     * This method will take in a Level2 Entity object and insert that object into the database.
     * @param levelTwo - Entity
     * @return JSON Level2
     */
    @PUT
    @Path("/Two/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoInsert(Level2 levelTwo) throws Exception {
        levelTwoDAO.create(levelTwo);
        log.info("\n\n" + mapper.writeValueAsString(levelTwo) + "\n\n");
        return mapper.writeValueAsString(levelTwo);
    }

    /**
     * This method will take in a Level2 Entity object and update that corresponding objects database row.
     * @param levelTwo - Entity
     * @return JSON Level2
     */
    @POST
    @Path("/Two/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoUpdate(Level2 levelTwo) throws Exception {
        levelTwoDAO.update(levelTwo);
        log.info("\n\n" + mapper.writeValueAsString(levelTwo) + "\n\n");
        return mapper.writeValueAsString(levelTwo);
    }

    /**
     * This method will take in a Level2 Entity object and update that corresponding objects database row.
     * @param levelTwo - Entity
     * @return JSON Level2
     */
    @PUT
    @Path("/Two/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoDelete(Level2 levelTwo) throws Exception {
        log.info("\n\n" + mapper.writeValueAsString(levelTwo) + "\n\n");
        if (levelTwo.getLevelThree().size() == 0) {
            levelTwoDAO.delete(levelTwo);
            return mapper.writeValueAsString(levelTwo);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    /**
     * This method will take in a Level3 Entity object and insert it into the database.
     * @param levelThree - Entity
     * @return JSON Level3
     */
    @PUT
    @Path("/Three/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeInsert(Level3 levelThree) throws Exception {
        levelThreeDAO.create(levelThree);
        log.info("\n\n" + mapper.writeValueAsString(levelThree) + "\n\n");
        return mapper.writeValueAsString(levelThree);
    }

    /**
     * This method will take in a Level3 Entity object and update its corresponding row in the database.
     * @param levelThree - Entity
     * @return JSON Level3
     */
    @POST
    @Path("/Three/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeUpdate(Level3 levelThree) throws Exception {
        levelThreeDAO.update(levelThree);
        log.info("\n\n" + mapper.writeValueAsString(levelThree) + "\n\n");
        return mapper.writeValueAsString(levelThree);
    }

    /**
     * This method will take in a Level3 Entity object and delete its corresponding row in the database.
     * @param levelThree - Entity
     * @return JSON Level3
     */
    @PUT
    @Path("/Three/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeDelete(Level3 levelThree) throws Exception {
        log.info("\n\n" + mapper.writeValueAsString(levelThree) + "\n\n");
        if (levelThree.getLevelFour().size() == 0) {
            levelThreeDAO.delete(levelThree);
            return mapper.writeValueAsString(levelThree);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    /**
     * This method will take in a Level4 Entity object and insert it into the database.
     * @param levelFour - Entity
     * @return JSON Level4
     */
    @PUT
    @Path("/Four/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourInsert(Level4 levelFour) throws Exception {
        levelFourDAO.create(levelFour);
        log.info("\n\n" + mapper.writeValueAsString(levelFour) + "\n\n");
        return mapper.writeValueAsString(levelFour);
    }

    /**
     * This method will take in a Level4 Entity object and update its corresponding row in the database.
     * @param levelFour - Entity
     * @return JSON Level4
     */
    @POST
    @Path("/Four/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourUpdate(Level4 levelFour) throws Exception {
        levelFourDAO.update(levelFour);
        log.info("\n\n" + mapper.writeValueAsString(levelFour) + "\n\n");
        return mapper.writeValueAsString(levelFour);
    }

    /**
     * This method will take in a Level4 Entity object and delete its corresponding row in the database.
     * @param levelFour - Entity
     * @return JSON Level4
     */
    @PUT
    @Path("/Four/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourDelete(Level4 levelFour) throws Exception {
        log.info("\n\n" + mapper.writeValueAsString(levelFour) + "\n\n");
        levelFourDAO.delete(levelFour);
        return mapper.writeValueAsString(levelFour);
    }
}
