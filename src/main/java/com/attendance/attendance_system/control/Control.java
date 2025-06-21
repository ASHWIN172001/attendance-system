package com.attendance.attendance_system.control;

import com.attendance.attendance_system.entity.User;
import com.attendance.attendance_system.serv.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/details")
public class Control {

    @Autowired
    public Serv serv;

    // create a new record without ID because it is auto generated
    @PostMapping("/create")
    public User createNewRec (@RequestBody User user){
        return serv.createNewRecord(user);
    }

    // reading all the records
    @GetMapping("/get")
    public List<User> getAll(){
        return serv.readAll();
    }

    // reading required records by ID
    @GetMapping("/get/{ID}")
    public User getByID(@PathVariable Integer ID){
        return serv.readUsingID(ID);
    }

    //Only updating
    @PutMapping("/update/{ID}")
    public void updateOnly  (@PathVariable Integer ID, @RequestBody User user){
        serv.onlyUpdate(ID,user);
    }

    //updating and returning all
    @PutMapping("/update/returnAll/{ID}")
    public List<User> updateAndReturnAll (@PathVariable Integer ID, @RequestBody User user){
        return serv.updateAndReturnAll(ID,user);
    }

    //updating using ID and return the Updated one
    @PutMapping("/update/returnThis/{ID}")
    public User updateAndReturnThis(@PathVariable Integer ID, @RequestBody User user){
        return serv.updateAndReturnUpdated(ID,user);
    }

    // delete using ID
    @DeleteMapping("/!!DELETE!!/{ID}")
    public String deleteByID (@PathVariable Integer ID){
        return serv.deleteByID(ID);
    }

}
