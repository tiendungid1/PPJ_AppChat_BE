package petpj.appchat.schat.core.modules.message.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
  @AttributeOverride(name = "type", column = @Column(name = "reaction_type")),
  @AttributeOverride(name = "userName", column = @Column(name = "reaction_of_user"))
})
public class Reaction {
  private String type;
  private String of;
}
