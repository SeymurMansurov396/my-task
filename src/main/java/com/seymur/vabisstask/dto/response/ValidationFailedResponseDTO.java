package com.seymur.vabisstask.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ValidationFailedResponseDTO {
    private String title;
    private List<ViolationDetailDTO> violations;
}
