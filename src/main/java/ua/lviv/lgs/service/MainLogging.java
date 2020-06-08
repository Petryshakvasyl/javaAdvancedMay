package ua.lviv.lgs.service;

import org.apache.log4j.Logger;
import ua.lviv.lgs.eintity.User;
import ua.lviv.lgs.repository.UserRepository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;

public class MainLogging {

    private static final Logger LOG = Logger.getLogger(MainLogging.class);

    public static void main(String[] args) {

            LOG.info("main is started ...");

            LOG.debug("find user by id ");

            LOG.warn("this is my warn");

            try {
                throw new FileNotFoundException("txt.txt was not found");
            } catch (FileNotFoundException e) {
                LOG.error("error logging ", e);
            }

            LOG.debug("find all users ");

            LOG.info("main is finished ...");

    }
}
