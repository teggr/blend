package com.robintegg.blend.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SiteAdvice {
    
    @ModelAttribute("siteName")
    public String getSiteName() {
        return "robintegg.com";
    }


}
