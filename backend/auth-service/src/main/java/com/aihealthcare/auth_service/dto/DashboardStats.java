package com.aihealthcare.auth_service.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardStats {

    private Long patients;
    private Long doctors;
    private Long appointments;
    private Long prescriptions;

    // getters/setters
}