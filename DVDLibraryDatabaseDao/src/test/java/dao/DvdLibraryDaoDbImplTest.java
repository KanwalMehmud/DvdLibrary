/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import model.DvdLibrary;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Farhan
 */
public class DvdLibraryDaoDbImplTest {

    private DvdLibraryDao dao;

    public DvdLibraryDaoDbImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws DvdLibraryDaoException {
        // ask Spring for our DAO
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        dao = ctx.getBean("DvdDao", DvdLibraryDao.class);

        // remove all of the Contacts
        List<DvdLibrary> dvd = dao.getAllDvds();
        for (DvdLibrary currentDvd : dvd) {
            dao.removeDvdLibrary(currentDvd.getDvdID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDaoDbImpl.
     */
    @Test
    public void testAddDvd() throws Exception {
        DvdLibrary dvd1 = new DvdLibrary();
        dvd1.setTitle("SpiderMan");
        dvd1.setDirectorName("Kanwal");
        dvd1.setMpaaRating("G");
        dvd1.setStudio("Marvel");
        dvd1.setUserRating("4");
        String releaseYear = "2012/01/02";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        Date date = formatter.parse(releaseYear);
        LocalDate locaDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dvd1.setReleaseDate(locaDate);
        DvdLibrary newDvd = dao.addDvdLibrary(dvd1);

        assertNotNull(newDvd.getDvdID());
        assertEquals("SpiderMan", newDvd.getTitle());
    }

    @Test
    public void testRemoveDvd() throws Exception {
        DvdLibrary dvd1 = new DvdLibrary();
        dvd1.setTitle("Batman");
        dvd1.setDirectorName("Kanwal");
        dvd1.setMpaaRating("G");
        dvd1.setStudio("Marvel");
        dvd1.setUserRating("5");
        String releaseYear = "2012/01/06";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        Date date = formatter.parse(releaseYear);
        LocalDate locaDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dvd1.setReleaseDate(locaDate);

        DvdLibrary newDvd = dao.addDvdLibrary(dvd1);

        dao.removeDvdLibrary(newDvd.getDvdID());

        DvdLibrary dvd = dao.getDvdById(newDvd.getDvdID());

        assertNull(dvd);
    }

    @Test
    public void testGetAllDvds() throws Exception {

        DvdLibrary dvd1 = new DvdLibrary();
        dvd1.setTitle("Batman");
        dvd1.setDirectorName("Kanwal");
        dvd1.setMpaaRating("G");
        dvd1.setStudio("Marvel");
        dvd1.setUserRating("5");
        String releaseYear = "2012/01/06";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        Date date = formatter.parse(releaseYear);
        LocalDate locaDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dvd1.setReleaseDate(locaDate);

        DvdLibrary dvd2 = new DvdLibrary();
        dvd2.setTitle("SuperMan");
        dvd2.setDirectorName("Mary Sue");
        dvd2.setMpaaRating("G");
        dvd2.setStudio("Marvel");
        dvd2.setUserRating("1");
        dvd2.setReleaseDate(locaDate);

        dao.addDvdLibrary(dvd1);
        dao.addDvdLibrary(dvd2);

        List<DvdLibrary> allDvds = dao.getAllDvds();
        assertEquals(2, allDvds.size());
    }

}
