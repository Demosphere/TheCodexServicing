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
 * Created by michaeld on 3/31/2016.
 */
@Path("/Level")
public class LevelServices {
    private final Logger log = Logger.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();
    private AbstractDAO<Level1> levelOneDAO = new AbstractDAO<>(Level1.class);
    private AbstractDAO<Level2> levelTwoDAO = new AbstractDAO<>(Level2.class);
    private AbstractDAO<Level3> levelThreeDAO = new AbstractDAO<>(Level3.class);
    private AbstractDAO<Level4> levelFourDAO = new AbstractDAO<>(Level4.class);

    @GET
    @Path("/One")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneGetAll() throws Exception {
        List<Level1> levels = levelOneDAO.getAll();
        log.info(levels);
        return mapper.writeValueAsString(levels);
    }

    @PUT
    @Path("/One")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneInsert(Level1 levelOne) throws Exception {
        levelOneDAO.create(levelOne);
        log.info("\n\n" + mapper.writeValueAsString(levelOne) + "\n\n");
        return mapper.writeValueAsString(levelOne);
    }

    @POST
    @Path("/One")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneUpdate(Level1 levelOne) throws Exception {
        levelOneDAO.update(levelOne);
        log.info("\n\n" + mapper.writeValueAsString(levelOne) + "\n\n");
        return mapper.writeValueAsString(levelOne);
    }

    @DELETE
    @Path("/One")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelOneDelete(String levelOne) throws Exception {
        Level1 levelToDelete = mapper.readValue(levelOne, Level1.class);
        log.info("\n\n" + mapper.writeValueAsString(levelToDelete) + "\n\n");
        if (levelToDelete.getLevelTwo().size() == 0) {
            levelOneDAO.delete(levelToDelete);
            return mapper.writeValueAsString(levelToDelete);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    @PUT
    @Path("/Two")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoInsert(Level2 levelTwo) throws Exception {
        levelTwoDAO.create(levelTwo);
        log.info("\n\n" + mapper.writeValueAsString(levelTwo) + "\n\n");
        return mapper.writeValueAsString(levelTwo);
    }

    @POST
    @Path("/Two")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoUpdate(Level2 levelTwo) throws Exception {
        levelTwoDAO.update(levelTwo);
        log.info("\n\n" + mapper.writeValueAsString(levelTwo) + "\n\n");
        return mapper.writeValueAsString(levelTwo);
    }

    @DELETE
    @Path("/Two")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelTwoDelete(String levelTwo) throws Exception {
        Level2 levelToDelete = mapper.readValue(levelTwo, Level2.class);
        log.info("\n\n" + mapper.writeValueAsString(levelToDelete) + "\n\n");
        if (levelToDelete.getLevelThree().size() == 0) {
            levelTwoDAO.delete(levelToDelete);
            return mapper.writeValueAsString(levelToDelete);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    @PUT
    @Path("/Three")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeInsert(Level3 levelThree) throws Exception {
        levelThreeDAO.create(levelThree);
        log.info("\n\n" + mapper.writeValueAsString(levelThree) + "\n\n");
        return mapper.writeValueAsString(levelThree);
    }

    @POST
    @Path("/Three")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeUpdate(Level3 levelThree) throws Exception {
        levelThreeDAO.update(levelThree);
        log.info("\n\n" + mapper.writeValueAsString(levelThree) + "\n\n");
        return mapper.writeValueAsString(levelThree);
    }

    @DELETE
    @Path("/Three")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelThreeDelete(String levelThree) throws Exception {
        Level3 levelToDelete = mapper.readValue(levelThree, Level3.class);
        log.info("\n\n" + mapper.writeValueAsString(levelToDelete) + "\n\n");
        if (levelToDelete.getLevelFour().size() == 0) {
            levelThreeDAO.delete(levelToDelete);
            return mapper.writeValueAsString(levelToDelete);
        } else {
            return "{'status' : 'FAIL'}";
        }
    }

    @PUT
    @Path("/Four")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourInsert(Level4 levelFour) throws Exception {
        levelFourDAO.create(levelFour);
        log.info("\n\n" + mapper.writeValueAsString(levelFour) + "\n\n");
        return mapper.writeValueAsString(levelFour);
    }

    @POST
    @Path("/Four")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourUpdate(Level4 levelFour) throws Exception {
        levelFourDAO.update(levelFour);
        log.info("\n\n" + mapper.writeValueAsString(levelFour) + "\n\n");
        return mapper.writeValueAsString(levelFour);
    }

    @DELETE
    @Path("/Four")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelFourDelete(String levelFour) throws Exception {
        Level4 levelToDelete = mapper.readValue(levelFour, Level4.class);
        log.info("\n\n" + mapper.writeValueAsString(levelToDelete) + "\n\n");
        levelFourDAO.delete(levelToDelete);
        return mapper.writeValueAsString(levelToDelete);
    }
}
