import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val idTarea: Int, val descripcion: String, var estado: EstadosTarea = EstadosTarea.PENDIENTE) {

    var fechaRealizacion: LocalDateTime? = null

    companion object {
        private var contador = 0
        fun generarId(): Int {
            return ++contador
        }
    }

    constructor(descripcion: String, estado: EstadosTarea = EstadosTarea.PENDIENTE) : this(generarId(), descripcion, estado)

    fun cambiarEstado(nuevoEstado: EstadosTarea): Boolean {
            if (this.estado != nuevoEstado) {
                this.estado = nuevoEstado

                if (nuevoEstado == EstadosTarea.REALIZADA) {
                    this.fechaRealizacion = LocalDateTime.now()
                } else if (nuevoEstado == EstadosTarea.PENDIENTE) {
                    this.fechaRealizacion = null
                }
            }
            return true
    }

    fun obtenerFechaFormateada(): String? {
        return fechaRealizacion?.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
    }

}