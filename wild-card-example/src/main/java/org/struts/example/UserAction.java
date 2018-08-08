package org.struts.example;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    HttpServletRequest request;
    HttpServletResponse response;


    public String ListUser()
            throws Exception {

        request.setAttribute("display", "List all users");

        return "success";
    }

    public String AddUser() throws Exception {

        request.setAttribute("display", "Add user");

        return "success";
    }

    public String EditUser()
            throws Exception {

        request.setAttribute("display", "Edit user");

        return "success";
    }

    public String DeleteUser() throws Exception {

        request.setAttribute("display", "Delete user");

        return "success";
    }

    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;

    }

    @Override
    public void setServletResponse(javax.servlet.http.HttpServletResponse response) {
        this.response = response;
    }
}
