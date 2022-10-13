package petpj.appchat.schat.pkgs.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class HttpException {
  private HttpStatus status;
  private String msg;

  public HttpException(HttpStatus status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public ResponseEntity<HttpException> toResponse() {
    return ResponseEntity.status(status).body(this);
  }
}
