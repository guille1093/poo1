package com.fuerza.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor

public class Cliente {
	// Atributos
	@Id
	@Column(name = "dni_cli", length = 10, nullable = false, unique = true)
	private String dni;
	@Column(name = "nombre_cli", length = 30, nullable = false, unique = false)
	private String nombre;
	@Column(name = "apellido_cli", length = 30, nullable = false, unique = false)
	private String apellido;
	@Column(name = "sexo_cli", length = 10, nullable = false, unique = false)
	private String sexo;
	@Column(name = "fecha_nacimiento_cli", nullable = false, unique = false)
	private LocalDate fechaNacimiento;
	@Column(name = "fecha_ingreso_cli", nullable = false, unique = false)
	private LocalDate fechaIngreso;
	@Column(name = "peso_cli", length = 8, nullable = false, unique = false)
	private double peso;
	@Column(name = "estatura_cli", length = 8, nullable = false, unique = false)
	private double estatura;
}

