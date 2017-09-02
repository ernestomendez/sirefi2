package mx.com.dxesoft.sirefi2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * sirefi2, mx.com.dxesoft.sirefi2.entities . User
 * Created by ernesto on 28/08/17.
 */
@Entity
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 70736341533054538L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //esta es la estrategia de default no es necesario ponerla.
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull
    /*
     * La diferencia entre nullable=false y @NotNull es que el nullable esta ligado a la base de datos es decir es un constraint de la base de datos
     * cuando hibernate crea esa tabla la crea con el constraint not null.
     * En cambio @NotNull es parte de la especificacion JSR 303 Bean Validation {http://download.oracle.com/otndocs/jcp/bean_validation-1.0-fr-oth-JSpec/}
     * la cual verifica que el atributo no permita valores nulos, es decir en la creacion del objeto siempre debe tener un valor.
     *
     * Algunos JPA Providers como hibernate convierten el @NotNull en nullable = true, pero no todos. Para este caso en especifico, al no estar construyendo
     * la base de datos con hibernate, no es necesario poner los dos.
     *
     * TODO ESTE EMAIL ESTA FUNGIENDO COMO USER NAME, CAMBIAR EL NOMBRE A USERNAME
     */
    private String email;

    @Column
    @NotNull
    @JsonIgnore
    private String password;   //TODO Convertir esto a char

    @Column
    @NotNull
    private String name;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column
    private boolean enabled;

    @Column(name = "disabled_date")
    private LocalDate disabledDate;

    /*
    Al cambiar el foreing key en la tabla, olvidé cambiar el JoinColumn.
     */
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id", referencedColumnName = "id")}
    )
    private Set<Rol> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isEnabled() == user.isEnabled() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getApellidoPaterno(), user.getApellidoPaterno()) &&
                Objects.equals(getApellidoMaterno(), user.getApellidoMaterno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getName(), getApellidoPaterno(), getApellidoMaterno(), isEnabled());
    }
}
