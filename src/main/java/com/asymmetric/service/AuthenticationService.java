package com.asymmetric.service;

import com.asymmetric.dto.auth.AuthenticationRequest;
import com.asymmetric.dto.auth.AuthenticationResponse;
import com.asymmetric.dto.auth.RefreshRequest;
import com.asymmetric.dto.auth.RegistrationRequest;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);

    void register(RegistrationRequest request);

    AuthenticationResponse refreshToken(RefreshRequest req);
}
