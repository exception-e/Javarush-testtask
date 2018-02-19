package com.study.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.study.model.Note;
import com.study.service.NoteService;

@Controller
public class NoteController {
    private static final Logger logger = Logger.getLogger(NoteController.class);
    @Autowired
    private NoteService NoteService;
    private int page = 1;
    private String filterValue = "All";
    private String order = "DESC";

    public NoteController() {
        System.out.println("NoteController()");
    }

    @RequestMapping({"/mynotesapp"})
    public ModelAndView listNote(ModelAndView model) throws Exception {
        List<Note> allNotes = this.NoteService.getAllNotes(filterValue, page, order);
        model.addObject("allNotes", allNotes);
        model.addObject("currentPage", page);
        model.addObject("filter", filterValue);
        model.addObject("order", order);
        model.addObject("count", NoteService.getCount());
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mynotesapp/list"})

    public ModelAndView list(HttpServletRequest request, ModelAndView model) throws Exception {

        List<Note> allNotes = this.NoteService.getAllNotes(filterValue, page, order);
        model.addObject("count", NoteService.getCount());
        model.addObject("allNotes", allNotes);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mynotesapp/listDone"})

    public ModelAndView listDone(ModelAndView model) throws Exception {
        List<Note> allNotes = this.NoteService.getAllNotes("Done", page, order);
        model.addObject("count", NoteService.getCount());
        model.addObject("allNotes", allNotes);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mynotesapp/listNotDone"})
    public ModelAndView listNotDone(ModelAndView model) throws Exception {
        List<Note> allNotes = this.NoteService.getAllNotes("NotDone", page, order);
        model.addObject("count", NoteService.getCount());
        model.addObject("allNotes", allNotes);
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping({"/mynotesapp/listAll"})
    public ModelAndView listAll(ModelAndView model) throws Exception {
        List<Note> allNotes = this.NoteService.getAllNotes("", page, order);
        model.addObject("allNotes", allNotes);
        model.addObject("count", NoteService.getCount());
        model.addObject("currentPage", page);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(
            value = {"/mynotesapp/newNote"},
            method = {RequestMethod.GET}
    )
    public ModelAndView newNote(ModelAndView model) {
        Note note = new Note();
        model.addObject("Note", note);
        model.setViewName("NoteForm");
        return model;
    }

    @RequestMapping(
            value = {"/mynotesapp/saveNote"},
            method = {RequestMethod.POST}
    )
    public ModelAndView saveNote(@ModelAttribute Note note) {
        if (note.getId() == 0) {
            this.NoteService.addNote(note);
        } else {
            this.NoteService.updateNote(note);
        }

        return new ModelAndView("redirect:/mynotesapp");
    }

    @RequestMapping(
            value = {"/mynotesapp/cancel"},
            method = {RequestMethod.POST}
    )
    public ModelAndView saveNote() {
        return new ModelAndView("redirect:/mynotesapp");
    }


    @RequestMapping(
            value = {"/mynotesapp/deleteNote"},
            method = {RequestMethod.GET}
    )
    public ModelAndView deleteNote(HttpServletRequest request) {
        int noteId = Integer.parseInt(request.getParameter("id"));
        this.NoteService.deleteNote(noteId);
        return new ModelAndView("redirect:/mynotesapp");
    }

    @RequestMapping(
            value = {"/mynotesapp/editNote"},
            method = {RequestMethod.GET}
    )
    public ModelAndView editNote(HttpServletRequest request) {
        int noteId = Integer.parseInt(request.getParameter("id"));
        Note note = this.NoteService.getNote(noteId);
        ModelAndView model = new ModelAndView("NoteForm");
        model.addObject("Note", note);
        return model;
    }

    @RequestMapping(
            value = {"/mynotesapp/paging"},
            method = {RequestMethod.GET}
    )
    public ModelAndView paging(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        page = pageNum;
        return new ModelAndView("redirect:/mynotesapp");
    }

    @RequestMapping(
            value = {"/mynotesapp/filter"},
            method = {RequestMethod.GET}
    )
    public ModelAndView filter(HttpServletRequest request) {
        String filter = request.getParameter("filter");
        filterValue = filter;
        page = 1;
        return new ModelAndView("redirect:/mynotesapp");
    }

    @RequestMapping(
            value = {"/mynotesapp/sort"},
            method = {RequestMethod.GET}
    )
    public ModelAndView sort(HttpServletRequest request) {
        String order = request.getParameter("order");
        this.order = order;
        return new ModelAndView("redirect:/mynotesapp");
    }
}