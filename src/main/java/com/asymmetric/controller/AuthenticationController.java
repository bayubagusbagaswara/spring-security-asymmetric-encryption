package com.asymmetric.controller;

import com.asymmetric.dto.ApiResponse;
import com.asymmetric.dto.auth.AuthenticationRequest;
import com.asymmetric.dto.auth.AuthenticationResponse;
import com.asymmetric.dto.auth.RefreshRequest;
import com.asymmetric.dto.auth.RegistrationRequest;
import com.asymmetric.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> login(
            @Valid @RequestBody final AuthenticationRequest request) {

        final AuthenticationResponse authResponse = this.service.login(request);

        final ApiResponse<AuthenticationResponse> response = ApiResponse.<AuthenticationResponse>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Login successful")
                .data(authResponse)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(
            @Valid @RequestBody final RegistrationRequest request) {

        this.service.register(request);

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.CREATED.value())
                .code("CREATED")
                .message("User registered successfully")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> refresh(
            @RequestBody final RefreshRequest req) {

        final AuthenticationResponse authResponse = this.service.refreshToken(req);

        final ApiResponse<AuthenticationResponse> response = ApiResponse.<AuthenticationResponse>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Access token refreshed successfully")
                .data(authResponse)
                .build();

        return ResponseEntity.ok(response);
    }

}