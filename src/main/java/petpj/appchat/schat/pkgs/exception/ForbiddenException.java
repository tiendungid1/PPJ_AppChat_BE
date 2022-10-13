package petpj.appchat.schat.pkgs.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpException {

  public ForbiddenException(String msg) {
    super(HttpStatus.FORBIDDEN, msg);
  }
}
