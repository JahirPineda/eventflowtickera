package cl.duoc.msvc_tickets.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TicketsGeneradosDTO {
    private int id;
    private String codigoQR;
    private LocalDateTime fechaEmision;
    private boolean usado;

    @NotBlank(message = "El tipo de entrada es obligatorio")
    private String tipoEntrada;

    @Positive(message = "El ID de orden debe ser válido")
    private int ordenId;

    @Positive(message = "El ID de cliente debe ser válido")
    private int clienteId;

    @Positive(message = "El ID de evento debe ser válido")
    private int eventoId;
}