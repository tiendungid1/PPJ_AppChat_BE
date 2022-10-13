package petpj.appchat.schat.pkgs.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends HttpException {

  public ConflictException(String msg) {
    super(HttpStatus.CONFLICT, msg);
  }
}
