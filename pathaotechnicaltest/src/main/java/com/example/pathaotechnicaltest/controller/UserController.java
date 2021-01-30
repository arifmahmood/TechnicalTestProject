package com.example.pathaotechnicaltest.controller;

import com.example.pathaotechnicaltest.request.CreateUserRequest;
import com.example.pathaotechnicaltest.request.TagMappingRequest;
import com.example.pathaotechnicaltest.response.BaseResponse;
import com.example.pathaotechnicaltest.service.TagService;
import com.example.pathaotechnicaltest.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController extends BaseController {

    private final UserService userService;
    private final TagService tagService;


    public UserController(UserService userService, TagService tagService) {
        this.userService = userService;
        this.tagService = tagService;
    }


    @PostMapping("/users")
    public ResponseEntity<BaseResponse> createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {

        validate(createUserRequest);
        BaseResponse baseResponse = userService.createUser(createUserRequest);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

    @RequestMapping(value="users/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<BaseResponse> getUserById(@PathVariable String id) throws Exception {

        BaseResponse baseResponse = userService.getUserById(id);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }
    @RequestMapping(value="users/{id}/tags", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<BaseResponse> mapTagWithUser(@RequestBody TagMappingRequest tagMappingRequest, @PathVariable String id) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        BaseResponse baseResponse = tagService.mapTagWithUser(tagMappingRequest, id);
        return  new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="users", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<BaseResponse> mapTagWithUser(@RequestParam(name = "tags") ArrayList<String> tags) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        BaseResponse baseResponse = tagService.getUsersOfTag(tags);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

}
