package mx.com.dxesoft.sirefi2.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * sirefi2, mx.com.dxesoft.sirefi2.entities . Rol
 * Created by ernesto on 29/08/17.
 */
@Entity(name = "roles")
@Data
public class Rol implements Serializable {

    private static final long serialVersionUID = 6763466113312201905L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    @NotNull
    private String role_name;

}
