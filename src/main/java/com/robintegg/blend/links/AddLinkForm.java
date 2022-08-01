package com.robintegg.blend.links;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddLinkForm {

    @NotEmpty
    @Size(max = 2048)
    private String url;

    @NotEmpty
    @Size(max = 2048)
    private String title;

}
