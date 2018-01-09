package system.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.persistence.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by krystof on 9/3/17.
 */

@NamedQueries({
        @NamedQuery(name = "UserProject.findByUserAndStartingDate",
                query = "SELECT l FROM UserProject l WHERE l.user = :userID " +
                        "AND l.from >= :startingDate"),
})

@Entity()
public class UserProject extends AbstractBusinessObject {

    private String role;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "starting_date")
    private LocalDate from;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "ending_date")
    private LocalDate end;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User user;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    private long duration;

    public UserProject() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getDuration() {
        return  Duration.between(
                getFrom().atStartOfDay(),
                getEnd().atStartOfDay()).toDays();
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public User getEmployee() {
        return user;
    }

    public void setEmployee(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private String fuj;

    public void setFuj(String fuj) {
        this.fuj = fuj;
    }

    public String getFuj() {
        return fuj;
    }
}

class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }


    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return LocalDate.parse(jp.readValueAs(String.class));
    }

}

class LocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
