package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accounts.AccountService;
import accounts.Profile;

public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    // sign up
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        Profile profile = accountService.getUserByLogin(login);
        System.out.println("check " + request.getSession().getId());
        if (profile != null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("User " + login + " already registered");
        } else {
            if (login != "") {
                accountService.addNewUser(new Profile(login, pass));
                System.out.println("put " + request.getSession().getId());
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().print("New user " + login + " is added");
            } else {
                response.getWriter().print("Login is empty");
            }
        }
    }
}
