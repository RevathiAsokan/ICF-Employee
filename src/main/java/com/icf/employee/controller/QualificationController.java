package com.icf.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.icf.employee.dto.QualificationDto;
import com.icf.employee.service.QualificationService;
import com.icf.employee.service.impl.QualificationServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/employee")
public class QualificationController {

	@Autowired
	QualificationService qualificationService;

	@Autowired
	QualificationServiceImpl qualificationDetailService;

	@ApiOperation(value = "save Qualification", notes = "This api is used to save the Qualification", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@PostMapping("/qualification")
	public QualificationDto saveQualificationDto(@RequestBody QualificationDto qualificationDto, Device device) {
		QualificationDto userResDto = qualificationService.createQualification(qualificationDto);
		return userResDto;

	}

	@ApiOperation(value = "get all Qualifications", notes = "This api is used to get all the Qualifications", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/qualifications")
	public List<QualificationDto> getAllQualifications() {
		return qualificationService.getAllQualifications();

	}

	@ApiOperation(value = "get Qualification by Id", notes = "This api is used to get the Qualification by Id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@GetMapping("/qualification/{id}")
	public QualificationDto getQualificationById(@PathVariable Long id) {

		return qualificationService.getQualificationById(id);
	}

	@ApiOperation(value = "delete Qualification by Id", notes = "This api is used to delete the Qualification by Id", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "UnAuthorized"),
			@ApiResponse(code = 404, message = "NOT_FOUND") })

	@DeleteMapping("/qualification/{id}")
	public void deleteQualificationById(@PathVariable Long id) {
		qualificationService.deleteQualificationById(id);
	}
}
