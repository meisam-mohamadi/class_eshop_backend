package com.api.eshop.domain.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileUploadResponse {
    private String fileName;
    private String contentTYpe;
    private String url;
    private String dateDirectory;

}
