package ru.haskimail.client.data.model.servers;

import ru.haskimail.client.data.model.server.Server;
import java.util.List;

/**
 * Коллекция серверов.
 */
public class Servers {
    private Integer totalCount;
    private List<Server> servers;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<Server> getServers() { return servers; }
    public void setServers(List<Server> servers) { this.servers = servers; }
}
