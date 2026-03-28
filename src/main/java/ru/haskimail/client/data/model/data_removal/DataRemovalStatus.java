package ru.haskimail.client.data.model.data_removal;

/**
 * Статус запроса на удаление данных.
 */
public class DataRemovalStatus {
    private Integer id;
    private DataRemovalStatusTypes status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public DataRemovalStatusTypes getStatus() { return status; }
    public void setStatus(DataRemovalStatusTypes status) { this.status = status; }
}
