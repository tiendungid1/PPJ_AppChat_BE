package petpj.appchat.schat.core.modules.message.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;
import petpj.appchat.schat.core.modules.conversation.entities.Conversation;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

  @Id
  @SequenceGenerator(
      name = "message_sequence",
      sequenceName = "message_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
  private Long id;

  @Lob private String content;

  private String fromUser;

  private Boolean isPinned;

  @ManyToOne
  @JoinColumn(name = "origin_message_id")
  @JsonIgnore
  @NotFound(action = NotFoundAction.IGNORE)
  private Message originMessage;

  @JsonInclude(Include.NON_EMPTY)
  @OneToMany(mappedBy = "originMessage", fetch = FetchType.EAGER)
  private Set<Message> childMessages;

  @Embedded private List<Reaction> reactions;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "conversation_id")
  private Conversation conversation;

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Message message = (Message) o;
    return id != null && Objects.equals(id, message.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
