package com.test.excersise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.excersise.domain.User;
import com.test.excersise.model.Role;
import com.test.excersise.model.Task;
import com.test.excersise.repository.TaskDataRepository;
import com.test.excersise.repository.UserDataRepository;

@RestController
@RequestMapping("/secure")
public class UserController {
	@Autowired
	UserDataRepository userRepository;

	@Autowired
	TaskDataRepository taskRepository;

	@RequestMapping("/addTask")
	public ResponseEntity<Object> addTask(@RequestBody Task task) throws Exception {
		if (task != null) {
			if (null == task.getRole()) {
				return new ResponseEntity<>("Role is Required to addTask",HttpStatus.BAD_REQUEST);
			} else if (task.getRole().name() == Role.Developer.name()) {
				return new ResponseEntity<>("Developer cannot addTask , Only Tester can addTask",HttpStatus.BAD_REQUEST);
			}
			if (task.getAssignedUser() == 2 || task.getCreatedBy() == 2) {
				return new ResponseEntity<>("Cannot assign Task to Developer while adding tasks ,assign user should be 1",HttpStatus.BAD_REQUEST);
			}
			String resp = getUserRoles(task);
			if (null == resp) {
				Task added = taskRepository.save(task);
				return new ResponseEntity<>(added,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
			}
		}
		return null;
	}

	private String getUserRoles(Task task) {
		User user = userRepository.findById(task.getUserName(), task.getRole().name());

		if (null == user ||(user.getRole().isEmpty() || user.getUsername().isEmpty())) {
			return "User - Role Mapping Not Found , This user is not " + task.getRole();
		}

		return null;

	}

	@RequestMapping("/getTask")
	public List<Task> getTask(@RequestParam Role role) {
		if (role == Role.Developer)
			return taskRepository.findById();
		else
			return taskRepository.findAll();

	}

	@RequestMapping("/updateTask")
	public ResponseEntity<String> updateStatus(@RequestBody Task task) {
		// user id 1 -> Tester
		//user id 2 -> Developer
		if (task != null) {
			if (null == task.getRole()) {
				return new ResponseEntity<>("Role is Required to update Task",HttpStatus.BAD_REQUEST);
			} else if (task.getRole().name() == Role.Developer.name()) {
				taskRepository.taskStatus(task.isCompleted(), task.getId(),task.getUserName());
			}else if(task.getRole().name() == Role.Tester.name()) {
				taskRepository.taskAssignment( task.getId(),task.getUserName());
			}
		}
		return new ResponseEntity<>("Task Updated Successfully",HttpStatus.OK);
	}

	@RequestMapping("/deleteTask")
	public ResponseEntity<String> deleteTask(@RequestParam(required = false) int id ,@RequestBody Task task) throws Exception {
		if (task != null) {
			if (null == task.getRole()) {
				return new ResponseEntity<>("Role is Required to delete Task",HttpStatus.BAD_REQUEST);
			} else if (task.getRole().name() == Role.Developer.name()) {
				return new ResponseEntity<>("Developer cannot deleteTask , Only Tester can deleteTask",HttpStatus.BAD_REQUEST);
			}
			
			String resp = getUserRoles(task);
			if (null == resp) {
				taskRepository.delete((long) id);
				return new ResponseEntity<>("Sucessfully Removed ",HttpStatus.OK);
			} else {
				return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
			}
		
	}
		return null;
	}

}
