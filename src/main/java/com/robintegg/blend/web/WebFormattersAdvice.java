package com.robintegg.blend.web;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class WebFormattersAdvice {
    
    PrettyTime pt  = new PrettyTime();
    UrlFormatter uf = new UrlFormatter();

    @ModelAttribute("prettyTime")
    public PrettyTime prettyTime() {
        return pt;
    }

    @ModelAttribute("via")
    public UrlFormatter via() {
        return uf;
    } 

}
