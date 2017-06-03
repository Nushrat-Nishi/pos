package com.chumbok.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 27-May-17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public void index() {
        User user = new User();
        user.setId(12345678910L);
        user.setFirstName("Nushrat");
        user.setLastName("Nishi");
        user.setEmail("nishi.ict@gmail.com");

        Date date = null;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = fmt.parse("2013-05-06");
            user.setDateOfBirth(date);
        } catch (ParseException e) {              // Insert this block.
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setDateOfBirth(date);
        user.setEnable(true);

        userRepository.save(user);
    }

    @RequestMapping("/user")
    public List<User> showData() {
        return userRepository.findAll();
    }
}
