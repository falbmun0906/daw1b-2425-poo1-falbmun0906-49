fun pedirEstado(): EstadosTarea {
    while (true) {
        print("Ingrese el estado de la tarea (PENDIENTE/REALIZADA): ")
        val estado: String = readln().uppercase()
        try {
            return EstadosTarea.valueOf(estado)
        } catch(e: IllegalArgumentException) {
            println("ERROR: Introduce un estado válido.")
        }
    }
}

fun pedirId(): Int {
    while (true) {
        print("Ingrese el ID de la tarea (número entero): ")
        val id: Int? = readln().toIntOrNull()
        if (id != null) {
            return id
        } else println("ERROR: Ingrese un ID válido.")
    }
}

fun pedirTarea(): Tarea {

    while (true) {
        print("¿Quieres ingresar un ID manualmente? (S/N):")
        when (readln().uppercase()) {
            "S" -> {
                val id = pedirId()
                print("Ingrese la descripción de la tarea: ")
                val desc: String = readln()
                return Tarea(id, desc)
            }

            "N" -> {
                print("Ingrese la descripción de la tarea: ")
                val desc: String = readln()
                return Tarea(desc)
            }

            else -> {
                println("ERROR: Opción inválida.")
            }
        }
    }
}


fun mostrarMenu() {
    print(""" 
        
        GESTOR DE TAREAS
        
        1. Agregar una nueva tarea.
        2. Eliminar una tarea.
        3. Cambiar el estado de una tarea.
        4. Mostrar todas las tareas.
        5. Mostrar tareas pendientes.
        6. Mostrar tareas realizadas.
        7. Salir.
        
        >> 
    """.trimIndent())
}

fun main() {

    val tareas: GestorTareas = GestorTareas()

    var opcion: Int? = null
    while(opcion != 7) {
        mostrarMenu()
        opcion = readln().toIntOrNull()
        when(opcion) {
            1 -> tareas.agregarTarea(pedirTarea())
            2 -> tareas.eliminarTarea(tareas.listaTareas.find { it.idTarea == pedirId() })
            3 -> {
                val tareaEncontrada = tareas.listaTareas.find { it.idTarea == pedirId() }

                if (tareaEncontrada != null) {
                    tareaEncontrada.cambiarEstado(pedirEstado())
                } else print("ERROR: Tarea no encontrada.")
            }
            4 -> tareas.mostrarTareas()
            5 -> tareas.mostrarTareasPendientes()
            6 -> tareas.mostrarTareasRealizadas()
            7 -> break
            else -> print("ERROR: Introduce una opción válida.\n")
        }
    }
}