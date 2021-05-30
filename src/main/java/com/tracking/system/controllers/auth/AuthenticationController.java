package com.tracking.system.controllers.auth;

import com.tracking.system.models.dtos.auth.SignInRequest;
import com.tracking.system.models.dtos.auth.AuthTokenDTO;
import com.tracking.system.controllers.BaseController;
import com.tracking.system.configs.TokenProvider;
import com.tracking.system.utils.DecodeTokenUtil;
import com.tracking.system.models.ResponseModel;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.Authentication;
import org.springframework.context.annotation.Lazy;

import javax.validation.Valid;

@RequestMapping("authentication/")
@RestController
public class AuthenticationController extends BaseController {


    @Lazy
    private final AuthenticationManager authenticationManager;
    @Lazy
    private final TokenProvider tokenProvider;

    public AuthenticationController(
            AuthenticationManager authenticationManager,
            TokenProvider tokenProvider
    ) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("signIn")
    public ResponseModel<?> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequest.username(), signInRequest.password()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String token = tokenProvider.generateToken(authentication);
            final String roleName = DecodeTokenUtil.getRoleFromToken(token);

            AuthTokenDTO authTokenDTO = new AuthTokenDTO(
                    token,
                    roleName
            );
            return new ResponseModel<>(
                    true,
                    authTokenDTO,
                    "Ok"
            );
        } catch (AuthenticationException e) {
            return createErrorResult("Username or password is incorrect.");
        }

    }

}