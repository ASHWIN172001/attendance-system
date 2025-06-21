package com.attendance.attendance_system.serv;

import com.attendance.attendance_system.entity.User;
import com.attendance.attendance_system.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serv {

    @Autowired
    public Repo repo;

    //Create new record
    public User createNewRecord(User user){
        repo.save(user);
        return repo.findById(user.getId()).orElse(null);
    }

    //to Read all Record
    public List<User> readAll(){
        return repo.findAll();
    }

    //To read using particular ID
    public User readUsingID(Integer ID){
        return repo.findById(ID).orElse(null);
    }


    //only update
    public void onlyUpdate(Integer id,User user){
        User existingRecord = repo.findById(id).orElse(null);
        if(existingRecord != null){
            existingRecord.setName(user.getName());
            existingRecord.setEmail(user.getEmail());
            existingRecord.setPassword(user.getPassword());
            existingRecord.setRole(user.getRole());
            existingRecord.setActive(user.isActive());
        }
        repo.save(existingRecord);
    }

    // update and return all
    public List<User> updateAndReturnAll (Integer ID,User user){
        User existingRecord = repo.findById(ID).orElse(null);
        if(existingRecord != null){
            existingRecord.setName(user.getName());
            existingRecord.setEmail(user.getEmail());
            existingRecord.setPassword(user.getPassword());
            existingRecord.setRole(user.getRole());
            existingRecord.setActive(user.isActive());
        }
        repo.save(existingRecord);
        return repo.findAll();
    }

    // update and return the updated one
    public User updateAndReturnUpdated (Integer ID,User user){
        User existingRecord = repo.findById(ID).orElse(null);
        if(existingRecord != null){
            existingRecord.setName(user.getName());
            existingRecord.setEmail(user.getEmail());
            existingRecord.setPassword(user.getPassword());
            existingRecord.setRole(user.getRole());
            existingRecord.setActive(user.isActive());
        }
        repo.save(existingRecord);
        return repo.findById(ID).orElse(null);
    }

    // Delete by ID only using because introducing delete all method is not advisable
    public String deleteByID (Integer ID){
        repo.deleteById(ID);
        return "Deleted SuccessFully";
    }
}
