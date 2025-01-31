class GestorTareas(val listaTareas: MutableList<Tarea> = mutableListOf()) {

    fun agregarTarea(nuevaTarea: Tarea): Boolean {
        val tareaEsNueva = listaTareas.all { it.idTarea != nuevaTarea.idTarea }

        if (tareaEsNueva) {
            listaTareas.add(nuevaTarea)
            return true
        } else {
            println("ERROR: Ya existe una tarea con ese ID. Abortando...\n")
            return false
        }
    }

    fun eliminarTarea(tarea: Tarea?): Boolean {
        if (tarea in listaTareas) {
            listaTareas.remove(tarea)
            return true
        } else return false
    }

    fun mostrarTareas() {
        println("LISTA TAREAS:\n")
        for (tarea in listaTareas) {
            print("\tID: ${tarea.idTarea}\n\tDESCRIPCIÓN: ${tarea.descripcion}\n\tESTADO: ${tarea.estado}\n\t${if (tarea.fechaRealizacion != null) { "FECHA REALIZACIÓN: ${tarea.obtenerFechaFormateada()}" } else ""}\n\n")
        }
    }

    fun mostrarTareasRealizadas() {
        println("LISTA TAREAS REALIZADAS:\n")
        for (tarea in listaTareas) {
            if (tarea.estado == EstadosTarea.REALIZADA) {
                print("\tID: ${tarea.idTarea}\n\tDESCRIPCIÓN: ${tarea.descripcion}\n\tESTADO: ${tarea.estado}\n\tFECHA REALIZACIÓN: ${if (tarea.fechaRealizacion != null) { "${tarea.obtenerFechaFormateada()}" } else ""}\n\n")
            }
        }
    }

    fun mostrarTareasPendientes() {
        println("LISTA TAREAS PENDIENTES:\n")
        for (tarea in listaTareas) {
            if (tarea.estado == EstadosTarea.PENDIENTE) {
                print("\tID: ${tarea.idTarea}\n\tDESCRIPCIÓN: ${tarea.descripcion}\n\tESTADO: ${tarea.estado}\n\n")
            }
        }
    }

}