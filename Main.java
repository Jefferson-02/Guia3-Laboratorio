import java.util.ArrayList;
import java.util.List;

class Proyecto {
    private String codigo;
    private String nombre;

    public Proyecto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}

class Contrato {
    private String codigoContrato;
    private String fechaInicio;

    public Contrato(String codigoContrato, String fechaInicio) {
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
    }

    public String getCodigoContrato() { return codigoContrato; }
    public String getFechaInicio() { return fechaInicio; }
}

abstract class Empleado {
    private String id;
    private String nombre;
    private double salarioBase;
    private Contrato contrato;
    private Proyecto proyectoAsignado;
    private Empleado supervisor;

    public Empleado(String id, String nombre, double salarioBase, String codContrato, String fechaContrato) {
        this.id = id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.contrato = new Contrato(codContrato, fechaContrato);
    }

    public abstract double calcularSalarioNeto();

    public void asignarSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }

    public void asignarProyecto(Proyecto proyecto) {
        this.proyectoAsignado = proyecto;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }
    public Contrato getContrato() { return contrato; }
    public Empleado getSupervisor() { return supervisor; }
    public Proyecto getProyectoAsignado() { return proyectoAsignado; }

    public void mostrarResumen() {
        System.out.println("ID: " + id + " | Nombre: " + nombre);
        System.out.println("  - Contrato: " + contrato.getCodigoContrato() + " (Inicio: " + contrato.getFechaInicio() + ")");
        System.out.println("  - Salario Neto: S/ " + calcularSalarioNeto());
        System.out.println("  - Supervisor: " + (supervisor != null ? supervisor.getNombre() : "Sin supervisor directo"));
        System.out.println("  - Proyecto: " + (proyectoAsignado != null ? proyectoAsignado.getNombre() : "No asignado"));
    }
}

class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String id, String nombre, double salarioBase, String codContrato, String fecha, String lenguajePrincipal) {
        super(id, nombre, salarioBase, codContrato, fecha);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public double calcularSalarioNeto() {
        return getSalarioBase() * 1.10;
    }

    public String getLenguajePrincipal() { return lenguajePrincipal; }
}

class Gerente extends Empleado {
    private double bonoGestion;

    public Gerente(String id, String nombre, double salarioBase, String codContrato, String fecha, double bonoGestion) {
        super(id, nombre, salarioBase, codContrato, fecha);
        this.bonoGestion = bonoGestion;
    }

    @Override
    public double calcularSalarioNeto() {
        return getSalarioBase() + bonoGestion;
    }

    public double getBonoGestion() { return bonoGestion; }
}

class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado emp) {
        this.empleados.add(emp);
    }

    public void listarEquipo() {
        System.out.println("\n--- MIEMBROS DEL DEPARTAMENTO: " + nombre.toUpperCase() + " ---");
        for (Empleado e : empleados) {
            e.mostrarResumen();
            System.out.println("--------------------------------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE PERSONAL\n");

        Proyecto proy1 = new Proyecto("PRY-01", "Migración Cloud AWS");
        Proyecto proy2 = new Proyecto("PRY-02", "App Móvil Clientes");

        Gerente g1 = new Gerente("EMP-001", "Carlos Mendoza", 6000.0, "CT-101", "01/01/2025", 1500.0);
        Desarrollador d1 = new Desarrollador("EMP-002", "Ana Torres", 3500.0, "CT-102", "15/02/2025", "Java");
        Desarrollador d2 = new Desarrollador("EMP-003", "Luis Rojas", 3200.0, "CT-103", "01/03/2025", "Python");

        d1.asignarSupervisor(g1);
        d2.asignarSupervisor(g1);

        d1.asignarProyecto(proy1);
        d2.asignarProyecto(proy2);
        g1.asignarProyecto(proy1);

        Departamento dptoSistemas = new Departamento("Tecnología e Información");
        dptoSistemas.agregarEmpleado(g1);
        dptoSistemas.agregarEmpleado(d1);
        dptoSistemas.agregarEmpleado(d2);

        dptoSistemas.listarEquipo();
    }
}