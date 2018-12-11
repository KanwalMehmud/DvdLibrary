/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarydatabasedao;

import dao.DvdLibraryDao;
import dao.DvdLibraryDaoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.DvdLibrary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kanwal
 */
@Controller
public class DvdController {

    DvdLibraryDao dao;

    @Inject
    public DvdController(DvdLibraryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayDvdPage", method = RequestMethod.GET)
    public String displayDvdsPage(Model model) throws DvdLibraryDaoException {
        List<DvdLibrary> dvds = dao.getAllDvds();
        model.addAttribute("dvds", dvds);
        return "dvds";
    }

    @RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
    public String deleteDvd(HttpServletRequest request) throws DvdLibraryDaoException {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        dao.removeDvdLibrary(dvdId);
        return "redirect:displayDvdPage";
    }

    @RequestMapping(value = "/displayCreateDvdPage", method = RequestMethod.GET)
    public String displayCreateDvdPage() {
        return "createDvd";
    }

    @RequestMapping(value = "/createDvd", method = RequestMethod.POST)
    public String createDvd(HttpServletRequest request) throws DvdLibraryDaoException, ParseException {
        DvdLibrary dvd = new DvdLibrary();
        dvd.setTitle(request.getParameter("title"));
        String releaseYear = request.getParameter("releaseDate");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        Date date = formatter.parse(releaseYear);
        LocalDate locaDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dvd.setReleaseDate(locaDate);
        dvd.setMpaaRating(request.getParameter("mpaaRating"));
        dvd.setDirectorName(request.getParameter("directorName"));
        dvd.setStudio(request.getParameter("studio"));
        dvd.setUserRating(request.getParameter("userRating"));
        dao.addDvdLibrary(dvd);
        return "redirect:displayDvdPage";
    }
    @RequestMapping(value = "/displayEditDvdForm", method = RequestMethod.GET)
public String displayEditDvdForm(HttpServletRequest request, Model model) throws DvdLibraryDaoException {
    String dvdIdParameter = request.getParameter("dvdId");
    int dvdId = Integer.parseInt(dvdIdParameter);
    DvdLibrary dvd= dao.getDvdById(dvdId);
    model.addAttribute("editDvd", dvd);
    return "editDvd";
}
@RequestMapping(value = "/editDvd", method = RequestMethod.POST)
public String editDvd(@Valid @ModelAttribute("editDvd") DvdLibrary dvd, BindingResult result) throws DvdLibraryDaoException {

    if (result.hasErrors()) {
        return "editDvd";
    }

    dao.editDvdLibrary(dvd);

    return "redirect:displayDvdPage";
}
}
