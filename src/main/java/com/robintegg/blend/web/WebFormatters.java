package com.robintegg.blend.web;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class WebFormatters {
    
    PrettyTime pt  = new PrettyTime();

    @ModelAttribute("prettyTime")
    public PrettyTime prettyTime() {
        return pt;
    }

}
