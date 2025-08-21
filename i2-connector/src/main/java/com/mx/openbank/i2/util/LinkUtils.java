package com.mx.openbank.i2.util;

import java.util.*;
import java.util.function.Function;

public class LinkUtils {

    // Construye un solo link
    public static Map<String, Object> buildLink(
            String linkTypeId,            // p.ej. "TENL1"
            String fromEndId,             // id entidad origen
            String toEndId,               // id entidad destino
            String typeIdEntidadOrigen,   // p.ej. "TENT1"
            String typeIdEntidadDestino,  // p.ej. "TENT6"
            String seed,                  // semilla usada para generar id único
            Map<String, Object> props,    // propiedades del link (puede ser vacío)
            String tipoEnlace             // etiqueta/uso interno, opcional
    ) {
        Map<String, Object> link = new LinkedHashMap<>();
        link.put("typeId", linkTypeId);
        link.put("id", defineIdEnlace(seed, toEndId, typeIdEntidadOrigen, typeIdEntidadDestino));
        link.put("version", 1);
        link.put("fromEndId", fromEndId);
        link.put("toEndId", toEndId);
        link.put("linkDirection", defineSentidoEnlace(typeIdEntidadOrigen, typeIdEntidadDestino));
        link.put("properties", revisarPropiedadesEnlace(props, typeIdEntidadOrigen, typeIdEntidadDestino));
        return link;
    }

    // Construye múltiples links a partir de resultados, soportando varios typeIds (como en tu Python)
    public static List<Map<String, Object>> buildLinks(
            List<Map<String, Object>> resultados,     // cada resultado debe tener al menos el "id" destino
            String fromEndId,
            List<String> linkTypeIds,                 // si sólo hay 1, pasa Collections.singletonList("TENL1")
            String typeIdEntidadOrigen,
            String seed,
            String typeIdEntidadDestino,
            Function<Map<String, Object>, Map<String, Object>> propsMapper // mapea props por resultado
    ) {
        List<Map<String, Object>> links = new ArrayList<>();
        int contador = 0;

        for (String linkTypeId : linkTypeIds) {
            for (Map<String, Object> r : resultados) {
                String toEndId = String.valueOf(r.getOrDefault("id", ""));
                if (toEndId.isEmpty()) continue;

                Map<String, Object> props = propsMapper != null ? propsMapper.apply(r) : Collections.emptyMap();

                Map<String, Object> link = new LinkedHashMap<>();
                link.put("typeId", linkTypeId);
                link.put("id", defineIdEnlace(seed, toEndId, typeIdEntidadOrigen, typeIdEntidadDestino) + "-" + (++contador));
                link.put("version", 1);
                link.put("fromEndId", fromEndId);
                link.put("toEndId", toEndId);
                link.put("linkDirection", defineSentidoEnlace(typeIdEntidadOrigen, typeIdEntidadDestino));
                link.put("properties", revisarPropiedadesEnlace(props, typeIdEntidadOrigen, typeIdEntidadDestino));
                links.add(link);
            }
        }
        return dedupById(links);
    }

    // ===== Helpers (equivalentes a tus funciones Python) =====

    // Id determinístico/legible; ajústalo si ya tienes tu propio "define_id_enlace"
    private static String defineIdEnlace(String seed, String toEndId, String typeIdOrigen, String typeIdDestino) {
        return String.join("|", "L", safe(seed), safe(typeIdOrigen), "->", safe(typeIdDestino), safe(toEndId));
    }

    private static String safe(String s) { return s == null ? "" : s.replaceAll("\\s+", "_"); }

    // Si necesitas direccionalidad, ajusta esta lógica
    private static String defineSentidoEnlace(String typeIdOrigen, String typeIdDestino) {
        // "UNDIRECTED" o "DIRECTED" según tu esquema ANB; aquí lo dejamos "UNDIRECTED" por defecto
        return "NONE";
    }

    // Si en tu Python haces validaciones/normalización, hazlo aquí
    private static Map<String, Object> revisarPropiedadesEnlace(
            Map<String, Object> props,
            String typeIdEntidadOrigen,
            String typeIdEntidadDestino
    ) {
        return (props == null) ? Collections.emptyMap() : props;
    }

    // Deduplicado por "id" (como tu dict por id en Python)
    public static List<Map<String, Object>> dedupById(List<Map<String, Object>> links) {
        Map<String, Map<String, Object>> idx = new LinkedHashMap<>();
        for (Map<String, Object> l : links) {
            String id = String.valueOf(l.getOrDefault("id", ""));
            if (!id.isEmpty()) idx.put(id, l);
        }
        return new ArrayList<>(idx.values());
    }
}

