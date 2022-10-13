package petpj.appchat.schat.pkgs.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ValidHttpResponse {
  public static <T> ResponseEntity<T> toOkResponse(T data) {
    return ResponseEntity.status(HttpStatus.OK).body(data);
  }

  public static ResponseEntity<Void> toNoContentResponse() {
    return ResponseEntity.noContent().build();
  }

  public static <T> ResponseEntity<T> toCreatedResponse(T data) {
    return ResponseEntity.status(HttpStatus.CREATED).body(data);
  }
}
