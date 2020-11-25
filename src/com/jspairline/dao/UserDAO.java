package com.jspairline.dao;

import com.jspairline.entity.User;
import com.jspairline.entity.UserData;

public interface UserDAO {
    User authentification (String login, String password);

    boolean registration (UserData userData);
}
