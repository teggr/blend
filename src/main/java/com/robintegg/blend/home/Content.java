package com.robintegg.blend.home;

import lombok.Value;

@Value(staticConstructor = "of")
public class Content {
    
    String type;
    Object content;

}
