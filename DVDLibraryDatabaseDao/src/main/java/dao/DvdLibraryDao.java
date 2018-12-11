/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Map;
import model.DvdLibrary;

/**
 *
 * @author Farhan
 */
public interface DvdLibraryDao {


    DvdLibrary addDvdLibrary(DvdLibrary dvdInfo)throws DvdLibraryDaoException;

    List<DvdLibrary> getAllDvds()throws DvdLibraryDaoException;

    DvdLibrary getDvdById(int dvdID)throws DvdLibraryDaoException;

    void removeDvdLibrary(int dvdID)throws DvdLibraryDaoException;

    void editDvdLibrary(DvdLibrary dvdInfo)throws DvdLibraryDaoException;
    
    public List<DvdLibrary>getDvdByMpaa (String Mpaa)throws DvdLibraryDaoException;
    
    public List<DvdLibrary>getDvdByStudio (String Studio)throws DvdLibraryDaoException;
    
    public List <DvdLibrary> getDvdsReleasedNyears(int ageInYears)throws DvdLibraryDaoException;
}

