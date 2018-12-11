/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.DvdLibrary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Farhan
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {

    //prepared statements
    private static final String SQL_INSERT_DVD
            = "insert into dvd "
            + "(title, releaseDate, mpaaRating, directorName, studio, userRating) "
            + "values (?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE_DVD
            = "delete from dvd where dvdId = ? ";
    private static final String SQL_SELECT_DVD
            = " select * from dvd where dvdID = ? ";
    private static final String SQL_UPDATE_DVD
            = "update dvd set "
            + "title = ?, releaseDate = ?, directorName = ?, studio = ?, userRating = ? "
            + "where dvdId = ? ";
    private static final String SQL_SELECT_ALL_DVDS
            = "select * from dvd ";
    private static final String SQL_SELECT_DVD_BY_MPAA
            = "select * from dvd where mpaaRating = ? ";
    private static final String SQL_SELECT_DVD_BY_STUDIO
            = "select * from dvd where studio = ? ";

    //JdbcTemplate instance to execute the prepared statements against the database
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DvdLibrary addDvdLibrary(DvdLibrary dvdInfo) throws DvdLibraryDaoException {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvdInfo.getTitle(),
                dvdInfo.getReleaseDate().toString(),
                dvdInfo.getMpaaRating(),
                dvdInfo.getDirectorName(),
                dvdInfo.getStudio(),
                dvdInfo.getUserRating());

        //getting new id from database
        int newID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        //setting the new id value on the dvdInfo object and returning it
        dvdInfo.setDvdID(newID);

        return dvdInfo;

    }

    @Override
    public List<DvdLibrary> getAllDvds() throws DvdLibraryDaoException {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public DvdLibrary getDvdById(int dvdID) throws DvdLibraryDaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), dvdID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public void removeDvdLibrary(int dvdID) throws DvdLibraryDaoException {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdID);
    }

    @Override
    public void editDvdLibrary(DvdLibrary dvdInfo) throws DvdLibraryDaoException {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvdInfo.getTitle(),
                dvdInfo.getReleaseDate().toString(),
                dvdInfo.getDirectorName(),
                dvdInfo.getStudio(),
                dvdInfo.getUserRating(),
                dvdInfo.getDvdID());
    }

    @Override
    public List<DvdLibrary> getDvdByMpaa(String mpaa) throws DvdLibraryDaoException {
        try {
            return jdbcTemplate.query(SQL_SELECT_DVD_BY_MPAA, new DvdMapper(), mpaa);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<DvdLibrary> getDvdByStudio(String studio) throws DvdLibraryDaoException {
        try {
            return jdbcTemplate.query(SQL_SELECT_DVD_BY_STUDIO, new DvdMapper(), studio);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<DvdLibrary> getDvdsReleasedNyears(int ageInYears) throws DvdLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class DvdMapper implements RowMapper<DvdLibrary> {

        public DvdLibrary mapRow(ResultSet rs, int rowNum) throws SQLException {
            DvdLibrary dvd = new DvdLibrary();
            dvd.setDvdID(rs.getInt("dvdId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getTimestamp("releaseDate").toLocalDateTime().toLocalDate());
            dvd.setMpaaRating(rs.getString("mpaaRating"));
            dvd.setDirectorName(rs.getString("directorName"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setUserRating(rs.getString("userRating"));
            return dvd;
        }
    }
}
