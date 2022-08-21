package com.disquera.controllers.controllers;

import com.disquera.controllers.models.ArtistModelDAO;
import com.disquera.controllers.models.ArtistModelVO;
import com.disquera.controllers.models.MusicVO;
import com.disquera.controllers.models.UserModelVO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArtistController", value = "/Artist")
public class ArtistController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String view = request.getParameter("view");
        HttpSession session = request.getSession();
        UserModelVO userModelVO = (UserModelVO) session.getAttribute("userData");

        switch (view){
            case "music":
                ArtistModelVO artistModelVO = new ArtistModelVO(userModelVO.getUser(), userModelVO.getPassword(), userModelVO.getId());
                ArtistModelDAO artistModelDAO = new ArtistModelDAO(artistModelVO);
                ArrayList<MusicVO> listMusic =  artistModelDAO.consultMusic();

                request.setAttribute("listMusic", listMusic);
                request.getRequestDispatcher("Artista/music.jsp").forward(request, response);
                break;
            case "album":
                break;
            case "profile":
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
