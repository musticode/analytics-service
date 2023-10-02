package com.example.analyticsservice.converter;


import com.example.analyticsservice.dto.application.ApplicationDTO;
import com.example.analyticsservice.model.Application;

public class ApplicationConverter extends Converter<ApplicationDTO, Application>{

    public ApplicationConverter(){
        super(ApplicationConverter::convertApplicationToEntity, ApplicationConverter::convertApplicationToDTO);

    }

    public static ApplicationDTO convertApplicationToDTO(Application application) {
        return ApplicationDTO.builder()
                .id(application.getId())
                .appCode(application.getAppCode())
                .name(application.getName())
                .build();
    }

    public static Application convertApplicationToEntity(ApplicationDTO applicationDTO) {
        return Application.builder()
                .name(applicationDTO.getName())
                .appCode(applicationDTO.getAppCode())
                .build();
    }
}
