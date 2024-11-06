package org.example.module_three.controller;

import org.example.module_three.model.Room;
import org.example.module_three.service.RoomService;
import org.example.module_three.service.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/rooms")
public class RoomController extends HttpServlet {

    private final RoomService roomService = new RoomServiceImpl();

    public RoomController() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                list(request, response);
                break;
            case "create":
                showCreateRoomForm(request, response);
                break;
            case "delete":
                deleteRoom(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> rooms = roomService.getAllRooms();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/WEB-INF/views/rooms.jsp").forward(request, response);
    }

    private void showCreateRoomForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/create-room.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action != null) {
                switch (action) {
                    case "create":
                        createRoom(request, response);
                        break;
                    case "delete":
                        deleteRoom(request, response);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Dữ liệu không hợp lệ.");
            request.getRequestDispatcher("/WEB-INF/views/create-room.jsp").forward(request, response);
        }
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int roomId = Integer.parseInt(request.getParameter("idRoom"));
            boolean isDeleted = roomService.deleteRoom(roomId);
            if (isDeleted) {
                response.sendRedirect(request.getContextPath() + "/rooms");
            } else {
                request.setAttribute("error", "Không thể xóa xin thử lại.");
                request.getRequestDispatcher("/WEB-INF/views/rooms.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "ID phòng không hợp lệ.");
            request.getRequestDispatcher("/WEB-INF/views/rooms.jsp").forward(request, response);
        }
    }

    private void createRoom(HttpServletRequest request, HttpServletResponse response) {
    }
}
