package petpj.appchat.schat.pkgs.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends HttpException {

  public UnauthorizedException(String msg) {
    super(HttpStatus.UNAUTHORIZED, msg);
  }
}
