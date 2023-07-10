import com.example.demo.domain.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado modificarEmpleado(@PathVariable String id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return empleadoService.updateEmpleado(empleado);
    }
}
