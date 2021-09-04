package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;


import com.example.demo.model.CalypsoUploadDocument;


@Controller
@RequestMapping("/api") 
public class JSONToXMLMappingController {

    @PostMapping(path = "/mapJsontoXML", consumes ="application/json", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody CalypsoUploadDocument mapJsonToXML(@RequestBody final CalypsoUploadDocument request) {
       
    	try {
    	return request;
    	    }
    	catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    	}
    }
    
    
    
    
}
