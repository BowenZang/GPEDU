package org.example.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 15:00:32
 */
public final class TicketFactory {

    private static final Map<String, ITicket> TICKET_MAP = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (!TICKET_MAP.containsKey(key)) {
            TICKET_MAP.putIfAbsent(key, new TrainTicket(from, to));
        }
        return TICKET_MAP.get(key);
    }
}
