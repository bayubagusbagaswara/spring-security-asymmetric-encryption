package com.asymmetric.controller;

import com.asymmetric.dto.ApiResponse;
import com.asymmetric.dto.user.ChangePasswordRequest;
import com.asymmetric.dto.user.ProfileUpdateRequest;
import com.asymmetric.entity.User;
import com.asymmetric.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PutMapping("/me")
    public ResponseEntity<ApiResponse<Void>> updateProfile(
            @RequestBody @Valid final ProfileUpdateRequest request,
            final Authentication principal) {

        this.service.updateProfileInfo(request, getUserId(principal));

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Profile updated successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/me/password")
    public ResponseEntity<ApiResponse<Void>> changePassword(
            @RequestBody @Valid final ChangePasswordRequest request,
            final Authentication principal) {

        this.service.changePassword(request, getUserId(principal));

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Password changed successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/me/deactivate")
    public ResponseEntity<ApiResponse<Void>> deactivateAccount(final Authentication principal) {
        this.service.deactivateAccount(getUserId(principal));

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Account deactivated successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/me/reactivate")
    public ResponseEntity<ApiResponse<Void>> reactivateAccount(final Authentication principal) {
        this.service.reactivateAccount(getUserId(principal));

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Account reactivated successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/me")
    public ResponseEntity<ApiResponse<Void>> deleteAccount(final Authentication principal) {
        this.service.deleteAccount(getUserId(principal));

        final ApiResponse<Void> response = ApiResponse.<Void>builder()
                .httpStatus(HttpStatus.OK.value())
                .code("OK")
                .message("Account deleted successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    private String getUserId(final Authentication authentication) {
        return ((User) authentication.getPrincipal()).getId();
    }

}
